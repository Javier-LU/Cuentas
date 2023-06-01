package modelo;

public class Restriccion {
	private int id;
	private String concepto;
	private String categoria;
	private String subcategoria;
	private int usuario;
	
	public Restriccion() {
		
	}

	public Restriccion(int id, String concepto, String categoria, String subcategoria, int usuario) {
		
		this.id = id;
		this.concepto = concepto;
		this.categoria = categoria;
		this.subcategoria = subcategoria;
		this.usuario = usuario;
	}

	public Restriccion(int id, String concepto, String categoria, String subcategoria) {
		
		this.id = id;
		this.concepto = concepto;
		this.categoria = categoria;
		this.subcategoria = subcategoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Restriccion [id=" + id + ", concepto=" + concepto + ", categoria=" + categoria + ", subcategoria="
				+ subcategoria + ", usuario=" + usuario + "]";
	}


	
	
	
}
