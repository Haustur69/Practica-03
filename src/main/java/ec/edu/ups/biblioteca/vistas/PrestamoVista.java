package ec.edu.ups.biblioteca.vistas;

import java.util.Date;
import java.util.Scanner;

import ec.edu.ups.biblioteca.modelo.Prestamo;

public class PrestamoVista {

	private Scanner entrada;
	
	public PrestamoVista() {
	    entrada = new Scanner(System.in);
	}
	
	public Prestamo ingresarDatosPrestamo(){
	    System.out.println("------Ingreso de Nuevo Prestamo------");
	    System.out.println("Ingresa el id de libro a prestar");
	    int id = entrada.nextInt();
	    System.out.println("Deseas ingresar una nueva fecha(s/n)");
	    String respuesta = entrada.next();
        Date fechaPrestamo; 
        if(respuesta.equalsIgnoreCase("s")){
            System.out.println("Ingresa el dia: ");
            int dia = entrada.nextInt();
            System.out.println("Ingresa el mes: ");
            int mes = entrada.nextInt();
            System.out.println("Ingresa el año: ");
            int anio = entrada.nextInt();
            fechaPrestamo = new Date(anio, (mes-1), dia);            
        }else{
            fechaPrestamo = new Date();
        }
        
        System.out.println("Ingresa los dias de prestamo");
        int diasPrestamo = entrada.nextInt();
        
        Date fechaDevolucion = new Date(fechaPrestamo.getYear(), fechaPrestamo.getMonth(),fechaPrestamo.getDay()+diasPrestamo);
        
	    return new Prestamo(id, fechaPrestamo, fechaDevolucion);
	}
	
	public Prestamo actualizarDatosPrestamo(){
	    System.out.println("------Actualizar Prestamo------");
	    System.out.println("Ingresa el id de libro a prestar");
	    int id = entrada.nextInt();
	    System.out.println("Deseas ingresar una nueva fecha(s/n)");
	    String respuesta = entrada.next();
        Date fechaPrestamo; 
        if(respuesta.equalsIgnoreCase("s")){
            System.out.println("Ingresa el dia: ");
            int dia = entrada.nextInt();
            System.out.println("Ingresa el mes: ");
            int mes = entrada.nextInt();
            System.out.println("Ingresa el año: ");
            int anio = entrada.nextInt();
            fechaPrestamo = new Date(anio, (mes-1), dia);            
        }else{
            fechaPrestamo = new Date();
        }
        
        System.out.println("Ingresa los dias de prestamo");
        int diasPrestamo = entrada.nextInt();
        
        Date fechaDevolucion = new Date(fechaPrestamo.getYear(), fechaPrestamo.getMonth(),fechaPrestamo.getDay()+diasPrestamo);
        
	    return new Prestamo(id, fechaPrestamo, fechaDevolucion);
	}
	
	public String eliminarDatosPrestamo(){
	    System.out.println("------Eliminar Prestamo------");
	    System.out.println("Ingresa el id del prestamo a eliminar");
	    String id = entrada.next();
	    return id;
	}
	
	public int  buscarDatosPrestamo(){
	    System.out.println("------Buscar Prestamo------");
	    System.out.println("Ingresa id del prestamo a buscar");
	    int id = entrada.nextInt();
	    return id;
	}        
	
	public int agregarLibrosAPrestamo(){
        System.out.println("------Agregar Libro a Prestamo------");
        System.out.println("Ingresa número de libros a agregar");
        int id = entrada.nextInt();
        return id;
    }
	
	public void mostrarInformacionPrestamo(Prestamo prestamo){
	    System.out.println(prestamo.toString());
	}
	
	public void mostrarAlertas(String mensaje){
	    System.out.println(mensaje);
	}
	
}
