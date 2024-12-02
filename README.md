Sistema de Gestion de Inventario y Ventas  

Este programa es un sistema basico de gestion de inventario y ventas para una cafeteria.  
Permite a usuarios con distintos roles (administrador y empleado) realizar operaciones como  
ver el inventario, gestionar productos, realizar ventas y administrar usuarios.  

Caracteristicas  
- Inicio de Sesion: Los usuarios pueden iniciar sesion con credenciales.  
- Roles de Usuario: Administrador y empleado, cada uno con diferentes permisos.  
- Gestion de Inventario: Ver, agregar, editar y eliminar productos.  
- Ventas: Procesamiento de ventas con calculo de totales y cambio.  
- Gestion de Usuarios: Agregar y eliminar usuarios del sistema (solo para administradores).  
- El programa utiliza clases complementarias (Usuario, Producto, Inventario, GestorDeUsuario).  

Manual de Usuario  

Inicio de Sesion
- Al ejecutar el programa, elige la opcion 1 para ingresar al sistema.  
- Ingresa tu nombre de usuario y contrasena cuando se te solicite.  
- Si las credenciales son correctas, accedes al menu correspondiente a tu rol:  
  - Administrador: Menu de gestion completa.  
  - Empleado: Menu limitado a inventario y ventas.  

Menu de Administrador 
1. Ver inventario: Muestra todos los productos disponibles con sus detalles.  
2. Agregar producto: Permite anadir un nuevo producto solicitando sus atributos (codigo, nombre, precio, cantidad).  
3. Eliminar producto: Solicita el codigo del producto a eliminar.  
4. Editar producto: Permite modificar los atributos de un producto existente.  
5. Gestionar usuarios:  
   - Ver usuarios: Enlista todos los usuarios registrados.  
   - Agregar usuario: Solicita el nombre, contrasena y puesto del nuevo usuario.  
   - Eliminar usuario: Solicita el nombre del usuario a eliminar.  
6. Salir del sistema: Cierra sesion.  

Menu de Empleado
1. Ver inventario: Muestra los productos disponibles.  
2. Hacer venta:  
   - Selecciona los productos ingresando su codigo.  
   - Indica la cantidad a vender.  
   - Finaliza el pago e imprime el total y el cambio.  
3. Salir del sistema: Cierra sesion.  

Errores Comunes  
- Usuario o contrasena incorrectos: Verifica que las credenciales sean correctas.  
- Producto no encontrado: Asegurate de ingresar un codigo valido.  
- Stock insuficiente: Verifica las existencias antes de realizar una venta.  
