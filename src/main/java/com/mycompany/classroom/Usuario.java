// Clase Usuario
package com.mycompany.classroom;

/**
 * Clase para que se puedan crear usuarios.
 */
public class Usuario {

    String nombre;
    String correo;
    String contrasena;

    public Usuario(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }
    
    
    /**
     * Verifica los datos de inicio de sesión usando correo y contraseña.
     */
    public boolean iniciarSesion(String correoIngresado, String contrasenaIngresada) {
        if (correo == null || contrasena == null) {
            return false;
        }

        if (correo.equals(correoIngresado) && contrasena.equals(contrasenaIngresada)) {
            System.out.println("Inicio de sesion exitoso.");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Muestra los datos del perfil del usuario, unicamente muestra lo que el usuario ingreso, no muestra mas informacion personal
     * porque no fue solicitada en consola
     */
    public void verPerfil() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
    }

    /**
     * Cierra la sesión actual.
     */
    public void cerrarSesion() {
        System.out.println("Sesión cerrada.");
    }
}
