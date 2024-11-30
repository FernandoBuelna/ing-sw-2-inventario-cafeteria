package Cafeteria;

public class Producto {
    private String nombre; // Nombre del producto
    private double precio; // Precio del producto
    private int cantidad;  // Cantidad del producto disponible
    private int codigo;    // Código único del producto

    // Constructor de la clase Producto con validaciones
    public Producto(int codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;

        // Validación de precio
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser menor a cero");
        }
        this.precio = precio;

        // Validación de cantidad
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser menor a cero");
        }
        this.cantidad = cantidad;
    }

    // Métodos getter y setter para el nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Setter para nombre
    }

    // Métodos getter y setter para el precio
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser menor a cero"); // Validación en el setter
        }
        this.precio = precio;
    }

    // Métodos getter y setter para la cantidad
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser menor a cero"); // Validación en el setter
        }
        this.cantidad = cantidad;
    }

    // Métodos getter y setter para el código
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo; // Setter para código
    }
}