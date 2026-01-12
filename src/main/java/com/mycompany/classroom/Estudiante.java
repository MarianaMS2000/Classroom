// Clase Estudiante
package com.mycompany.classroom;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que representa a un Estudiante.
 */
public class Estudiante extends Usuario {

    ArrayList<Curso> cursosMatriculados;
    ArrayList<Actividad> actividadesSubidas;
    ArrayList<String> calificaciones;

    public Estudiante(String nombreEst, String correoEst, String contrasenaEst) {
        super(nombreEst, correoEst, contrasenaEst); 
        cursosMatriculados = new ArrayList<>();
        actividadesSubidas = new ArrayList<>();
        calificaciones = new ArrayList<>();
    }
/*Le permite al estudiante automatricularse en un curso para acceder a todo su contenido 
    unicamente si el profesor ya creo el curso
    */  
    public void matricular(Curso curso) {
        if (!cursosMatriculados.contains(curso)) {
            cursosMatriculados.add(curso);
            curso.estudiantes.add(this); // AÑADE al curso
            System.out.println("Te has matriculado en: " + curso.titulo);
        } else {
            System.out.println("Ya estas matriculado en este curso.");
        }
    }
// Visualizara todos los cursos a los que se haya matriculado 
    public void verCursosMatriculados() {
        if (cursosMatriculados.isEmpty()) {
            System.out.println("No estas matriculado en ningun curso.");
        } else {
            System.out.println("Cursos matriculados:");
            int i = 0;
            while (i < cursosMatriculados.size()) {
                System.out.println((i + 1) + ". " + cursosMatriculados.get(i).titulo);
                i++;
            }
        }
    }
/*Podra subir su tarea a una actividad que haya sido previamente creada por el profesor,
    si el profesor no la ha creado se validara y mostrara un mensaje en la consola avisando que no 
    hay actividad
    */    
    public void responderActividad() {
        Scanner leer = new Scanner(System.in);
        if (cursosMatriculados.isEmpty()) {
            System.out.println("No estas matriculado en ningun curso.");
            return;
        }

        int i = 0;
        System.out.println("Cursos disponibles:");
        while (i < cursosMatriculados.size()) {
            System.out.println((i + 1) + ". " + cursosMatriculados.get(i).titulo);
            i++;
        }

        System.out.print("Seleccione un curso: ");
        int opcCurso = leer.nextInt() - 1;
        leer.nextLine();

        if (opcCurso < 0 || opcCurso >= cursosMatriculados.size()) {
            System.out.println("Curso invalido.");
            return;
        }

        Curso curso = cursosMatriculados.get(opcCurso);

        if (curso.actividades.isEmpty()) {
            System.out.println("Este curso no tiene actividades.");
            return;
        }

        i = 0;
        System.out.println("Actividades disponibles:");
        while (i < curso.actividades.size()) {
            Actividad a = curso.actividades.get(i);
            System.out.println((i + 1) + ". " + a.titulo + " - " + a.descripcion);
            i++;
        }

        System.out.print("Seleccione una actividad: ");
        int opcActividad = leer.nextInt() - 1;
        leer.nextLine();

        if (opcActividad < 0 || opcActividad >= curso.actividades.size()) {
            System.out.println("Actividad incorrecta.");
            return;
        }

        System.out.print("Escribe tu respuesta: ");
        String respuesta = leer.nextLine();

        Actividad actividad = curso.actividades.get(opcActividad);
        actividad.subirRespuesta(this, respuesta);
        this.actividadesSubidas.add(actividad);


        System.out.println("Respuesta enviada correctamente.");
    }
/*
    Podra ver esas notas que el docente le haya puesto 
    */
    public void verCalificaciones() {
    if (actividadesSubidas.isEmpty()) {
        System.out.println("No tienes calificaciones aun.");
        return;
    }

    int i = 0;
    while (i < actividadesSubidas.size()) {
        Actividad a = actividadesSubidas.get(i);
        System.out.println("Curso: " + a.curso.titulo); // si guardas el curso en la actividad
        System.out.println("Titulo: " + a.titulo);
            System.out.println("Descripcion: " + a.descripcion);
            System.out.println("Fecha de entrega: " + a.fechaEntrega);
            if (a.calificacion == -1) {
                System.out.println("Calificacion: Pendiente");
            } else {
                System.out.println("Calificacion: " + a.calificacion);
            }
            System.out.println();
            i++;
        }
    }

/*
    Vera todas las actividades que hay en el curso para asi poder escoger cual hacer
    */
    public void verActividadesCursos() {
        // Validar si el estudiante está matriculado en algún curso
        if (cursosMatriculados.isEmpty()) {
            System.out.println("No estas matriculado en ningún curso.");
            return;
        }

        for (int i = 0; i < cursosMatriculados.size(); i++) {
            Curso curso = cursosMatriculados.get(i);
            System.out.println("\nCurso: " + curso.titulo);

            if (curso.actividades.isEmpty()) {
                System.out.println("  No hay actividades asignadas en este curso.");
            } else {
                for (int j = 0; j < curso.actividades.size(); j++) {
                    Actividad a = curso.actividades.get(j);
                    a.mostrarDetalle();

                }
            }
        }
    }
/*
    Vera todo el contenido que el profesor haya subido en el curso
    */
    public void verContenidoCursos() {
        // Validar si el estudiante está matriculado en algún curso
        if (cursosMatriculados.isEmpty()) {
            System.out.println("No estás matriculado en ningun curso.");
            return;
        }

        for (int i = 0; i < cursosMatriculados.size(); i++) {
            Curso curso = cursosMatriculados.get(i);
            System.out.println("\nCurso: " + curso.titulo);

            if (curso.contenidos.isEmpty()) {
                System.out.println("  No hay contenido publicado en este curso.");
            } else {
                for (int j = 0; j < curso.contenidos.size(); j++) {
                    Contenido c = curso.contenidos.get(j);
                    System.out.println("  - " + c.titulo + ": " + c.texto);
                }
            }
        }
    }

}
