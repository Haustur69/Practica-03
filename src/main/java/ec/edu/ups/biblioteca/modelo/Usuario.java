package ec.edu.ups.biblioteca.modelo;


public class Usuario extends Persona{
	private String correo;
	
	public Usuario() {
	}
	
	public Usuario(String correo,String nombre, String identificacion) {
		super(nombre, identificacion);
		this.correo = correo;
	}
	public Usuario(String correo,String nombre) {
		super(nombre);
		this.correo = correo;
	}
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public boolean verificarUsuario(Usuario usuario) {
		if (getIdentificacion()==usuario.getIdentificacion()) {
			return true;
		}
		return false;
	}
	
	public void solicitarPrestamo(Libro libro) {
		libro.prestar();
	}
	
	public void devolverLibro(Libro libro) {
		libro.devolver();
	}

	
	@Override
	public String mostrarInformacion() {
		
		return "Nombre de usuario: "+ getNombre()+"\nCorreo electronico: "+getCorreo();
	}
	
	

}
