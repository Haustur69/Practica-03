package ec.edu.ups.biblioteca.controladores;

import java.util.List;

import ec.edu.ups.biblioteca.idao.ILibroDAO;
import ec.edu.ups.biblioteca.modelo.Libro;
import ec.edu.ups.biblioteca.vistas.LibroVista;


public class LibroControlador {
	private ILibroDAO libroDAO;
    private LibroVista libroVista;
    private Libro libro;

    public LibroControlador(ILibroDAO libroDAO, LibroVista libroVista) {
        this.libroDAO = libroDAO;
        this.libroVista = libroVista;        
    }
    
    
    public void crearLibro(){
        libro = libroVista.ingresarDatosLibro();
        libroDAO.crearLibro(libro);
    }
    
    public void actualizarLibro(){
        libro = libroVista.actualizarDatosLibro();
        if(libroDAO.actualizarLibro(libro.getId(), libro) == true){
            libroVista.mostrarAlertas("Libro actualizado correctamente!");                    
        }else{
            libroVista.mostrarAlertas("Ha ocurrido un error!");                    
        }            
    }
    
    public void eliminarLibro(){
        int id = libroVista.eliminarDatosLibro();
        if(libroDAO.eliminarLibro(id) == true){
            libroVista.mostrarAlertas("Libro eliminado correctamente!");                    
        }else{
            libroVista.mostrarAlertas("Ha ocurrido un error!");
        }
    }
    
    public void buscarLibroPorId(){
        int id = libroVista.buscarDatosLibro();
        libro = libroDAO.obtenerLibro(id);
        if(libro == null){
            libroVista.mostrarAlertas("Libro no encontrado");
        }else{
            libroVista.mostrarInformacionLibro(libro.getId(), libro.getTitulo(), libro.getAutor(), libro.getAño(), libro.getDisponibilidad());
        }
    }
    
    
    public void listarLibros(){
        List<Libro> listaLibros = libroDAO.obtenerLibro();
        for (Libro libro : listaLibros) {
            libroVista.mostrarInformacionLibro(libro.getId(), libro.getTitulo(),libro.getAutor(), libro.getAño(), libro.getDisponibilidad());
        }
    }
}
