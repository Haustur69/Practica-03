package ec.edu.ups.biblioteca.idao;

import java.util.Date;
import java.util.List;

import ec.edu.ups.biblioteca.modelo.Libro;
import ec.edu.ups.biblioteca.modelo.Prestamo;
import ec.edu.ups.biblioteca.modelo.Usuario;

public interface IPrestamoDAO {
	List<Prestamo> obtenerPrestamo();
    List<Prestamo> obtenerPrestamoPorUsuario(Usuario usuario);
    List<Prestamo> obtenerPrestamoPorFechaDePrestamo(Date fechaPrestamo);
    Prestamo obtenerPrestamo(int id);
    void crearPrestamo(Prestamo prestamo);
    boolean actualizarPrestamo(int id, Prestamo prestamo);
    boolean eliminarPrestamo(int id);
}
