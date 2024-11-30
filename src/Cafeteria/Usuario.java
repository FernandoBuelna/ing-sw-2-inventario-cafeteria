package Cafeteria;

public class Usuario {
    private String nombre;      // Nombre del usuario
    private String contrasena;  // Contraseña del usuario
    private String puesto;      // Puesto del usuario (Administrador, Empleado, etc.)

    // Constructor de la clase Usuario
    public Usuario(String nombre, String contrasena, String puesto) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.puesto = puesto;
    }

    // Getter para el nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para la contraseña
    public String getContrasena() {
        return contrasena;
    }

    // Setter para la contraseña
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Getter para el puesto
    public String getPuesto() {
        return puesto;
    }

    // Setter para el puesto
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}