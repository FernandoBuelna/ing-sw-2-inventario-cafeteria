package Cafeteria;
public class productoTest {
    public void runTest1() {
        testAgregarProducto();
    }

    public static void testAgregarProducto() {
        Producto producto = new Producto(7,"Aguacate",85,16);
        producto.setCodigo(8);
        producto.setNombre("Pepino");
        producto.setCantidad(120);
        producto.setPrecio(67);
        if(producto.getCodigo() == 8 && producto.getNombre() == "Pepino" && producto.getCantidad()
                == 120 && producto.getPrecio() == 67){
            System.out.println("TEST OK");
        }
        else {
            System.out.println("TEST NO");
        }
    }
}
