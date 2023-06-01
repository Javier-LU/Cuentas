
package modelo;
import dao.DaoGastos;
import dao.DaoUsuarios;

import java.sql.SQLException;


import java.util.Date;
//import java.sql.Date;




/**
 * Clase que representa un gasto
 * 
 * El usuario puede construir esta clase con o sin las variables: saldo, anotaciones, fechaTarjeta y tipoTarjeta.
 * Para cada posibilidad, hay un elemento diferente
 * 
 * Esta clase proporciona métodos para acceder y manipular la información relacionada con un gasto
 * 
 * @param fecha         La fecha del gasto.
 * @param concepto      El concepto del gasto.
 * @param importe       El importe del gasto.
 * @param saldo         El saldo asociado al gasto.
 * @param categoria     La categoría del gasto.
 * @param subcategoria  La subcategoría del gasto.
 * @param anotaciones   Las anotaciones adicionales del gasto.
 * @param creditoDebito El tipo de crédito o débito del gasto.
 * @param fechaTarjeta  La fecha de la tarjeta asociada al gasto.
 * @param tipoTarjeta   El tipo de tarjeta asociada al gasto. 
 * 
 * @author Javier Luque DAW
 */

public class Gastos {

								private Date fecha;
								private String concepto;
								private int importe;
								private int saldo;
	private int categoria;
	private int subcategoria;
								private String anotaciones;
	private int creditoDebito;	
								private Date fechaTarjeta;
								private int tipoTarjeta;
	
									private int ID;
									private String imagen_categoria;
									private String imagen_subcategoria;
									private String nombre_categoria;
									private String nombre_subcategoria;
									private String nombre_tarjeta;
									
									private String fechaString;
									private String fechaTarjetaString;
									
									private String color;
									
									private int IdSub;
									private int IdCatSub;
								
									
									
									
									
									    private static Date fecha1;
									    private static Date fecha2;
									    private static String key;

									    public Date getFecha1() {
									        return fecha1;
									    }

									    public void setFecha1(Date fecha1) {
									        Gastos.fecha1 = fecha1;
									    }

									    public Date getFecha2() {
									        return fecha2;
									    }

									    public void setFecha2(Date fecha2) {
									        Gastos.fecha2 = fecha2;
									    }

									    public String getKey() {
									        return key;
									    }

									    public void setKey(String key) {
									        Gastos.key = key;
									    }
									









	/**
     * Constructor predeterminado de la clase gastos.
     * 
     */
	public Gastos() {
		
	}
	
	
	
	
	
	
	
	
	
	
    public Gastos(String fechaString, String concepto, int importe, int saldo, String anotaciones, String fechaTarjetaString,
			int tipoTarjeta, int iD, String imagen_categoria, String imagen_subcategoria, String nombre_categoria,
			String nombre_subcategoria, String nombre_tarjeta, String color, int IdSub, int IdCatSub) {
		
		this.fechaString = fechaString;
		this.concepto = concepto;
		this.importe = importe;
		this.saldo = saldo;
		this.anotaciones = anotaciones;
		this.fechaTarjetaString = fechaTarjetaString;
		this.tipoTarjeta = tipoTarjeta;
		this.ID = iD;
		this.imagen_categoria = imagen_categoria;
		this.imagen_subcategoria = imagen_subcategoria;
		this.nombre_categoria = nombre_categoria;
		this.nombre_subcategoria = nombre_subcategoria;
		this.nombre_tarjeta = nombre_tarjeta;
		this.color = color;
		this.IdSub = IdSub;
		this.IdCatSub = IdCatSub;
	}










	/**
     * Constructor de la clase gastos con todos los parámetros.
     *
     * @param fecha         La fecha del gasto.
     * @param concepto      El concepto del gasto.
     * @param importe       El importe del gasto.
     * @param saldo         El saldo asociado al gasto.
     * @param categoria     La categoría del gasto.
     * @param subcategoria  La subcategoría del gasto.
     * @param anotaciones   Las anotaciones adicionales del gasto.
     * @param creditoDebito El tipo de crédito o débito del gasto.
     * @param fechaTarjeta  La fecha de la tarjeta asociada al gasto.
     * @param tipoTarjeta   El tipo de tarjeta asociada al gasto.
     */
	public Gastos(Date fecha, String concepto, int importe, int saldo, int categoria, int subcategoria,
			String anotaciones, int creditoDebito, Date fechaTarjeta, int tipoTarjeta) {
		
		this.fecha = fecha;
		this.concepto = concepto;
		this.importe = importe;
		this.saldo = saldo;
		this.categoria = categoria;
		this.subcategoria = subcategoria;
		this.anotaciones = anotaciones;
		this.creditoDebito = creditoDebito;
		this.fechaTarjeta = fechaTarjeta;
		this.tipoTarjeta = tipoTarjeta;
	}
	
	/**
	 * Obtiene la fecha del gasto.
	 *
	 * @return La fecha del gasto.
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Establece la fecha del gasto.
	 *
	 * @param fecha La fecha del gasto a establecer.
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Obtiene el concepto del gasto.
	 *
	 * @return El concepto del gasto.
	 */
	public String getConcepto() {
		return concepto;
	}
	
	/**
	 * Establece el concepto del gasto.
	 *
	 * @param concepto El concepto del gasto a establecer.
	 */
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	/**
	 * Obtiene el importe del gasto.
	 *
	 * @return El importe del gasto.
	 */
	public int getImporte() {
		return importe;
	}
	
	/**
	 * Establece el importe del gasto.
	 *
	 * @param importe El importe del gasto a establecer.
	 */
	public void setImporte(int importe) {
		this.importe = importe;
	}

	/**
	 * Obtiene el saldo asociado al gasto.
	 *
	 * @return El saldo asociado al gasto.
	 */
	public int getSaldo() {
		return saldo;
	}

	/**
	 * Establece el saldo asociado al gasto.
	 *
	 * @param saldo El saldo asociado al gasto a establecer.
	 */
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	/**
	 * Obtiene la categoría del gasto.
	 *
	 * @return La categoría del gasto.
	 */
	public int getCategoria() {
		return categoria;
	}

	/**
	 * Establece la categoría del gasto.
	 *
	 * @param categoria La categoría del gasto a establecer.
	 */
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	/**
	 * Obtiene la subcategoría del gasto.
	 *
	 * @return La subcategoría del gasto.
	 */
	public int getSubcategoria() {
		return subcategoria;
	}

	/**
	 * Establece la subcategoría del gasto.
	 *
	 * @param subcategoria La subcategoría del gasto a establecer.
	 */
	public void setSubcategoria(int subcategoria) {
		this.subcategoria = subcategoria;
	}

	/**
	 * Obtiene las anotaciones adicionales del gasto.
	 *
	 * @return Las anotaciones adicionales del gasto.
	 */
	public String getAnotaciones() {
		return anotaciones;
	}

	/**
	 * Establece las anotaciones adicionales del gasto.
	 *
	 * @param anotaciones Las anotaciones adicionales del gasto a establecer.
	 */
	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}

	/**
	 * Obtiene el tipo de crédito o débito del gasto.
	 *
	 * @return El tipo de crédito o débito del gasto.
	 */
	public int getCreditoDebito() {
		return creditoDebito;
	}
	
	/**
	 * Establece el tipo de crédito o débito del gasto.
	 *
	 * @param creditoDebito El tipo de crédito o débito del gasto a establecer.
	 */
	public void setCreditoDebito(int creditoDebito) {
		this.creditoDebito = creditoDebito;
	}
	
	/**
	 * Obtiene la fecha de la tarjeta asociada al gasto.
	 *
	 * @return La fecha de la tarjeta asociada al gasto.
	 */
	public Date getFechaTarjeta() {
		return fechaTarjeta;
	}

	/**
	 * Establece la fecha de la tarjeta asociada al gasto.
	 *
	 * @param fechaTarjeta La fecha de la tarjeta asociada al gasto a establecer.
	 */
	public void setFechaTarjeta(Date fechaTarjeta) {
		this.fechaTarjeta = fechaTarjeta;
	}

	/**
	 * Obtiene el tipo de tarjeta asociada al gasto.
	 *
	 * @return El tipo de tarjeta asociada al gasto.
	 */
	public int getTipoTarjeta() {
		return tipoTarjeta;
	}
	
	/**
	 * Establece el tipo de tarjeta asociada al gasto.
	 *
	 * @param tipoTarjeta El tipo de tarjeta asociada al gasto a establecer.
	 */
	public void setTipoTarjeta(int tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}	
	
		

	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getImagen_categoria() {
		return imagen_categoria;
	}

	public void setImagen_categoria(String imagen_categoria) {
		this.imagen_categoria = imagen_categoria;
	}

	public String getImagen_subcategoria() {
		return imagen_subcategoria;
	}

	public void setImagen_subcategoria(String imagen_subcategoria) {
		this.imagen_subcategoria = imagen_subcategoria;
	}

	public String getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}

	public String getNombre_subcategoria() {
		return nombre_subcategoria;
	}

	public void setNombre_subcategoria(String nombre_subcategoria) {
		this.nombre_subcategoria = nombre_subcategoria;
	}

	public String getNombre_tarjeta() {
		return nombre_tarjeta;
	}

	public void setNombre_tarjeta(String nombre_tarjeta) {
		this.nombre_tarjeta = nombre_tarjeta;
	}
		

	public String getFechaString() {
		return fechaString;
	}

	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}


	public String getFechaTarjetaString() {
		return fechaTarjetaString;
	}


	public void setFechaTarjetaString(String fechaTarjetaString) {
		this.fechaTarjetaString = fechaTarjetaString;
	}


	public String getColor() {
		return color;
	}

	
	public void setColor(String color) {
		this.color = color;
	}










	/**
	 * Inserta el objeto actual en la base de datos utilizando el DaoGastos correspondiente.
	 *
	 * @throws SQLException si ocurre un error al interactuar con la base de datos.
	 */
	public void insertar () throws SQLException {		
		
		DaoGastos dao = new DaoGastos();
		dao.insertGastos(this);
	}
	
	public void update () throws SQLException {		
		
		DaoGastos dao = new DaoGastos();
		dao.uptdateGastos(this);
	}




	/**
	 * Devuelve una representación en forma de cadena de caracteres del objeto gastos.
	 *
	 * @return Una cadena de caracteres que representa el objeto gastos.
	 */
	@Override
	public String toString() {
		return "Gastos [fecha=" + fecha + ", concepto=" + concepto + ", importe=" + importe + ", saldo=" + saldo
				+ ", categoria=" + categoria + ", subcategoria=" + subcategoria + ", anotaciones=" + anotaciones
				+ ", creditoDebito=" + creditoDebito + ", fechaTarjeta=" + fechaTarjeta + ", tipoTarjeta=" + tipoTarjeta
				+ ", ID=" + ID + ", imagen_categoria=" + imagen_categoria + ", imagen_subcategoria="
				+ imagen_subcategoria + ", nombre_categoria=" + nombre_categoria + ", nombre_subcategoria="
				+ nombre_subcategoria + ", nombre_tarjeta=" + nombre_tarjeta + "]";
	}
	








	
	
	
	


	
	

	
	
	
	
}





