package ec.edu.ups.biblioteca.modelo;

import java.util.ArrayList;
import java.util.List;


public class Biblioteca {
	private int id;
	private String nomhre;
	private String dirrecion;
	private List<Libro> listLibros;
	private List<Usuario> listaUsuario;
	
	public Biblioteca() {
		this.listaUsuario = new ArrayList<>();
		this.listLibros = new ArrayList<>();
	}
	
	public Biblioteca(String nomhre, String dirrecion, int id) {
		super();
		this.nomhre = nomhre;
		this.dirrecion = dirrecion;
		this.id = id;
		this.listaUsuario = new ArrayList<>();
		this.listLibros = new ArrayList<>();
	}
	
	public Biblioteca(String nomhre) {
		super();
		this.nomhre = nomhre;
		this.listaUsuario = new ArrayList<>();
		this.listLibros = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNomhre() {
		return nomhre;
	}
	public void setNomhre(String nomhre) {
		this.nomhre = nomhre;
	}
	public String getDirrecion() {
		return dirrecion;
	}
	public void setDirrecion(String dirrecion) {
		this.dirrecion = dirrecion;
	}

	 public List<Libro> getListaLibros() {
		return listLibros;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}
	public void agregarLibro(Libro libro) {
		 listLibros.add(libro);
	 }
	 public void agregarUsuario(Usuario usuario) {
		listaUsuario.add(usuario);
	 }
}
