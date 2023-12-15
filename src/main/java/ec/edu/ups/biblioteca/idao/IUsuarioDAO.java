package ec.edu.ups.biblioteca.idao;

import java.util.List;

import ec.edu.ups.biblioteca.modelo.Usuario;

public interface IUsuarioDAO {
	
	List<Usuario> obtenerUsuarios();
	Usuario obtenerUsuario(String id);
    void crearUsuario(Usuario usuario);
    boolean actualizarUsuario(String id, Usuario usuario);
    boolean eliminarUsuario(String id);
    
}
