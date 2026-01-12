// Clase Docente
package com.mycompany.classroom;


/**
 * Clase que representa a un Docente.
 */
public class Docente extends Usuario {

    public Docente(String nombreDoc, String correoDoc, String contrasenaDoc) {
         super(nombreDoc, correoDoc, contrasenaDoc);
    }
    //Se le permite al docente crear un curso 
    public Curso crearCurso(String titulo) {
        Curso nuevo = new Curso(titulo);
        System.out.println("Curso creado: " + titulo);
        return nuevo;
    }
//Publicara contenido en el curso el cual sera visible para todos aquellos que esten matriculados
    public void publicarContenido(Curso curso, String titulo, String texto) {
        curso.contenidos.add(new Contenido(titulo, texto));
        System.out.println("Contenido publicado en curso: " + curso.titulo);
    }
//Podra crear una actividad para los estudiantes
    public void crearActividad(Curso curso, String titulo, String descripcion, String fechaEntrega) {
        Actividad nueva = new Actividad(titulo, descripcion, fechaEntrega);
        curso.actividades.add(nueva);
        System.out.println("Actividad creada: " + titulo);
    }
//Calificar la actividad que haya creado
    public void calificar(Curso curso, Estudiante e, int nota) {
        int i = 0;
        while (i < e.actividadesSubidas.size()) {
            e.actividadesSubidas.get(i).calificacion = nota;
            i++;
        }
        System.out.println("Actividades calificadas para " + e.nombre);
    }
/*Podra ver todas las actividades descriptivamente hablando, es decir con su titulo, su fecha, su descripcion y la calificacion 
    que se le puso estudiante 
    */
    public void verActividadesEstudiante(Estudiante e) {
        System.out.println("Actividades de " + e.nombre + ":");
        int i = 0;
        while (i < e.actividadesSubidas.size()) {
            e.actividadesSubidas.get(i).mostrarDetalle();
            i++;
        }
    }

}
