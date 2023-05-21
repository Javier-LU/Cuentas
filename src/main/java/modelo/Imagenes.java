package modelo;

public class Imagenes {
	private String img;

	
	public Imagenes() {	
		
	}
	
	
	public Imagenes(String img) {		
		this.img = img;
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
	
	
	
	
}
