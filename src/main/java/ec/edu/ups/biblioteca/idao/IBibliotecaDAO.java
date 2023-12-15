package ec.edu.ups.biblioteca.idao;

import java.util.List;

import ec.edu.ups.biblioteca.modelo.Biblioteca;

public interface IBibliotecaDAO {
	 List<Biblioteca> obtenerBiblioteca();
	 Biblioteca obtenerBiblioteca(int id);
	 void crearBiblioteca(Biblioteca biblioteca);
	 boolean actualizarBiblioteca(int id, Biblioteca biblioteca);
	 boolean eliminarBiblioteca(int id);
}
