package Cafeteria;

import java.util.List;

public class Inventario {
    private List<Producto> productos;

    // Constructor que recibe una lista de productos
    public Inventario(List<Producto> productos) {
        this.productos = productos;
    }

    // Método para agregar un producto al inventario
    public void agregarProducto(Producto producto) {
        // Verificar si el producto ya existe por código
        if (buscarProductoPorCodigo(producto.getCodigo()) == null) {
            productos.add(producto);
        } else {
            System.out.println("El producto con código " + producto.getCodigo() + " ya existe.");
        }
    }

    // Método para eliminar un producto del inventario
    public void eliminarProducto(Producto producto) {
        if (productos.remove(producto)) {
            System.out.println("Producto " + producto.getNombre() + " eliminado.");
        } else {
            System.out.println("El producto " + producto.getNombre() + " no existe.");
        }
    }

    // Obtener la lista de productos
    public List<Producto> getProductos() {
        return productos;
    }

    // Buscar un producto por código
    public Producto buscarProductoPorCodigo(int codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null; // No se encontró el producto
    }
}