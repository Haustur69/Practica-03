package ec.edu.ups.biblioteca.modelo;

import java.util.Objects;


public abstract class Persona {
	private String nombre;
	private String identificacion;
	
	public Persona() {
		
	}
	
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Persona(String nombre, String identificacion) {
		super();
		this.nombre = nombre;
		this.identificacion = identificacion;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
	public abstract String mostrarInformacion();

	@Override
	public int hashCode() {
		return Objects.hash(identificacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(identificacion, other.identificacion);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", identificacion=" + identificacion + "]";
	}

	
}
