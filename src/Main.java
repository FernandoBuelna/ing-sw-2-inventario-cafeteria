import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

import Cafeteria.*;
import Cafeteria.Inventario;

public class Main {
    // Inicialización de objetos y variables estáticas
    static Scanner teclado  = new Scanner(System.in);// Instancia de Scanner para leer la entrada
    static Usuario admin    = new Usuario("Admin", "123", "Administrador");// Usuario administrador
    static Usuario empleado = new Usuario("emp", "123", "Empleado");// Usuario empleado
    static int decision;// Variable para las decisiones de menú
    public static Inventario inventario   = new Inventario(new ArrayList<Producto>(Arrays.asList(new Producto(1, "Agua", 10.0, 5))));// Inventario inicial con un producto
    public static GestorDeUsuario gestor  = new GestorDeUsuario(new ArrayList<Usuario>(Arrays.asList(new Usuario("Emp", "123", "Empleado"))));// Gestor de usuarios con un empleado predefinido
    public static void main(String[] args) {
        // Agregar los usuarios predefinidos (admin y empleado) al gestor
        gestor.agregarUsuario(admin);
        gestor.agregarUsuario(empleado);
        int decisionInicial;// Variable para la decisión del usuario en el menú principal
        do{
            System.out.println("---------Bienvenido---------");
            System.out.println("----------------------------");
            System.out.println("---1: Ingresar al sistema---");// Opción para iniciar sesión
            System.out.println("---2: Salir del sistema-----");// Opción para salir
            System.out.println("----------------------------");
            System.out.print("Que desea hacer: ");
            decisionInicial = teclado.nextInt();
            teclado.nextLine();

            switch (decisionInicial) {
                case 1:
                    Login();// Llamar a la función de inicio de sesión
                    break;
                case 2:
                    System.out.println("Saliendo del sistema...");
            }
        }while(decisionInicial != 2);// Repetir hasta que se seleccione salir
    }

    public static void Login() {
        System.out.println("----------------------------");
        // Pedir el nombre de usuario
        System.out.print("Ingrese su usuario: ");
        String usuario = teclado.nextLine(); // Leer el nombre de usuario
        System.out.println("----------------------------");
        // Pedir la contrasena
        System.out.print("Ingrese su contraseña: ");
        String contrasena = teclado.nextLine(); // Leer la contrasena
        // Buscar el usuario en el sistema
        Usuario usuarioEncontrado = gestor.buscarUsuarioPorNombre(usuario);
        // Verificar si el usuario existe y la contrasena es correcta
        if ( usuarioEncontrado != null && usuarioEncontrado.getContrasena().equals(contrasena) ) {
            System.out.println("----------------------------");
            System.out.println("Inicio de sesión exitoso."); // Inicio exitoso
            // Verificar si el usuario es Administrador
            if( usuarioEncontrado.getPuesto().equals("Administrador") ) {
                funcionesAdministrador(); // Llamar funciones de administrador
            }
            // Verificar si el usuario es Empleado
            else if(usuarioEncontrado.getPuesto().equals("Empleado")) {
                funcionesEmpleado(); // Llamar funciones de empleado
            }
        } else {
            // Mensaje de error si usuario o contrasena son incorrectos
            System.out.println("----------------------------");
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }

    public static void funcionesAdministrador() {
        do {
            // Mostrar el menu de opciones para el administrador
            System.out.println("----------------------------");
            System.out.println("--Bienvenido administrador--");
            System.out.println("----------------------------");
            System.out.println("---1: Ver inventario-------"); // Opcion para ver el inventario
            System.out.println("---2: Agregar producto-----"); // Opcion para agregar productos
            System.out.println("---3: Eliminar producto----"); // Opcion para eliminar productos
            System.out.println("---4: Editar producto------"); // Opcion para editar productos
            System.out.println("---5: Gestionar Usuarios---"); // Opcion para gestionar usuarios
            System.out.println("---6: Salir del sistema----"); // Salir del menu
            System.out.println("----------------------------");
            System.out.print("Que desea hacer: ");
            decision = teclado.nextInt(); // Leer la decision del administrador
            teclado.nextLine(); // Limpiar buffer del scanner

            // Evaluar la decision del administrador
            switch (decision) {
                case 1:
                    verProductos(); // Mostrar los productos del inventario
                    break;
                case 2:
                    agregarProuctos(); // Llamar funcion para agregar productos
                    break;
                case 3:
                    verProductos(); // Mostrar productos antes de eliminar
                    eliminarProductos(); // Llamar funcion para eliminar productos
                    break;
                case 4:
                    verProductos(); // Mostrar productos antes de editar
                    editarProductos(); // Llamar funcion para editar productos
                    break;
                case 5:
                    gestionarUsuarios(); // Llamar funcion para gestionar usuarios
                    break;
                default:
                    // No hacer nada si la decision no corresponde a una opcion valida
            }
        } while (decision != 6); // Repetir hasta que la decision sea salir
    }

    public static void funcionesEmpleado() {
        do {
            // Mostrar el menu de opciones para el empleado
            System.out.println("----------------------------");
            System.out.println("----Bienvenido empleado!----");
            System.out.println("----------------------------");
            System.out.println("---1: Ver inventario-------"); // Opcion para ver el inventario
            System.out.println("------2: Hacer venta-------"); // Opcion para realizar una venta
            System.out.println("---3: Salir del sistema----"); // Salir del menu
            System.out.println("----------------------------");
            System.out.print("Que desea hacer: ");
            decision = teclado.nextInt(); // Leer la decision del empleado
            teclado.nextLine(); // Limpiar buffer del scanner

            // Evaluar la decision del empleado
            switch (decision) {
                case 1:
                    verProductos(); // Mostrar los productos del inventario
                    break;
                case 2:
                    verProductos(); // Mostrar productos antes de realizar la venta
                    venderProducto(); // Llamar funcion para procesar la venta
                    break;
            }
        } while (decision != 3); // Repetir hasta que la decision sea salir
    }


    public static void verProductos() {
        // Mostrar todos los productos en el inventario
        System.out.println("------------------------------------------------");
        for ( Producto producto : inventario.getProductos() ) {
            // Imprimir los detalles de cada producto
            System.out.println("Codigo: " + producto.getCodigo() + ", Nombre: " + producto.getNombre() +
                    ", Precio: " + producto.getPrecio() + ", Cantidad: " + producto.getCantidad());
            System.out.println("----------------------------------------------");
        }
    }


    public static void agregarProuctos() {
        // Pedir datos del nuevo producto
        System.out.println("----------------------------");
        System.out.print("Ingrese el Codigo del producto: ");
        int codigoNuevo = teclado.nextInt(); // Leer el codigo del producto
        teclado.nextLine(); // Limpiar buffer del scanner
        System.out.println("----------------------------");
        System.out.print("Ingrese el nombre del producto: ");
        String nombreNuevo = teclado.next(); // Leer el nombre del producto
        System.out.println("----------------------------");
        System.out.print("Ingrese el precio del producto: ");
        double precioNuevo = teclado.nextDouble(); // Leer el precio del producto
        System.out.println("----------------------------");
        System.out.print("Ingrese la cantidad del producto: ");
        int cantidadNuevo = teclado.nextInt(); // Leer la cantidad del producto
        teclado.nextLine(); // Limpiar buffer del scanner

        // Crear el nuevo producto y agregarlo al inventario
        Producto nuevoProducto = new Producto(codigoNuevo, nombreNuevo, precioNuevo, cantidadNuevo);
        inventario.agregarProducto(nuevoProducto);

        // Confirmar que el producto fue agregado
        System.out.println("-------------------------------");
        System.out.println("Producto agregado al inventario");
        System.out.println("-------------------------------");
    }


    public static void eliminarProductos() {
        // Pedir el codigo del producto a eliminar
        System.out.print("Ingrese el codigo del producto a eliminar: ");
        int codigoEliminar = teclado.nextInt(); // Leer el codigo del producto
        teclado.nextLine(); // Limpiar buffer del scanner

        // Buscar el producto en el inventario
        Producto productoEliminar = inventario.buscarProductoPorCodigo(codigoEliminar);

        // Verificar si el producto existe
        if ( productoEliminar != null ) {
            // Eliminar el producto si se encuentra
            inventario.eliminarProducto(productoEliminar);
            System.out.println("----------------------------");
            System.out.println("Producto eliminado del inventario");
            System.out.println("----------------------------");
        } else {
            // Mensaje si el producto no se encuentra
            System.out.println("----------------------------");
            System.out.println("No se encontro el producto");
            System.out.println("----------------------------");
        }
    }


    public static void editarProductos() {
        // Pedir el codigo del producto a editar
        System.out.print("Ingrese el codigo del producto a editar: ");
        int codigoProductoEditar = teclado.nextInt(); // Leer el codigo del producto
        teclado.nextLine(); // Limpiar buffer del scanner

        // Buscar el producto en el inventario
        Producto productoEditar = inventario.buscarProductoPorCodigo(codigoProductoEditar);

        // Verificar si el producto existe
        if ( productoEditar != null ) {
            // Pedir nuevos datos para el producto
            System.out.println("----------------------------");
            System.out.print("Ingrese el nuevo codigo del producto: ");
            int codigoEditar = teclado.nextInt(); // Leer nuevo codigo
            System.out.println("----------------------------");
            System.out.print("Ingrese el nuevo nombre del producto: ");
            String nombreEditar = teclado.next(); // Leer nuevo nombre
            System.out.println("----------------------------");
            System.out.print("Ingrese el nuevo precio del producto: ");
            double precioEditar = teclado.nextDouble(); // Leer nuevo precio
            System.out.println("----------------------------");
            System.out.print("Ingrese la nueva cantidad del producto: ");
            int cantidadEditar = teclado.nextInt(); // Leer nueva cantidad
            teclado.nextLine(); // Limpiar buffer del scanner

            // Actualizar el producto con los nuevos datos
            productoEditar.setCodigo(codigoEditar);
            productoEditar.setNombre(nombreEditar);
            productoEditar.setPrecio(precioEditar);
            productoEditar.setCantidad(cantidadEditar);

            // Confirmar la edicion del producto
            System.out.println("----------------------------");
            System.out.println("Producto editado en el inventario");
            System.out.println("----------------------------");
        } else {
            // Mensaje si el producto no se encuentra
            System.out.println("----------------------------");
            System.out.println("No se encontro el producto");
            System.out.println("----------------------------");
        }
    }


    public static void verUsuarios() {
        // Recorrer y mostrar la lista de usuarios
        for ( Usuario usuario : gestor.getUsuarios() ) {
            System.out.println("----------------------------");
            // Imprimir el nombre y puesto de cada usuario
            System.out.println("Nombre: " + usuario.getNombre() + ", Puesto: " + usuario.getPuesto());
            System.out.println("----------------------------");
        }
    }


    public static void venderProducto() {
        double total = 0; // Acumulador para el total de la venta
        boolean otroProducto = true; // Control para agregar más productos al carrito

        while (otroProducto) {
            // Mostrar encabezado de la venta
            System.out.println("----------------------------");
            System.out.println("----Venta de productos----");
            System.out.println("----------------------------");

            // Solicitar el código del producto
            System.out.print("Ingrese el codigo del producto: ");
            int codigo = teclado.nextInt();
            teclado.nextLine(); // Limpiar buffer del scanner

            // Buscar el producto en el inventario
            Producto producto = inventario.buscarProductoPorCodigo(codigo);

            if ( producto != null ) {
                // Solicitar la cantidad a vender
                System.out.println("----------------------------");
                System.out.print("Ingrese la cantidad: ");
                int cantidad = teclado.nextInt();
                teclado.nextLine(); // Limpiar buffer del scanner

                // Verificar si hay suficiente stock
                if ( cantidad <= producto.getCantidad() ) {
                    // Calcular el total y actualizar el stock
                    total += producto.getPrecio() * cantidad;
                    producto.setCantidad(producto.getCantidad() - cantidad);
                    System.out.println("----------------------------");
                    System.out.println("Producto agregado al carrito");
                } else {
                    System.out.println("----------------------------");
                    System.out.println("Cantidad no disponible en stock");
                }
            } else {
                System.out.println("----------------------------");
                System.out.println("Producto no encontrado");
            }

            // Preguntar si desea agregar otro producto
            System.out.println("----------------------------");
            System.out.print("Desea agregar otro producto? (s/n): ");
            String respuesta = teclado.nextLine();
            if ( respuesta.equalsIgnoreCase("n") ) {
                otroProducto = false; // Terminar la venta si la respuesta es 'n'
            }
        }

        // Mostrar el total a pagar
        System.out.println("----------------------------");
        System.out.println("Total a pagar: " + total);
        System.out.println("----------------------------");

        // Solicitar el importe pagado por el cliente
        System.out.print("Ingrese el importe: ");
        double importe = teclado.nextDouble();
        teclado.nextLine(); // Limpiar buffer del scanner

        // Calcular el cambio y mostrarlo
        double cambio = importe - total;
        System.out.println("----------------------------");
        System.out.println("Cambio: " + cambio);
        System.out.println("----------------------------");
    }

    public static void gestionarUsuarios() {
        do {
            // Mostrar el menú de opciones para gestionar usuarios
            System.out.println("----------------------------");
            System.out.println("---Gestionar usuarios---");
            System.out.println("----------------------------");
            System.out.println("1. Ver usuarios"); // Opción para listar usuarios
            System.out.println("----------------------------");
            System.out.println("2. Agregar usuario"); // Opción para agregar un nuevo usuario
            System.out.println("----------------------------");
            System.out.println("3. Eliminar usuario"); // Opción para eliminar un usuario existente
            System.out.println("----------------------------");
            System.out.println("4. Volver al menú principal"); // Salir de la gestión de usuarios
            System.out.println("----------------------------");
            System.out.print("Que desea hacer: ");
            decision = teclado.nextInt(); // Leer la decisión del usuario
            teclado.nextLine(); // Limpiar buffer del scanner

            // Evaluar la opción seleccionada
            switch (decision) {
                case 1:
                    verUsuarios(); // Llamar función para listar usuarios
                    break;
                case 2:
                    agregarUsuario(); // Llamar función para agregar un usuario
                    break;
                case 3:
                    verUsuarios(); // Listar usuarios antes de proceder a eliminar
                    eliminarUsuario(); // Llamar función para eliminar un usuario
                    break;
                default:
                    System.out.println("Volviendo a la pantalla principal...");
            }
        } while ( decision != 4 ); // Repetir hasta que la opción sea volver al menú principal
    }


    public static void eliminarUsuario() {
        // Mostrar encabezado de la opción de eliminar usuario
        System.out.println("----------------------------");
        System.out.println("---Eliminar usuario---");
        System.out.println("----------------------------");

        // Solicitar el nombre del usuario a eliminar
        System.out.print("Ingrese el nombre de usuario a eliminar: ");
        String nombreUsuarioEliminar = teclado.nextLine(); // Leer el nombre del usuario

        // Buscar el usuario en el gestor por su nombre
        Usuario usuarioEliminar = gestor.buscarUsuarioPorNombre(nombreUsuarioEliminar);

        // Verificar si el usuario existe
        if ( usuarioEliminar != null ) {
            // Eliminar el usuario si se encuentra
            gestor.eliminarUsuario(usuarioEliminar);
            System.out.println("----------------------------");
            System.out.println("Usuario eliminado exitosamente.");
        } else {
            // Mensaje si el usuario no se encuentra
            System.out.println("----------------------------");
            System.out.println("No se encontró el usuario.");
        }
    }

    public static void agregarUsuario() {
        // Mostrar encabezado de la opción de agregar un nuevo usuario
        System.out.println("----------------------------");
        System.out.println("---Añadir nuevo usuario---");
        System.out.println("----------------------------");

        // Solicitar el nombre del nuevo usuario
        System.out.print("Ingrese el nombre de usuario: ");
        String nuevoNombreUsuario = teclado.nextLine(); // Leer el nombre del usuario

        // Solicitar la contraseña del nuevo usuario
        System.out.println("----------------------------");
        System.out.print("Ingrese la contraseña: ");
        String nuevaContrasena = teclado.nextLine(); // Leer la contraseña

        // Solicitar el puesto del nuevo usuario
        System.out.println("----------------------------");
        System.out.print("Ingrese el puesto: ");
        String nuevoPuesto = teclado.nextLine(); // Leer el puesto

        // Crear el nuevo usuario
        Usuario nuevoUsuario = new Usuario(nuevoNombreUsuario, nuevaContrasena, nuevoPuesto);

        // Agregar el nuevo usuario al gestor
        gestor.agregarUsuario(nuevoUsuario);

        // Confirmar la adición del nuevo usuario
        System.out.println("----------------------------");
        System.out.println("Usuario agregado exitosamente.");
    }
}