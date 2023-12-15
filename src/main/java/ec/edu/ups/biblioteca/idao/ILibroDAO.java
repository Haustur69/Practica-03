package ec.edu.ups.biblioteca.idao;

import java.util.List;

import ec.edu.ups.biblioteca.modelo.Libro;

public interface ILibroDAO {
	List<Libro> obtenerLibro();
	Libro obtenerLibro(int id);
	void crearLibro(Libro libro);
	boolean actualizarLibro(int id, Libro libro);
	boolean eliminarLibro(int id);
}
