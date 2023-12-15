package ec.edu.ups.biblioteca.dao;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.biblioteca.idao.IBibliotecaDAO;
import ec.edu.ups.biblioteca.modelo.Biblioteca;

public class BibliotecaDAO implements IBibliotecaDAO {
	private List<Biblioteca> listaBibliotecas;

    public BibliotecaDAO() {
        listaBibliotecas = new ArrayList<>();
    }
    
    @Override
    public List<Biblioteca> obtenerBiblioteca() {
        return listaBibliotecas;
    }

    @Override
    public Biblioteca obtenerBiblioteca (int id) {
        for (Biblioteca biblioteca : listaBibliotecas) {
            if(biblioteca.getId() == id){
                return biblioteca;
            }
        }
        return null;
    }

    @Override
    public void crearBiblioteca(Biblioteca biblioteca) {
        listaBibliotecas.add(biblioteca);
    }

    @Override
    public boolean actualizarBiblioteca(int id,Biblioteca biblioteca) {
        for (int i = 0; i < listaBibliotecas.size(); i++) {
            Biblioteca bibliotecaEncontrado = listaBibliotecas.get(i);
            if(bibliotecaEncontrado.getId() == id){
                listaBibliotecas.set(i, biblioteca);
                return true;
            }
            
        }
        return false;
    }

    @Override
    public boolean eliminarBiblioteca(int id) {
        for (int i = 0; i < listaBibliotecas.size(); i++) {
            Biblioteca biblioteca = listaBibliotecas.get(i);
            if(biblioteca.getId() == id){
                listaBibliotecas.remove(i);
                return true;
            }
            
        }
        return false;
    }

}
