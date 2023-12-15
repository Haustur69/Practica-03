package ec.edu.ups.biblioteca.principal;

import java.util.Scanner;

import ec.edu.ups.biblioteca.controladores.*;
import ec.edu.ups.biblioteca.dao.*;
import ec.edu.ups.biblioteca.idao.*;
import ec.edu.ups.biblioteca.vistas.*;

public class Main {
	public static void main(String[] args) {
		
		IUsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioVista usuarioVista = new UsuarioVista();
		ILibroDAO libroDAO = new LibroDAO();
		LibroVista libroVista = new LibroVista();
		IBibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
		BibliotecaVista bibliotecaVista = new BibliotecaVista();
		IPrestamoDAO prestamoDAO = new PrestamoDAO();
		PrestamoVista prestamoVista = new PrestamoVista();
		
		UsuarioControlador usuarioControlador = new UsuarioControlador(usuarioDAO, usuarioVista);
		LibroControlador libroControlador = new LibroControlador(libroDAO, libroVista);
		BibliotecaControlador bibliotecaControlador = new BibliotecaControlador(bibliotecaDAO, bibliotecaVista, libroVista,libroDAO,usuarioDAO,usuarioVista);
		PrestamoControlador prestamoControlador = new PrestamoControlador(prestamoDAO, prestamoVista, libroDAO,libroVista, usuarioDAO, usuarioVista);
		
		Scanner scanner = new Scanner(System.in);
		int opcion;
		
		do { 
		
		System.out.println("Bienvenido al Sistema de Gestión de Biblioteca");
		System.out.println("1. Agregar biblioteca");
		System.out.println("2. Agregar Libro");
		System.out.println("3. Buscar Libro");
		System.out.println("4. Registrar Usuario");
		System.out.println("5. Prestar Libro");
		System.out.println("6. Devolver Libro");
		System.out.println("7. Salir");
		System.out.print("Ingrese una opción: ");
		opcion = scanner.nextInt();
		scanner.nextLine();
		
		switch (opcion) { 
		case 1:
			bibliotecaControlador.crearBiblioteca();
			bibliotecaControlador.listarBibliotecas();
			break;
		
		case 2:
			libroControlador.crearLibro();
			System.out.println("En que biblioteca quieres añadir el libro");
			bibliotecaControlador.añadirLibro();
			break;  
        case 3: 
            libroControlador.buscarLibroPorId();
            break; 
        case 4: 
            usuarioControlador.crearUsuario();
            bibliotecaControlador.añadirUsuario();
            break;
        case 5:
        	prestamoControlador.crearPrestamo();
        	prestamoControlador.listarPrestamos();
        	break;
        case 6:
        	prestamoControlador.eliminarPrestamo();
        	prestamoControlador.listarPrestamos();
        	break;
        case 7:
        	System.out.println("Saliendo del sistema..."); 
        	break;
        default: 
            System.out.println("Opción no válida. Por favor intente de nuevo."); 
    } 
} while (opcion != 7); 

scanner.close(); 
		
				
	}
}
