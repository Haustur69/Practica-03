package ec.edu.ups.biblioteca.vistas;

import java.util.Scanner;
import ec.edu.ups.biblioteca.modelo.Libro;

public class LibroVista {
	private Scanner entrada;

    public LibroVista() {
        entrada = new Scanner(System.in);
    }
    
    public Libro ingresarDatosLibro(){
        System.out.println("------Ingreso de Nuevo Libro------");
        System.out.println("Ingrese la id del libro");
        int id = entrada.nextInt();
        System.out.println("Ingresa el titulo del libro");
        String titulo = entrada.next();
        System.out.println("Ingresa el autor de Libro");
        String autor = entrada.next();
        System.out.println("Ingresa el año de publicación");
        int anio = entrada.nextInt();
        
        return new Libro(id, titulo,autor, anio, true);
    }
    
    public Libro actualizarDatosLibro(){
    	boolean disponibilidad;
        System.out.println("------Actualizar Biblioteca------");
        System.out.println("Ingrese la id del libro a actualizar");
        int id = entrada.nextInt();
        System.out.println("Ingresa el titulo del libro a actualizar");
        String titulo = entrada.next();
        System.out.println("Ingresa el autor de Libro a actualizar");
        String autor = entrada.next();
        System.out.println("Ingresa el año de publicación del libro a actualizar");
        int anio = entrada.nextInt();
        System.out.println("El libro esta disponible (s/n)");
        String respuesta = entrada.next();
        if (respuesta.equalsIgnoreCase("s")) {
        	disponibilidad = true;
        }else {
        	disponibilidad = false;
        }
        return new Libro(id, titulo,autor, anio, disponibilidad);
    }
    
    public int eliminarDatosLibro(){
        System.out.println("------Eliminar Libro------");
        System.out.println("Ingresa id a eliminar");
        int id = entrada.nextInt();
        return id;
    }
    
    public int  buscarDatosLibro(){
        System.out.println("------Buscar Libro------");
        System.out.println("Ingresa el id del libro a buscar");
        int id = entrada.nextInt();
        return id;
    }        
    
    public void mostrarInformacionLibro(int id, String titulo, String autor, int anio,boolean disponibilidad){
        System.out.println("Datos del Libro: \n" +id+" - "+ titulo + " - " + autor+" - "+anio+" Disponible: "+disponibilidad);
    }
    
    public void mostrarAlertas(String mensaje){
        System.out.println(mensaje);
    }

}
