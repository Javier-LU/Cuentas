package modelo;

import java.sql.SQLException;

import dao.DaoUsuarios;


public class Usuario {
	private String nombre;
	private String pass;
	private String img;
	
	
	public Usuario() {
		
	}



	public Usuario(String nombre, String pass, String img) {		
		this.nombre = nombre;
		this.pass = pass;
		this.img = img;
	}


	public Usuario(String nombre) {	;
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", pass=" + pass + ", img=" + img + "]";
	}

	
	
	public void insertar () throws SQLException {	
		DaoUsuarios dao = new DaoUsuarios();
		dao.insertar(this);
	}








	
	
	
}
