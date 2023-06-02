package modelo;

import java.sql.SQLException;

import dao.DaoCategoriasSub;

/**
 * La clase CategoriaSub representa una  subcategorías.
 * 
 * @param id          El ID de la categoría de subcategorías.
 * @param idCategoria El ID de la categoría principal.
 * @param nombre      El nombre de la categoría de subcategorías.
 * @param img         EL src de la imagens.
 * @param imgInt      El ID de la imagen de  subcategorías.
 * @param usuario     El ID del usuario asociado a la subcategorías.
 * 
 * @author  Javier Luque Pardo
 */
public class CategoriaSub {
    private int id;
    private int idCategoria;
    private String nombre;
    private String img;
    private int imgInt;
    private int usuario;

    /**
     * Crea un nuevo objeto CategoriaSub sin inicializar sus atributos.
     */
    public CategoriaSub() {
        super();
    }

    /**
     * Crea un nuevo objeto CategoriaSub con los valores especificados.
     *
     * @param id          El ID de la categoría de subcategorías.
     * @param idCategoria El ID de la categoría principal.
     * @param nombre      El nombre de la categoría de subcategorías.
     * @param img         EL src de la imagens.
     * @param usuario     El ID del usuario asociado a la subcategorías.
     */
    public CategoriaSub(int id, int idCategoria, String nombre, String img, int usuario) {   
        this.id = id;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.img = img;
        this.usuario = usuario;
    }

    /**
     * Crea un nuevo objeto CategoriaSub con los valores especificados sin el usuario.
     *
     * @param id          El ID de la categoría de subcategorías.
     * @param idCategoria El ID de la categoría principal.
     * @param nombre      El nombre de la categoría de subcategorías.
     * @param img         EL src de la imagens.
     */
    public CategoriaSub(int id, int idCategoria, String nombre, String img) {       
        this.id = id;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.img = img;
    }

    /**
     * Crea un nuevo objeto CategoriaSub con los valores especificados.
     *
     * @param id          El ID de la categoría de subcategorías.
     * @param idCategoria El ID de la categoría principal.
     * @param nombre      El nombre de la categoría de subcategorías.
     * @param imgInt      El ID de la imagen de  subcategorías.
     */
    public CategoriaSub(int id, int idCategoria, String nombre, int imgInt) {       
        this.id = id;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.imgInt = imgInt;
    }

    /**
     * Obtiene el ID de la categoría de subcategorías.
     *
     * @return El ID de la categoría de subcategorías.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la categoría de subcategorías.
     *
     * @param id El ID de la categoría de subcategorías.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el ID de la categoría principal.
     *
     * @return El ID de la categoría principal.
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * Establece el ID de la categoría principal.
     *
     * @param idCategoria El ID de la categoría principal.
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * Obtiene el nombre de la categoría de subcategorías.
     *
     * @return El nombre de la categoría de subcategorías.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la categoría de subcategorías.
     *
     * @param nombre El nombre de la categoría de subcategorías.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la imagen de la categoría de subcategorías.
     *
     * @return La imagen de la categoría de subcategorías.
     */
    public String getImg() {
        return img;
    }

    /**
     * Establece la imagen de la categoría de subcategorías.
     *
     * @param img La imagen de la categoría de subcategorías.
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * Obtiene el ID de la imagen de la categoría de subcategorías.
     *
     * @return El ID de la imagen de la categoría de subcategorías.
     */
    public int getImgInt() {
        return imgInt;
    }

    /**
     * Establece el ID de la imagen de la categoría de subcategorías.
     *
     * @param imgInt El ID de la imagen de la categoría de subcategorías.
     */
    public void setImgInt(int imgInt) {
        this.imgInt = imgInt;
    }

    /**
     * Obtiene el ID del usuario asociado a la categoría de subcategorías.
     *
     * @return El ID del usuario asociado a la categoría de subcategorías.
     */
    public int getUsuario() {
        return usuario;
    }

    /**
     * Establece el ID del usuario asociado a la categoría de subcategorías.
     *
     * @param usuario El ID del usuario asociado a la categoría de subcategorías.
     */
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    
    /**
     * Devuelve una representación en forma de cadena de la subcategoría.
     *
     * @return La representación en forma de cadena de la subcategoría.
     */
    @Override
    public String toString() {
        return "CategoriaSub [id=" + id + ", idCategoria=" + idCategoria + ", nombre=" + nombre + ", img=" + img
                + ", imgInt=" + imgInt + ", usuario=" + usuario + "]";
    }

    /**
     * Verifica si la variable imgInt está vacía.
     *
     * @return true si la variable imgInt está vacía, false de lo contrario.
     */
    public boolean imgIntVacia() {
        return imgInt == 0;
    }

    /**
     * Verifica si la variable nombre está vacía.
     *
     * @return true si la variable nombre está vacía o es nula, false de lo contrario.
     */
    public boolean nombreVacia() {
        return nombre == null || nombre.isEmpty();
    }

    /**
     * Actualiza la categoría de subcategorías en la base de datos.
     *
     * @throws SQLException Si ocurre un error al actualizar la categoría de subcategorías.
     */
    public void update() throws SQLException {
        DaoCategoriasSub dao = new DaoCategoriasSub();
        dao.update(this);
    }
}

   
