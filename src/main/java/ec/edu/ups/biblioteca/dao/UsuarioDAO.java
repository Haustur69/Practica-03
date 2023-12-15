package ec.edu.ups.biblioteca.dao;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.biblioteca.idao.IUsuarioDAO;
import ec.edu.ups.biblioteca.modelo.Usuario;

public class UsuarioDAO implements IUsuarioDAO  {
	private List<Usuario> listaUsuarios;

    public UsuarioDAO() {
        listaUsuarios = new ArrayList<>();
    }
    
    @Override
    public List<Usuario> obtenerUsuarios() {
        return listaUsuarios;
    }

    @Override
    public Usuario obtenerUsuario(String id) {
        for (Usuario usuario : listaUsuarios) {
            if(usuario.getIdentificacion().equalsIgnoreCase(id)){
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    @Override
    public boolean actualizarUsuario(String id, Usuario usuario) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario usuarioEncontrado = listaUsuarios.get(i);
            if(usuarioEncontrado.getIdentificacion().equalsIgnoreCase(id)){
                listaUsuarios.set(i, usuario);
                return true;
            }
            
        }
        return false;
    }

    @Override
    public boolean eliminarUsuario(String id) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario usuario = listaUsuarios.get(i);
            if(usuario.getIdentificacion().equalsIgnoreCase(id)){
                listaUsuarios.remove(i);
                return true;
            }
            
        }
        return false;
    }
}
