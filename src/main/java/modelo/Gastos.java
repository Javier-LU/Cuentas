
package modelo;
import dao.DaoGastos;

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
	
	
	 /**
     * Constructor predeterminado de la clase gastos.
     * 
     */
	public Gastos() {
		
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

	
	/**
	 * Inserta el objeto actual en la base de datos utilizando el DaoGastos correspondiente.
	 *
	 * @throws SQLException si ocurre un error al interactuar con la base de datos.
	 */
	public void insertar () throws SQLException {
		
		
		
		DaoGastos dao = new DaoGastos();
		dao.insertGastos(this);
	}

	/**
	 * Devuelve una representación en forma de cadena de caracteres del objeto gastos.
	 *
	 * @return Una cadena de caracteres que representa el objeto gastos.
	 */
	@Override
	public String toString() {
		return "gastos [fecha=" + fecha + ", concepto=" + concepto + ", importe=" + importe + ", saldo=" + saldo
				+ ", categoria=" + categoria + ", subcategoria=" + subcategoria + ", anotaciones=" + anotaciones
				+ ", creditoDebito=" + creditoDebito + ", fechaTarjeta=" + fechaTarjeta + ", tipoTarjeta=" + tipoTarjeta
				+ ", getFecha()=" + getFecha() + ", getConcepto()=" + getConcepto() + ", getImporte()=" + getImporte()
				+ ", getSaldo()=" + getSaldo() + ", getCategoria()=" + getCategoria() + ", getSubcategoria()="
				+ getSubcategoria() + ", getAnotaciones()=" + getAnotaciones() + ", getCreditoDebito()="
				+ getCreditoDebito() + ", getFechaTarjeta()=" + getFechaTarjeta() + ", getTipoTarjeta()="
				+ getTipoTarjeta() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}







	
	
	
	


	
	

	
	
	
	
}





