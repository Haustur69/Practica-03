package ec.edu.ups.biblioteca.vistas;

import java.util.Scanner;

import ec.edu.ups.biblioteca.modelo.Usuario;


public class UsuarioVista {
	private Scanner entrada;

    public UsuarioVista() {
        entrada = new Scanner(System.in);
    }
    
    public Usuario ingresarDatosUsuario(){
        System.out.println("------Ingreso de Nuevo Usuario------");
        System.out.println("Ingresa el id del cliente");
        String id = entrada.next();
        System.out.println("Ingresa el nombre del cliente");
        String nombre = entrada.nextLine();
        System.out.println("Ingresa el correo del cliente");
        String correo = entrada.next();
        
        return new Usuario(correo, nombre, id);
    }
    
    public Usuario actualizarDatosCliente(){
        System.out.println("------Actualizar Usuario------");
        System.out.println("Ingresa el id del cliente a actualizar");
        String id = entrada.next();
        System.out.println("Ingresa el nombre del cliente a actualizar");
        String nombre = entrada.nextLine();
        System.out.println("Ingresa el correo del cliente a actualizar");
        String correo = entrada.next();
        
        return new Usuario(correo, nombre, id);
    }
    
    public String eliminarDatosUsuario(){
        System.out.println("------Eliminar Usuario------");
        System.out.println("Ingresa el id del usuario a eliminar");
        String id = entrada.next();
        return id;
    }
    
    public String buscarDatosUsuario(){
        System.out.println("------Buscar Usuario------");
        System.out.println("Ingresa el id del usuario a buscar");
        String id = entrada.next();
        return id;
    }        
    
    public void mostrarInformacionUsuario(String id, String nombre, String correo){
        System.out.println("Datos del Cliente: \n" + id + " - " + nombre + " - " + correo);
    }
    
    public void mostrarAlertas(String mensaje){
        System.out.println(mensaje);
    }
}
