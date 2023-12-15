package ec.edu.ups.biblioteca.modelo;

import ec.edu.ups.biblioteca.interfase.IPrestable;

public class Libro implements IPrestable {
	private String titulo;
	private String autor;
	private int anio;
	private int id;
	private boolean disponible;
		
	public Libro() {
	}
	
	public Libro(int id,String titulo, String autor, int año, boolean disponible) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.anio = año;
		this.disponible = disponible;
		this.id = id;
	}

	public Libro(String titulo, String autor, boolean disponible) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.disponible = disponible;
	}

	public Libro(String titulo, String autor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAño() {
		return anio;
	}

	public void setAño(int año) {
		this.anio = año;
	}

	public boolean getDisponibilidad() {
		return disponible;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void prestar() {
		this.disponible = false;
	}

	@Override
	public void devolver() {
	this.disponible = true;
	}
	//Mostrar informacion
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", año=" + anio + ", disponible=" + disponible + "]";
	}
	
	
	
}
