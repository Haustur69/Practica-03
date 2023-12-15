package ec.edu.ups.biblioteca.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Prestamo {
	private int id;
	private List<Libro> libros;
	private Date fechaPrestamo;
	private Date fechaDevolucion;
	private Usuario usuario;
	
	public Prestamo() {
		libros = new ArrayList<>();	
	}
	public Prestamo(int id, Date fechaPrestamo, Date fechaDevolucion) {
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		libros = new ArrayList<>();
	}
	
	
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void agregarLibro(Libro libro){
        libros.add(libro);
    }
	public List<Libro> getLibros() {
		return libros;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamo other = (Prestamo) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Datos dl prestamo: \n" + id + " - " + libros + " - " + fechaPrestamo + " - "
				+ fechaDevolucion + " - " + usuario ;
	}
	
	
	
}
