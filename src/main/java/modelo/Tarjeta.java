package modelo;

import java.util.Date;
import java.math.BigDecimal;

public class Tarjeta {
	
	private int id;
	private String nombre;
	private Date vencimiento;
	private String descripcion;
	private BigDecimal  limite;	
	private int usuario;
	
	public Tarjeta() {

	}

	public Tarjeta(int id, String nombre, Date vencimiento, String descripcion, BigDecimal limite, int usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.vencimiento = vencimiento;
		this.descripcion = descripcion;
		this.limite = limite;
		this.usuario = usuario;
	}

	public Tarjeta(int id, String nombre, Date vencimiento, String descripcion, BigDecimal limite) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.vencimiento = vencimiento;
		this.descripcion = descripcion;
		this.limite = limite;
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

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Tarjeta [id=" + id + ", nombre=" + nombre + ", vencimiento=" + vencimiento + ", descripcion="
				+ descripcion + ", limite=" + limite + ", usuario=" + usuario + "]";
	}


}
