package Cafeteria;

public class usuarioTest {
    public void runTest2() {
        testAgregarUsuario();
    }

    public static void testAgregarUsuario() {
        Usuario usuario = new Usuario("Miguel","ing-sw2","Empleado");
        usuario.setNombre("Mike");
        usuario.setContrasena("911");
        usuario.setPuesto("Administrador");
        if(usuario.getNombre() == "Mike" && usuario.getContrasena() == "911"
                && usuario.getPuesto() == "Administrador"){
            System.out.println("TEST2 OK");
        }
        else {
            System.out.println("TEST2 NO");
        }
    }
}
