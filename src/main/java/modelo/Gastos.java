
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
 * Variables para crear un registro
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
 * Variables para pintar la web
 * @param fechaString          La fecha en formato de cadena.
 * @param concepto             El concepto de los gastos.
 * @param importe              El importe de los gastos.
 * @param saldo                El saldo de los gastos.
 * @param anotaciones          Las anotaciones de los gastos.
 * @param fechaTarjetaString   La fecha de la tarjeta en formato de cadena.
 * @param tipoTarjeta          El tipo de la tarjeta.
 * @param ID                   El ID de los gastos.
 * @param imagen_categoria     La imagen de la categoría de los gastos en formato texto, scr.
 * @param imagen_subcategoria  La imagen de la subcategoría de los gastos en formato texto, scr.
 * @param nombre_categoria     El nombre de la categoría de los gastos.
 * @param nombre_subcategoria  El nombre de la subcategoría de los gastos.
 * @param nombre_tarjeta       El nombre de la tarjeta de los gastos.
 * @param color                El color de los gastos.
 * @param IdSub                El ID de la subcategoría de los gastos.
 * @param IdCatSub             El ID de la categoría de la subcategoría de los gastos.
 * 
 * Variables para pintar la web en relación a estos parametros 
 * @param fecha1: 				La primera fecha utilizada en lanzar consultas.
 * @param fecha2: 				La segunda fecha utilizada  en lanzar consultas.
 * @param 						La clave utilizada para realizar operaciones.
 * 
 * @author Javier Luque DAW
 */

public class Gastos {
	
	// Variables para crear un registro de gasto en la base de datos
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
	
	//Variables para cargar un registro de gasto en la web								
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

	//Variables que necesito que mantengan sus valores incluso después de que la ejecución de la clase haya terminado.
	  private static Date fecha1;
	  private static Date fecha2;
	  private static String key;								

	/**
     * Constructor predeterminado de la clase gastos.
     * 
     */
	public Gastos() {
		
	}
	
	/**
	 * Crea un nuevo objeto Gastos con los valores especificados.
	 * LO utilizo para pintar la web
	 *
	 * @param fechaString          La fecha en formato de cadena.
	 * @param concepto             El concepto de los gastos.
	 * @param importe              El importe de los gastos.
	 * @param saldo                El saldo de los gastos.
	 * @param anotaciones          Las anotaciones de los gastos.
	 * @param fechaTarjetaString   La fecha de la tarjeta en formato de cadena.
	 * @param tipoTarjeta          El tipo de la tarjeta.
	 * @param ID                   El ID de los gastos.
	 * @param imagen_categoria     La imagen de la categoría de los gastos.
	 * @param imagen_subcategoria  La imagen de la subcategoría de los gastos.
	 * @param nombre_categoria     El nombre de la categoría de los gastos.
	 * @param nombre_subcategoria  El nombre de la subcategoría de los gastos.
	 * @param nombre_tarjeta       El nombre de la tarjeta de los gastos.
	 * @param color                El color de los gastos.
	 * @param IdSub                El ID de la subcategoría de los gastos.
	 * @param IdCatSub             El ID de la categoría de la subcategoría de los gastos.
	 */	
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
     * Constructor de la clase gastos con todos los parámetros que se emplea para insertar un objeto.
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
     * Obtiene la fecha 1.
     *
     * @return La fecha 1.
     */
    public Date getFecha1() {
        return fecha1;
    }

    /**
     * Establece la fecha 1.
     *
     * @param fecha1 La fecha 1.
     */
    public void setFecha1(Date fecha1) {
        Gastos.fecha1 = fecha1;
    }

    /**
     * Obtiene la fecha 2.
     *
     * @return La fecha 2.
     */
    public Date getFecha2() {
        return fecha2;
    }

    /**
     * Establece la fecha 2.
     *
     * @param fecha2 La fecha 2.
     */
    public void setFecha2(Date fecha2) {
        Gastos.fecha2 = fecha2;
    }

    /**
     * Obtiene la clave.
     *
     * @return La clave.
     */
    public String getKey() {
        return key;
    }

    /**
     * Establece la clave.
     *
     * @param key La clave.
     */
    public void setKey(String key) {
        Gastos.key = key;
    }

    /**
     * Obtiene el ID.
     *
     * @return El ID.
     */
    public int getID() {
        return ID;
    }

    /**
     * Establece el ID.
     *
     * @param iD El ID.
     */
    public void setID(int iD) {
        ID = iD;
    }

    /**
     * Obtiene la imagen de la categoría.
     *
     * @return La imagen de la categoría.
     */
    public String getImagen_categoria() {
        return imagen_categoria;
    }

    /**
     * Establece la imagen de la categoría.
     *
     * @param imagen_categoria La imagen de la categoría.
     */
    public void setImagen_categoria(String imagen_categoria) {
        this.imagen_categoria = imagen_categoria;
    }

    /**
     * Obtiene la imagen de la subcategoría.
     *
     * @return La imagen de la subcategoría.
     */
    public String getImagen_subcategoria() {
        return imagen_subcategoria;
    }

    /**
     * Establece la imagen de la subcategoría.
     *
     * @param imagen_subcategoria La imagen de la subcategoría.
     */
    public void setImagen_subcategoria(String imagen_subcategoria) {
        this.imagen_subcategoria = imagen_subcategoria;
    }

    /**
     * Obtiene el nombre de la categoría.
     *
     * @return El nombre de la categoría.
     */
    public String getNombre_categoria() {
        return nombre_categoria;
    }

    /**
     * Establece el nombre de la categoría.
     *
     * @param nombre_categoria El nombre de la categoría.
     */
    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    /**
     * Obtiene el nombre de la subcategoría.
     *
     * @return El nombre de la subcategoría.
     */
    public String getNombre_subcategoria() {
        return nombre_subcategoria;
    }

    /**
     * Establece el nombre de la subcategoría.
     *
     * @param nombre_subcategoria El nombre de la subcategoría.
     */
    public void setNombre_subcategoria(String nombre_subcategoria) {
        this.nombre_subcategoria = nombre_subcategoria;
    }

    /**
     * Obtiene el nombre de la tarjeta.
     *
     * @return El nombre de la tarjeta.
     */
    public String getNombre_tarjeta() {
        return nombre_tarjeta;
    }

    /**
     * Establece el nombre de la tarjeta.
     *
     * @param nombre_tarjeta El nombre de la tarjeta.
     */
    public void setNombre_tarjeta(String nombre_tarjeta) {
        this.nombre_tarjeta = nombre_tarjeta;
    }

    /**
     * Obtiene la fecha en formato de cadena.
     *
     * @return La fecha en formato de cadena.
     */
    public String getFechaString() {
        return fechaString;
    }

    /**
     * Establece la fecha en formato de cadena.
     *
     * @param fechaString La fecha en formato de cadena.
     */
    public void setFechaString(String fechaString) {
        this.fechaString = fechaString;
    }

    /**
     * Obtiene la fecha de la tarjeta en formato de cadena.
     *
     * @return La fecha de la tarjeta en formato de cadena.
     */
    public String getFechaTarjetaString() {
        return fechaTarjetaString;
    }

    /**
     * Establece la fecha de la tarjeta en formato de cadena.
     *
     * @param fechaTarjetaString La fecha de la tarjeta en formato de cadena.
     */
    public void setFechaTarjetaString(String fechaTarjetaString) {
        this.fechaTarjetaString = fechaTarjetaString;
    }

    /**
     * Obtiene el color.
     *
     * @return El color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color.
     *
     * @param color El color.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene el ID de la subcategoría asociada al gasto.
     *
     * @return El ID de la subcategoría.
     */
    public int getIdSub() {
        return IdSub;
    }

    /**
     * Establece el ID de la subcategoría asociada al gasto.
     *
     * @param idSub El ID de la subcategoría a establecer.
     */
    public void setIdSub(int idSub) {
        IdSub = idSub;
    }

    /**
     * Obtiene el ID de la categoría subcategoría al gasto.
     *
     * @return El ID de la categoría subcategoría.
     */
    public int getIdCatSub() {
        return IdCatSub;
    }

    /**
     * Establece el ID de la categoría subcategoría al gasto.
     *
     * @param idCatSub El ID de la categoría subcategoría a establecer.
     */
    public void setIdCatSub(int idCatSub) {
        IdCatSub = idCatSub;
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
	 * Realiza los update oportunos y necesarios.
	 *
	 * @throws SQLException si ocurre un error al interactuar con la base de datos.
	 */	
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





