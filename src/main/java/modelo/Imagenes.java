package modelo;

import java.sql.SQLException;
import dao.DaoImgenes;

/**
 * La clase Imagenes representa una imagen.
 * 
 * @param img  guarda el src de la imagen
 * @param id   identificador
 * @param tipo tipo de la imagen.
 * @param DaoImgenes instancia de la clase DaoImgenes.
 * 
 * @author Javier Luque Pardo
 */
public class Imagenes {
    	private String img;
    private int id;
    private String tipo;
    private DaoImgenes dao;

    /**
     * Crea un nuevo objeto Imagenes sin inicializar sus atributos.
     */
    public Imagenes() {

    }
    
    /**
     * Constructor con todos los parametros.
     * 
     * @param img  guarda el src de la imagen
	 * @param id   identificador
	 * @param tipo tipo de la imagen.
	 * @param DaoImgenes instancia de la clase DaoImgenes
     */
    public Imagenes(String img, int id, String tipo, DaoImgenes dao) {
		super();
		this.img = img;
		this.id = id;
		this.tipo = tipo;
		this.dao = dao;
	}
    
    

    /**
     * Crea un nuevo objeto Imagenes con la imagen y el tipo especificados.
     *
     * @param img  La imagen.
     * @param tipo El tipo de imagen.
     */
    public Imagenes(String img, String tipo) {
        this.img = img;
        this.tipo = tipo;
    }

    /**
     * Crea un nuevo objeto Imagenes con la imagen y el ID especificados.
     *
     * @param img La imagen.
     * @param id  El ID de la imagen.
     */
    public Imagenes(String img, int id) {
        this.img = img;
        this.id = id;
    }

    /**
     * Crea un nuevo objeto Imagenes con la imagen especificada.
     *
     * @param img La imagen.
     */
    public Imagenes(String img) {
        this.img = img;
    }

    /**
     * Obtiene el tipo de imagen.
     *
     * @return El tipo de imagen.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de imagen.
     *
     * @param tipo El tipo de imagen.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el ID de la imagen.
     *
     * @return El ID de la imagen.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la imagen.
     *
     * @param id El ID de la imagen.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la imagen.
     *
     * @return La imagen.
     */
    public String getImg() {
        return img;
    }

    /**
     * Establece la imagen.
     *
     * @param img La imagen.
     */
    public void setImg(String img) {
        this.img = img;
    }  
    
    /**
     * Obtiene el objeto DaoImgenes asociado a la instancia actual de Imagenes.
     * 
     * @return El objeto DaoImgenes asociado.
     */
    public DaoImgenes getDao() {
        return dao;
    }

    /**
     * Establece el objeto DaoImgenes asociado a la instancia actual de Imagenes.
     * 
     * @param dao El objeto DaoImgenes a establecer.
     */
    public void setDao(DaoImgenes dao) {
        this.dao = dao;
    }

	/**
     * Devuelve una representación en cadena del objeto Imagenes.
     *
     * @return Una cadena que representa al objeto Imagenes.
     */
    @Override
    public String toString() {
        return "Imagenes [img=" + img + "]";
    }

    /**
     * Inserta la imagen en la base de datos.
     *
     * @throws SQLException Si ocurre un error durante la inserción en la base de datos.
     */
    public void insertar() throws SQLException {
        dao = new DaoImgenes();
        dao.insertar(this);
    }

    /**
     * Elimina físicamente la imagen del donde este almacenada.
     *
     * @throws SQLException Si ocurre un error durante la eliminación física de la imagen.
     */
    public void eliminarFisico() throws SQLException {
        dao = new DaoImgenes();
        dao.eliminarFisico(this);
    }

    /**
     * Elimina la imagen de la base de datos.
     *
     * @throws SQLException Si ocurre un error durante la eliminación de la imagen en la base de datos.
     */
    public void eliminarBaseDatos() throws SQLException {
        dao = new DaoImgenes();
        dao.eliminarBaseDatos(this);
    }
}

