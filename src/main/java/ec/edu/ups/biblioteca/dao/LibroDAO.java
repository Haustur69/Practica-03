
package ec.edu.ups.biblioteca.dao;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.biblioteca.idao.ILibroDAO;
import ec.edu.ups.biblioteca.modelo.Libro;

public class LibroDAO implements ILibroDAO{
	
	private List<Libro> listaLibros;

    public LibroDAO() {
        listaLibros = new ArrayList<>();
    }
    
    @Override
    public List<Libro> obtenerLibro() {
        return listaLibros;
    }

    @Override
    public Libro obtenerLibro(int id) {
        for (Libro libro : listaLibros) {
            if(libro.getId() == id){
                return libro;
            }
        }
        return null;
    }

    @Override
    public void crearLibro(Libro libro) {
        listaLibros.add(libro);
    }

    @Override
    public boolean actualizarLibro(int id, Libro libro) {
        for (int i = 0; i < listaLibros.size(); i++) {
            Libro libroEncontrado = listaLibros.get(i);
            if(libroEncontrado.getId() == id){
                listaLibros.set(i, libro);
                return true;
            }
            
        }
        return false;
    }

    @Override
    public boolean eliminarLibro(int id) {
        for (int i = 0; i < listaLibros.size(); i++) {
           Libro libro = listaLibros.get(i);
            if(libro.getId() == id){
                listaLibros.remove(i);
                return true;
            }
            
        }
        return false;
    }

}
