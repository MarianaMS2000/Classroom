package com.mycompany.classroom;

import java.util.ArrayList;

/**
 * Clase que representa un curso, fue creada para almacenar toda esa informacio de un curso 
 * sus contenidos
 * sus actividades 
 * y sus estudiantes matriculados
 */

class Curso {
    String titulo;
    ArrayList<Contenido> contenidos;
    ArrayList<Actividad> actividades;
    ArrayList<Estudiante> estudiantes;

    public Curso(String titulo) {
        this.titulo = titulo;
        contenidos = new ArrayList<>();
        actividades = new ArrayList<>();
        estudiantes = new ArrayList<>();
    }
}
