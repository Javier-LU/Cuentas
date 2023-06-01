package modelo;

import java.sql.SQLException;
import dao.DaoImgenes;

public class Imagenes {
	private String img;
	private int id;
	private String tipo;
	private DaoImgenes dao;
	
	public Imagenes() {	
		
	}
	
	public Imagenes(String img, String tipo) {
		
		this.img = img;
		this.tipo = tipo;
	}

	public Imagenes(String img, int id) {
		super();
		this.img = img;
		this.id = id;
	}

	public Imagenes(String img) {		
		this.img = img;
	}	

	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	@Override
	public String toString() {
		return "Imagenes [img=" + img + "]";
	}
	
	public void insertar () throws SQLException {	
		dao = new DaoImgenes();
		dao.insertar(this);
	}
	public void eliminarFisico () throws SQLException {	
		dao = new DaoImgenes();
		dao.eliminarFisico(this);
	}
	
	public void eliminarBaseDatos () throws SQLException {
		dao = new DaoImgenes();
		dao.eliminarBaseDatos(this);
	}

	
	
	
}
