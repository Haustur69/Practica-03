package ec.edu.ups.biblioteca.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.edu.ups.biblioteca.idao.IPrestamoDAO;
import ec.edu.ups.biblioteca.modelo.Prestamo;
import ec.edu.ups.biblioteca.modelo.Usuario;

public class PrestamoDAO implements IPrestamoDAO {
	private List<Prestamo> listaPrestamos;

    public PrestamoDAO() {
        listaPrestamos = new ArrayList<>();
    }
            
    @Override
    public List<Prestamo> obtenerPrestamo() {
        return listaPrestamos;
    }

    @Override
    public List<Prestamo> obtenerPrestamoPorUsuario(Usuario usuario) {
        List<Prestamo> prestamosEncontrados = new ArrayList<>();
        for (Prestamo prestamo : listaPrestamos) {
            if(prestamo.getUsuario().equals(usuario)){
                prestamosEncontrados.add(prestamo);
            }
        }
        return prestamosEncontrados;
    }

    @Override
    public List<Prestamo> obtenerPrestamoPorFechaDePrestamo(Date fechaPrestamo) {
        List<Prestamo> prestamosEncontrados = new ArrayList<>();
        for (Prestamo prestamo : listaPrestamos) {
            if(prestamo.getFechaPrestamo().equals(fechaPrestamo)){
                prestamosEncontrados.add(prestamo);
            }
        }
        return prestamosEncontrados;
    }

    @Override
    public Prestamo obtenerPrestamo(int id) {        
        for (Prestamo prestamo : listaPrestamos) {
            if(prestamo.getId() ==  id){
                return prestamo;
            }
        }
        return null;
    }

    @Override
    public void crearPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }

    @Override
    public boolean actualizarPrestamo(int id, Prestamo prestamo) {
        for (int i = 0; i < listaPrestamos.size(); i++) {
            Prestamo prestamoEncontrado = listaPrestamos.get(i);
            if(prestamoEncontrado.getId() == id){
                listaPrestamos.set(i, prestamo);
                return true;
            }            
        }
        return false;
    }

    @Override
    public boolean eliminarPrestamo(int id) {
        for (int i = 0; i < listaPrestamos.size(); i++) {
            Prestamo prestamoEncontrado = listaPrestamos.get(i);
            if(prestamoEncontrado.getId() == id){
                listaPrestamos.remove(i);
                return true;
            }            
        }
        return false;
    }

}
