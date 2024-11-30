package Cafeteria;

import java.util.List;

public class GestorDeUsuario {
    private List<Usuario> usuarios;

    // Constructor que recibe una lista de usuarios
    public GestorDeUsuario(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    // Método para agregar un nuevo usuario
    public void agregarUsuario(Usuario usuario) {
        // Verificar si el usuario ya existe por nombre
        if (buscarUsuarioPorNombre(usuario.getNombre()) == null) {
            usuarios.add(usuario);
        } else {
            System.out.println("El usuario con nombre " + usuario.getNombre() + " ya existe.");
        }
    }

    // Método para eliminar un usuario
    public void eliminarUsuario(Usuario usuario) {
        if (usuarios.contains(usuario)) {
            usuarios.remove(usuario);
        } else {
            System.out.println("El usuario no existe en la lista.");
        }
    }

    // Obtener la lista de usuarios
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    // Buscar un usuario por su nombre
    public Usuario buscarUsuarioPorNombre(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;
            }
        }
        return null; // No se encontró el usuario
    }
}