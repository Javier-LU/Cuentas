package modelo;

import java.sql.SQLException;
import dao.DaoCategorias;


public class Categorias {
	
private int id;
private String nombre;
private int img;
private String imgString;
private String color;
private int usuario;

public Categorias() {
	
		}

public Categorias(int id, String nombre, String imgString, String color) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.imgString = imgString;
	this.color = color;
}



public Categorias(int id, String nombre, int img, String color, int usuario) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.img = img;
	this.color = color;
	this.usuario = usuario;
}

public Categorias(int id, String nombre, int img, String color) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.img = img;
	this.color = color;
}

public Categorias(int id, String nombre, String imgString, String color, int usuario) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.imgString = imgString;
	this.color = color;
	this.usuario = usuario;
}

public Categorias(int id, String nombre, int img, String imgString, String color, int usuario) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.img = img;
	this.imgString = imgString;
	this.color = color;
	this.usuario = usuario;
}

public String getImgString() {
	return imgString;
}

public void setImgString(String imgString) {
	this.imgString = imgString;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getImg() {
	return img;
}

public void setImg(int img) {
	this.img = img;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public int getUsuario() {
	return usuario;
}

public void setUsuario(int usuario) {
	this.usuario = usuario;
}




@Override
public String toString() {
	return "Categorias [id=" + id + ", nombre=" + nombre + ", img=" + img + ", imgString=" + imgString + ", color="
			+ color + ", usuario=" + usuario + "]";
}

// Verificación de variable nombre vacía
public boolean nombreVacia() {
    return nombre == null || nombre.isEmpty();
}

// Verificación de variable img vacía
public boolean imgVacia() {
    return img == 0 ;
}

// Verificación de variable color vacía
public boolean colorVacia() {
    return color == null || color.isEmpty();
}

public void update () throws SQLException {	
	DaoCategorias dao = new DaoCategorias();
	dao.update(this);
}

	
}
