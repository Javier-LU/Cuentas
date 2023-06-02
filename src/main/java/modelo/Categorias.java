package modelo;

import java.sql.SQLException;
import dao.DaoCategorias;

/**
 * La clase Categorias representa las categorías en el sistema.
 * 
 * @param id         El ID de la categoría.
 * @param nombre     El nombre de la categoría.
 * @param img        El ID de la imagen de la categoría.
 * @param imgString  La imagen en formato de cadena de la categoría. El src.
 * @param color      El color de la categoría.
 * @param usuario    El ID del usuario asociado a la categoría.
 *  
 * @author  Javier Luque Pardo
 */
public class Categorias {
    private int id;
    private String nombre;
    private int img;
    private String imgString;
    private String color;
    private int usuario;

    /**
     * Crea un nuevo objeto Categorias sin inicializar sus atributos.
     */
    public Categorias() {
        
    }

    /**
     * Crea un nuevo objeto Categorias con los valores especificados.
     *
     * @param id         El ID de la categoría.
     * @param nombre     El nombre de la categoría.
     * @param imgString  La imagen en formato de cadena de la categoría. El src.
     * @param color      El color de la categoría.
     */
    public Categorias(int id, String nombre, String imgString, String color) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.imgString = imgString;
        this.color = color;
    }

    /**
     * Crea un nuevo objeto Categorias con los valores especificados.
     *
     * @param id         El ID de la categoría.
     * @param nombre     El nombre de la categoría.
     * @param img        El ID de la imagen de la categoría.
     * @param color      El color de la categoría.
     * @param usuario    El ID del usuario asociado a la categoría.
     */
    public Categorias(int id, String nombre, int img, String color, int usuario) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.img = img;
        this.color = color;
        this.usuario = usuario;
    }

    /**
     * Crea un nuevo objeto Categorias con los valores especificados.
     *
     * @param id         El ID de la categoría.
     * @param nombre     El nombre de la categoría.
     * @param img        El ID de la imagen de la categoría.
     * @param color      El color de la categoría.
     */
    public Categorias(int id, String nombre, int img, String color) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.img = img;
        this.color = color;
    }

    /**
     * Crea un nuevo objeto Categorias con los valores especificados.
     *
     * @param id         El ID de la categoría.
     * @param nombre     El nombre de la categoría.
     * @param imgString  La imagen en formato de cadena de la categoría.
     * @param color      El color de la categoría.
     * @param usuario    El ID del usuario asociado a la categoría.
     */
    public Categorias(int id, String nombre, String imgString, String color, int usuario) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.imgString = imgString;
        this.color = color;
        this.usuario = usuario;
    }

    /**
     * Crea un nuevo objeto Categorias con los valores especificados.
     *
     * @param id         El ID de la categoría.
     * @param nombre     El nombre de la categoría.
     * @param img        El ID de la imagen de la categoría.
     * @param imgString  La imagen en formato de cadena de la categoría.
     * @param color      El color de la categoría.
         * El ID del usuario asociado a la categoría.
     */
    public Categorias(int id, String nombre, int img, String imgString, String color, int usuario) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.img = img;
        this.imgString = imgString;
        this.color = color;
        this.usuario = usuario;
    }

    /**
     * Obtiene la imagen en formato de cadena de la categoría.
     *
     * @return La imagen en formato de cadena de la categoría.
     */
    public String getImgString() {
        return imgString;
    }

    /**
     * Establece la imagen en formato de cadena de la categoría.
     *
     * @param imgString La imagen en formato de cadena de la categoría.
     */
    public void setImgString(String imgString) {
        this.imgString = imgString;
    }

    /**
     * Obtiene el ID de la categoría.
     *
     * @return El ID de la categoría.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la categoría.
     *
     * @param id El ID de la categoría.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la categoría.
     *
     * @return El nombre de la categoría.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la categoría.
     *
     * @param nombre El nombre de la categoría.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID de la imagen de la categoría.
     *
     * @return El ID de la imagen de la categoría.
     */
    public int getImg() {
        return img;
    }

    /**
     * Establece el ID de la imagen de la categoría.
     *
     * @param img El ID de la imagen de la categoría.
     */
    public void setImg(int img) {
        this.img = img;
    }

    /**
     * Obtiene el color de la categoría.
     *
     * @return El color de la categoría.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color de la categoría.
     *
     * @param color El color de la categoría.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene el ID del usuario asociado a la categoría.
     *
     * @return El ID del usuario asociado a la categoría.
     */
    public int getUsuario() {
        return usuario;
    }

    /**
     * Establece el ID del usuario asociado a la categoría.
     *
     * @param usuario El ID del usuario asociado a la categoría.
     */
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    
    /**
     * Devuelve una representación en forma de cadena de la categoría.
     *
     * @return La representación en forma de cadena de la categoría.
     */
    @Override
    public String toString() {
        return "Categorias [id=" + id + ", nombre=" + nombre + ", img=" + img + ", imgString=" + imgString + ", color="
                + color + ", usuario=" + usuario + "]";
    }

    /**
       * Verifica si la variable nombre está vacía. Lo utilizo para saber a que parametro realizar el update.
     *
     * @return true si la variable nombre está vacía o es nula, false de lo contrario.
     */
    public boolean nombreVacia() {
        return nombre == null || nombre.isEmpty();
    }

    /**
     * Verifica si la variable img está vacía. Lo utilizo para saber a que parametro realizar el update.
     *
     * @return true si la variable img es igual a 0, false de lo contrario.
     */
    public boolean imgVacia() {
        return img == 0;
    }

    /**
     * Verifica si la variable color está vacía. Lo utilizo para saber a que parametro realizar el update.
     *
     * @return true si la variable color está vacía o es nula, false de lo contrario.
     */
    public boolean colorVacia() {
        return color == null || color.isEmpty();
    }

    /**
     * Actualiza la categoría en la base de datos.
     *
     * @throws SQLException Si ocurre un error al actualizar la categoría.
     */
    public void update() throws SQLException {
        DaoCategorias dao = new DaoCategorias();
        dao.update(this);
    }
}



