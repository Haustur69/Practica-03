package ec.edu.ups.biblioteca.controladores;

import java.util.List;

import ec.edu.ups.biblioteca.idao.IUsuarioDAO;
import ec.edu.ups.biblioteca.modelo.Usuario;
import ec.edu.ups.biblioteca.vistas.UsuarioVista;


public class UsuarioControlador {
	private IUsuarioDAO usuarioDAO;
    private UsuarioVista usuarioVista;
    private Usuario usuario;

    public UsuarioControlador(IUsuarioDAO usuarioDAO, UsuarioVista usuarioVista) {
        this.usuarioDAO = usuarioDAO;
        this.usuarioVista = usuarioVista;        
    }
    
    public void crearUsuario(){
    	usuario = usuarioVista.ingresarDatosUsuario();
    	usuarioDAO.crearUsuario(usuario);
    }
    
    public void actualizarUsuario(){
    	usuario = usuarioVista.actualizarDatosCliente();
        if(usuarioDAO.actualizarUsuario(usuario.getIdentificacion(), usuario) == true){
            usuarioVista.mostrarAlertas("Usuario actualizado correctamente!");                    
        }else{
        	usuarioVista.mostrarAlertas("Ha ocurrido un error!");                    
        }            
    }
    
    public void eliminarUsuario(){
        String id = usuarioVista.eliminarDatosUsuario();
        if(usuarioDAO.eliminarUsuario(id) == true){
        	usuarioVista.mostrarAlertas("Usuario eliminado correctamente!");                    
        }else{
        	usuarioVista.mostrarAlertas("Ha ocurrido un error!");
        }
    }
    
    public void buscarUsuarioPorId(){
        String id = usuarioVista.buscarDatosUsuario();
        usuario = usuarioDAO.obtenerUsuario(id);
        if(usuario == null){
        	usuarioVista.mostrarAlertas("Usuario no encontrado");
        }else{
        	usuarioVista.mostrarInformacionUsuario(usuario.getIdentificacion(), usuario.getNombre(), usuario.getCorreo());
        }
    }
    
    public void listarUsuarios(){
        List<Usuario> listaUsuarios = usuarioDAO.obtenerUsuarios();
        for (Usuario usuario : listaUsuarios) {
        	usuarioVista.mostrarInformacionUsuario(usuario.getIdentificacion(), usuario.getNombre(), usuario.getCorreo());
        }
    }
}
