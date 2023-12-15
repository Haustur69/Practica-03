package ec.edu.ups.biblioteca.controladores;

import java.util.List;

import ec.edu.ups.biblioteca.idao.ILibroDAO;
import ec.edu.ups.biblioteca.idao.IPrestamoDAO;
import ec.edu.ups.biblioteca.idao.IUsuarioDAO;
import ec.edu.ups.biblioteca.modelo.Libro;
import ec.edu.ups.biblioteca.modelo.Prestamo;
import ec.edu.ups.biblioteca.modelo.Usuario;
import ec.edu.ups.biblioteca.vistas.LibroVista;
import ec.edu.ups.biblioteca.vistas.PrestamoVista;
import ec.edu.ups.biblioteca.vistas.UsuarioVista;

public class PrestamoControlador {
	private IPrestamoDAO prestamoDAO;
    private PrestamoVista prestamoVista;
    private Prestamo prestamo;
    
    private ILibroDAO libroDAO;
    private LibroVista libroVista;
    private Libro libro;
    
    private IUsuarioDAO usuarioDAO;
    private UsuarioVista usuarioVista;
    private Usuario usuario;

    public PrestamoControlador(IPrestamoDAO prestamoDAO, PrestamoVista prestamoVista, ILibroDAO libroDAO, LibroVista libroVista, IUsuarioDAO usuarioDAO, UsuarioVista usuarioVista) {
        this.prestamoDAO = prestamoDAO;
        this.prestamoVista = prestamoVista;
        this.libroDAO = libroDAO;
        this.libroVista = libroVista;
        this.usuarioDAO = usuarioDAO;
        this.usuarioVista = usuarioVista;
    }               
    
    public void crearPrestamo(){
        prestamo = prestamoVista.ingresarDatosPrestamo();
        String idCliente = usuarioVista.buscarDatosUsuario();
        usuario = usuarioDAO.obtenerUsuario(idCliente);
        if(usuario != null){
            prestamo.setUsuario(usuario);
            int numeroDeLibros = prestamoVista.agregarLibrosAPrestamo();
            for (int i = 0; i < numeroDeLibros; i++) {
                int idLibro = libroVista.buscarDatosLibro();
                libro = libroDAO.obtenerLibro(idLibro);
                if(libro != null){
                    prestamo.agregarLibro(libro);
                    libro.prestar();
                }else{
                    libroVista.mostrarAlertas("No se han encontrado los datos de Libro!");
                }
            } 
            prestamoDAO.crearPrestamo(prestamo);
        }else{
            usuarioVista.mostrarAlertas("No se ha encontrado los datos del Usuario!");
        }
        
    }
    public void eliminarPrestamo(){
    	int idPrestamo = prestamoVista.buscarDatosPrestamo();
    	prestamo = prestamoDAO.obtenerPrestamo(idPrestamo);
    	if(prestamoDAO.eliminarPrestamo(idPrestamo) == true){
    		prestamoVista.mostrarAlertas("El prestamo se ha eliminado");
    	}else {
    		prestamoVista.mostrarAlertas("Ha ocurrido un error");
    	}
        
    }
    
    public void listarPrestamos(){
        List<Prestamo> listaPedidos = prestamoDAO.obtenerPrestamo();
        for (Prestamo prestamo : listaPedidos) {
            prestamoVista.mostrarInformacionPrestamo(prestamo);
        }
    }
}
