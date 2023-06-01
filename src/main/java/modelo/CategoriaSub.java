package modelo;

import java.sql.SQLException;

import dao.DaoCategoriasSub;

public class CategoriaSub {
	private int id;	
	private int idCategoria;
	private String nombre;
	private String img;
	private int imgInt;
	private int usuario;
	
	
	public CategoriaSub() {
		super();
	}

	
	
	
	public CategoriaSub(int id, int idCategoria, String nombre, String img, int usuario) {
		super();
		this.id = id;
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.img = img;
		this.usuario = usuario;
	}

	public CategoriaSub(int id, int idCategoria, String nombre, String img) {
		super();
		this.id = id;
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.img = img;
	}




	public CategoriaSub(int id, int idCategoria, String nombre, int imgInt) {
		super();
		this.id = id;
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.imgInt = imgInt;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getIdCategoria() {
		return idCategoria;
	}




	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getImg() {
		return img;
	}




	public void setImg(String img) {
		this.img = img;
	}




	public int getUsuario() {
		return usuario;
	}




	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}




	public int getImgInt() {
		return imgInt;
	}




	public void setImgInt(int imgInt) {
		this.imgInt = imgInt;
	}



	@Override
	public String toString() {
		return "CategoriaSub [id=" + id + ", idCategoria=" + idCategoria + ", nombre=" + nombre + ", img=" + img
				+ ", imgInt=" + imgInt + ", usuario=" + usuario + "]";
	}




	// Verificación de variable img vacía
	public boolean imgIntVacia() {
	    return imgInt == 0 ;
	}
	
	// Verificación de variable color vacía
	public boolean nombreVacia() {
	    return nombre == null || nombre.isEmpty();
	}

	public void update () throws SQLException {	
		DaoCategoriasSub dao = new DaoCategoriasSub();
		dao.update(this);
	}
	
	


}
