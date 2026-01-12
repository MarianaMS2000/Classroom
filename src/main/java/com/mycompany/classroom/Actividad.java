package com.mycompany.classroom;

import java.util.ArrayList;

/**
 * Clase que representa una actividad de un curso.
 */
public class Actividad {

    String titulo;
    String descripcion;
    String fechaEntrega;
    int calificacion = -1;
    ArrayList<Estudiante> estudiantesQueRespondieron;
    ArrayList<String> respuestas;
    Curso curso;
    
    public Actividad(String titulo, String descripcion, String fechaEntrega) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
        this.calificacion = calificacion;
        this.estudiantesQueRespondieron = new ArrayList<>();
        this.respuestas = new ArrayList<>();
    }

    /**
     * Muestra el detalle de la actividad.
     */
    public void mostrarDetalle() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Fecha de entrega: " + fechaEntrega);
        System.out.println("Calificacion: " + calificacion);
    }

    // Permite guardar la tarea que un estudiante haya subido
    public void subirRespuesta(Estudiante estudiante, String respuesta) {
        estudiantesQueRespondieron.add(estudiante);
        respuestas.add(respuesta);
    }

}
