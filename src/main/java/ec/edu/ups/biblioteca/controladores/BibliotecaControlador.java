package ec.edu.ups.biblioteca.controladores;

import java.util.List;

import ec.edu.ups.biblioteca.idao.IBibliotecaDAO;
import ec.edu.ups.biblioteca.idao.ILibroDAO;
import ec.edu.ups.biblioteca.idao.IUsuarioDAO;
import ec.edu.ups.biblioteca.modelo.Biblioteca;
import ec.edu.ups.biblioteca.modelo.Libro;
import ec.edu.ups.biblioteca.modelo.Usuario;
import ec.edu.ups.biblioteca.vistas.BibliotecaVista;
import ec.edu.ups.biblioteca.vistas.LibroVista;
import ec.edu.ups.biblioteca.vistas.UsuarioVista;


public class BibliotecaControlador {
	private IBibliotecaDAO bibliotecaDAO;
    private BibliotecaVista bibliotecaVista;
    private Biblioteca biblioteca;
    private ILibroDAO libroDAO;
    private LibroVista libroVista;
    private Libro libro;
    private IUsuarioDAO usuarioDAO;
    private UsuarioVista usuarioVista;
    private Usuario usuario;

    public BibliotecaControlador(IBibliotecaDAO bibliotecaDAO, BibliotecaVista bibliotecaVista,LibroVista libroVista,ILibroDAO libroDAO,IUsuarioDAO usuarioDAO,UsuarioVista usuarioVista) {
        this.bibliotecaDAO = bibliotecaDAO;
        this.bibliotecaVista = bibliotecaVista;
        this.libroVista = libroVista;
        this.libroDAO = libroDAO;
        this.usuarioDAO = usuarioDAO;
        this.usuarioVista = usuarioVista;
    }
    
    public void crearBiblioteca(){
        biblioteca = bibliotecaVista.ingresarDatosBiblioteca();
        bibliotecaDAO.crearBiblioteca(biblioteca);
    }
    
    public void actualizarBiblioteca(){
        biblioteca = bibliotecaVista.actualizarDatosBiblioteca();
        if(bibliotecaDAO.actualizarBiblioteca(biblioteca.getId(), biblioteca) == true){
        	bibliotecaVista.mostrarAlertas("Biblioteca actualizada correctamente!");                    
        }else{
        	bibliotecaVista.mostrarAlertas("Ha ocurrido un error!");                    
        }            
    }
    
    public void eliminarBiblioteca(){
        int id = bibliotecaVista.eliminarDatosBiblioteca();
        if(bibliotecaDAO.eliminarBiblioteca(id) == true){
        	bibliotecaVista.mostrarAlertas("Biblioteca eliminada correctamente!");                    
        }else{
        	bibliotecaVista.mostrarAlertas("Ha ocurrido un error!");
        }
    }
    
    public void buscarBibliotecaPorId(){
        int id = bibliotecaVista.buscarDatosBiblioteca();
        biblioteca = bibliotecaDAO.obtenerBiblioteca(id);
        if(biblioteca == null){
        	bibliotecaVista.mostrarAlertas("Biblioteca no encontrada");
        }else{
        	bibliotecaVista.mostrarInformacionBiblioteca(biblioteca.getNomhre(),biblioteca.getDirrecion(), biblioteca.getId());
        }
    }
    
    public void añadirLibro() {
    	int id = bibliotecaVista.buscarDatosBiblioteca();
        biblioteca = bibliotecaDAO.obtenerBiblioteca(id);
        if(biblioteca == null){
        	bibliotecaVista.mostrarAlertas("Biblioteca no encontrada");
        }else {
        	int idLibro = libroVista.buscarDatosLibro();
        	libro = libroDAO.obtenerLibro(idLibro);
        	biblioteca.agregarLibro(libro);
        	bibliotecaVista.mostrarAlertas("Libro añadido con exito");
        }
    }
    
    public void añadirUsuario() {
    	int id = bibliotecaVista.buscarDatosBiblioteca();
        biblioteca = bibliotecaDAO.obtenerBiblioteca(id);
        if(biblioteca == null){
        	bibliotecaVista.mostrarAlertas("Biblioteca no encontrada");
        }else {
        String idUsuario = usuarioVista.buscarDatosUsuario();
        usuario = usuarioDAO.obtenerUsuario(idUsuario);
    	biblioteca.agregarUsuario(usuario);
    	bibliotecaVista.mostrarAlertas("Usuario añadido con exito");
        }
    }
    
    public void listarBibliotecas(){
        List<Biblioteca> listaBibliotecas = bibliotecaDAO.obtenerBiblioteca();
        for (Biblioteca biblioteca : listaBibliotecas) {
        	bibliotecaVista.mostrarInformacionBiblioteca(biblioteca.getNomhre(),biblioteca.getDirrecion(), biblioteca.getId());
        }
    }
}
