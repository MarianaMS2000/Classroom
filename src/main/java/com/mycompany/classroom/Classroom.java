/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.classroom;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Este programa simula una plataforma educativa de una universidad en este caso
 * muy parecida a la plataforma classroom en este caso tendra dos actores que
 * iran interactuando 1. Estudiante: podra registrarse e iniciar sesion despues
 * del registro, luego con estas credenciales podra ingresar a todas las
 * funciones que tendra disponible segun su rol en este caso podra ver su perfil
 * con su informacion personal, ver sus cursos e incluso subir actividades 2.
 * Profesor: Al igual que el estudiante podra hacer el proceso de registro y
 * luego el de autenticacion para acceder a todas esas funciones que tendra como
 * profesor ya sea crear un curso, subir contenido a dicho curso o subir una
 * tarea para luego poder calificarla
 */
/**
 *
 * @author miers
 */
public class Classroom {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        ArrayList<Docente> docentes = new ArrayList<>();
        ArrayList<Curso> cursos = new ArrayList<>();
        //Iniciamos con un menu para elegir el rol a usar
        int rol;
        do {
            System.out.println("\n------PLATAFORMA EDUCATIVA-----------");
            System.out.println("Seleccione su rol:");
            System.out.println("1. Estudiante");
            System.out.println("2. Docente");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");
            rol = leer.nextInt();
            leer.nextLine();

            switch (rol) {
                case 1: // En caso de ser ESTUDIANTE podra acceder a todas esas funciones que va a tener en la plataforma
                    int opcionEst;
                    do {
                        System.out.println("\n--- ESTUDIANTE ---");
                        System.out.println("1. Registrarse");
                        System.out.println("2. Iniciar sesion");
                        System.out.println("3. Volver al menu principal");
                        System.out.print("Opción: ");
                        opcionEst = leer.nextInt();
                        leer.nextLine();

                        switch (opcionEst) {
                            case 1:
                                System.out.println("--- REGISTRO ---");
                                System.out.print("Nombre: ");
                                String nombreEst = leer.nextLine();
                                System.out.print("Correo: ");
                                String correoEstR = leer.nextLine();
                                System.out.print("Contrasena: ");
                                String contrasenaEst = leer.nextLine();
                                Estudiante nuevoEst = new Estudiante(nombreEst, correoEstR, contrasenaEst);
                                estudiantes.add(nuevoEst);
                                System.out.println("Registro exitoso!");
                                break;

                            case 2:
                                System.out.println("--- INICIO DE SESION ---");
                                System.out.print("Correo: ");
                                String correoEst = leer.nextLine();
                                System.out.print("Contrasena: ");
                                String contraEst = leer.nextLine();
                //Validar si las credenciales son correctas en caso de serlo se almacenaran en el objeto previamente creado
                                Estudiante e = null;
                                for (int i = 0; i < estudiantes.size(); i++) {
                                    if (estudiantes.get(i).iniciarSesion(correoEst, contraEst)) {
                                        e = estudiantes.get(i);
                                        break;
                                    }
                                }

                                if (e != null) {
                                    int opc;
                                    do {
                                        System.out.println("\nQue desea hacer?");
                                        System.out.println("1. Ver perfil");
                                        System.out.println("2. Ver cursos y matricularse");
                                        System.out.println("3. Ver cursos matriculados");
                                        System.out.println("4. Ver contenido de cursos");
                                        System.out.println("5. Ver actividades");
                                        System.out.println("6. Subir actividad");
                                        System.out.println("7. Ver calificaciones");
                                        System.out.println("8. Cerrar sesion");
                                        System.out.print("Seleccione una opcion: ");
                                        opc = leer.nextInt();
                                        leer.nextLine();

                                        switch (opc) {
                                            case 1:
                                                e.verPerfil();
                                                break;
                                            case 2:
                                                /*
                                                Primero se debe validar que el profesor ya haya creado el curso, en caso de ser asi 
                                                podra matricularse en el curso que escoja
                                                */
                                                if (cursos.isEmpty()) {
                                                    System.out.println("No hay cursos disponibles.");
                                                    break;
                                                }
                                                for (int i = 0; i < cursos.size(); i++) {
                                                    System.out.println((i + 1) + ". " + cursos.get(i).titulo);
                                                }
                                                System.out.print("Seleccione un curso: ");
                                                int idx = leer.nextInt();
                                                leer.nextLine();
                                                if (idx > 0 && idx <= cursos.size()) {
                                                    e.matricular(cursos.get(idx - 1));
                                                }
                                                break;
                                            case 3:
                                                e.verCursosMatriculados();
                                                break;
                                            case 4:
                                                e.verContenidoCursos();
                                                break;
                                            case 5:
                                                e.verActividadesCursos();

                                                break;
                                            case 6:
                                                //Debe validarse que este en un curso para asi poder subir una actividad
                                                if (e.cursosMatriculados.isEmpty()) {
                                                    System.out.println("Debes estar matriculado en al menos un curso.");
                                                    break;
                                                }
                                                e.responderActividad();
                                                break;
                                            case 7:
                                                e.verCalificaciones();

                                                break;
                                            case 8:
                                                e.cerrarSesion();
                                                break;
                                        }
                                    } while (opc != 8);
                                } else {
                                    System.out.println("Credenciales incorrectas.");
                                }
                                break;
                        }
                    } while (opcionEst != 3);
                    break;

                case 2: // En caso de ser DOCENTE podra acceder a todas esas funciones que va a tener en la plataforma
                    int opcionDoc;
                    do {
                        System.out.println("\n--- DOCENTE ---");
                        System.out.println("1. Registrarse");
                        System.out.println("2. Iniciar sesion");
                        System.out.println("3. Volver al menu principal");
                        System.out.print("Opcion: ");
                        opcionDoc = leer.nextInt();
                        leer.nextLine();

                        switch (opcionDoc) {
                            case 1:
                                System.out.println("--- REGISTRO ---");
                                System.out.print("Nombre: ");
                                String nombreDoc = leer.nextLine();
                                System.out.print("Correo: ");
                                String correoDocR = leer.nextLine();
                                System.out.print("Contrasena: ");
                                String contrasenaDoc = leer.nextLine();
                                Docente nuevoDoc = new Docente(nombreDoc, correoDocR, contrasenaDoc);
                                docentes.add(nuevoDoc);
                                System.out.println("Registro exitoso!");
                                break;

                            case 2:
                                System.out.println("--- INICIO DE SESION ---");
                                System.out.print("Correo: ");
                                String correoDoc = leer.nextLine();
                                System.out.print("Contrasena: ");
                                String contraDoc = leer.nextLine();
                                //Al igual que con el estudiante se validaran creedenciales y se almacenaran si son correctas
                                Docente d = null;
                                for (int i = 0; i < docentes.size(); i++) {
                                    if (docentes.get(i).iniciarSesion(correoDoc, contraDoc)) {
                                        d = docentes.get(i);
                                        break;
                                    }
                                }
/*
                                En todos los casos se debe validar primero que el caso 2 haya sido ejecutado
                                si el caso dos no fue hecho arrojara el mensaje informando que un curso aun no ha sido creado
                                */
                                if (d != null) {
                                    int opc;
                                    do {
                                        System.out.println("\nQue desea hacer?");
                                        System.out.println("1. Ver perfil");
                                        System.out.println("2. Crear curso");
                                        System.out.println("3. Publicar contenido");
                                        System.out.println("4. Crear actividad");
                                        System.out.println("5. Calificar estudiante");
                                        System.out.println("6. Ver actividades estudiante");
                                        System.out.println("7. Cerrar sesion");
                                        System.out.print("Seleccione una opcion: ");
                                        opc = leer.nextInt();
                                        leer.nextLine();

                                        switch (opc) {
                                            case 1:
                                                d.verPerfil();
                                                break;
                                            case 2:
                                                System.out.print("Titulo del curso: ");
                                                String titulo = leer.nextLine();
                                                Curso nuevo = d.crearCurso(titulo);
                                                cursos.add(nuevo);
                                                break;
                                            case 3:
                                                if (cursos.isEmpty()) {
                                                    System.out.println("No se ha creado un curso.");
                                                    break;
                                                }

                                                System.out.println("Cursos disponibles:");
                                                for (int i = 0; i < cursos.size(); i++) {
                                                    System.out.println((i + 1) + ". " + cursos.get(i).titulo);
                                                }
                                                System.out.print("Seleccione un curso por número: ");
                                                //cin = curso indice
                                                int cin = leer.nextInt() - 1;
                                                leer.nextLine();

                                                if (cin >= 0 && cin < cursos.size()) {
                                                    Curso curso = cursos.get(cin);
                                                    System.out.print("Titulo del contenido: ");
                                                    String tit = leer.nextLine();
                                                    System.out.print("Texto del contenido: ");
                                                    String texto = leer.nextLine();
                                                    d.publicarContenido(curso, tit, texto);
                                                }
                                                break;

                                            case 4:
                                                if (cursos.isEmpty()) {
                                                    System.out.println("No se ha creado un curso.");
                                                    break;
                                                }

                                                System.out.println("Cursos disponibles:");
                                                for (int i = 0; i < cursos.size(); i++) {
                                                    System.out.println((i + 1) + ". " + cursos.get(i).titulo);
                                                }
                                                System.out.print("Seleccione un curso por numero: ");
                                                int ci = leer.nextInt() - 1;
                                                leer.nextLine();
//Rellenar toda la informacion de la actividad para que el usuario pueda visualizar en pantalla cuando la solicite
                                                if (ci >= 0 && ci < cursos.size()) {
                                                    Curso curso = cursos.get(ci);
                                                    System.out.print("Titulo: ");
                                                    String t = leer.nextLine();
                                                    System.out.print("Descripcion: ");
                                                    String desc = leer.nextLine();
                                                    System.out.print("Fecha: ");
                                                    String f = leer.nextLine();
                                                    d.crearActividad(curso, t, desc, f);
                                                }
                                                break;
                                            case 5:
                                                /*Permite el docente calificar un estudiante en especifico
                                                se solicitara en consola toda esa informacion tanto al estudiante como el curso 
                                                */
                                                
                                                if (cursos.isEmpty() || estudiantes.isEmpty()) {
                                                    System.out.println("No hay cursos o estudiantes registrados para calificar.");
                                                    break;
                                                }

                                                for (int i = 0; i < cursos.size(); i++) {
                                                    System.out.println((i + 1) + ". " + cursos.get(i).titulo);
                                                }
                                                System.out.print("Seleccione un curso: ");
                                                int cursoSeleccionado = leer.nextInt() - 1;
                                                leer.nextLine();

                                                if (cursoSeleccionado < 0 || cursoSeleccionado >= cursos.size()) {
                                                    System.out.println("Curso invalido.");
                                                    break;
                                                }

                                                Curso curso = cursos.get(cursoSeleccionado);
                                                if (curso.estudiantes.isEmpty()) {
                                                    System.out.println("No hay estudiantes matriculados en este curso.");
                                                    break;
                                                }

                                                for (int i = 0; i < curso.estudiantes.size(); i++) {
                                                    System.out.println((i + 1) + ". " + curso.estudiantes.get(i).nombre);
                                                }
                                                System.out.print("Seleccione un estudiante: ");
                                                int estudianteSeleccionado = leer.nextInt() - 1;
                                                leer.nextLine();

                                                if (estudianteSeleccionado < 0 || estudianteSeleccionado >= curso.estudiantes.size()) {
                                                    System.out.println("Estudiante incorrecto.");
                                                    break;
                                                }

                                                System.out.print("Ingrese la nota: ");
                                                int nota = leer.nextInt();
                                                d.calificar(curso, curso.estudiantes.get(estudianteSeleccionado), nota);
                                                break;

                                            case 6:
                                                if (!estudiantes.isEmpty()) {
                                                    d.verActividadesEstudiante(estudiantes.get(0));
                                                } else {
                                                    System.out.println("No hay estudiantes registrados");
                                                }
                                                break;

                                            case 7:
                                                d.cerrarSesion();
                                                break;
                                        }

                                    } while (opc != 7);
                                } else {
                                    System.out.println("Credenciales incorrectas.");
                                }
                                break;
                        }
                    } while (opcionDoc != 3);
                    break;

                case 3:
                    System.out.println("Saliendo.........");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

        } while (rol != 3);
    }
}
