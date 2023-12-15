package ec.edu.ups.biblioteca.vistas;

import java.util.Scanner;

import ec.edu.ups.biblioteca.modelo.Biblioteca;


public class BibliotecaVista {
	private Scanner entrada;

    public BibliotecaVista() {
        entrada = new Scanner(System.in);
    }
    
    public Biblioteca ingresarDatosBiblioteca(){
        System.out.println("------Ingreso de Nueva Biblioteca------");
        System.out.println("Ingresa el nombre de la biblioteca");
        String nombre = entrada.nextLine();
        System.out.println("Ingresa la dirreccion de la biblioteca");
        String direccion = entrada.nextLine();
        System.out.println("Ingrese el id de la biblioteca");
        int id = entrada.nextInt();
        entrada.nextLine();
        return new Biblioteca(nombre, direccion, id);
    }
    
    public Biblioteca actualizarDatosBiblioteca(){
    	
        System.out.println("------Actualizar Biblioteca------");
        System.out.println("Ingrese el id de la biblioteca");
        int id = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Ingresa el nombre de la biblioteca");
        String nombre = entrada.nextLine();
        System.out.println("Ingresa la dirreccion de la biblioteca");
        String direccion = entrada.nextLine();
        
        
        return new Biblioteca(nombre, direccion, id);
    }
    
    public int eliminarDatosBiblioteca(){
    	
        System.out.println("------Eliminar Biblioteca------");
        System.out.println("Ingresa el id de la biblioteca a eliminar");
        int id = entrada.nextInt();
        entrada.nextLine();
        return id;
    }
    
    public int  buscarDatosBiblioteca(){
        System.out.println("------Buscar Biblioteca------");
        System.out.println("Ingresa el id de la biblioteca a buscar");
        int id = entrada.nextInt();
        //entrada.nextLine();
        return id;
    }        
    
    public void mostrarInformacionBiblioteca( String nombre, String direccion, int id){
        System.out.println("Datos del Biblioteca: " + nombre + " - " + direccion +" - "+ id);
    }
    
    public void mostrarAlertas(String mensaje){
        System.out.println(mensaje);
    }
}
