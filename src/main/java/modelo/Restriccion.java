package modelo;

/**
 * La clase Restriccion representa una restricción.
 * 
* @param id          El ID de la restricción.
 * @param concepto    El concepto de la restricción.
 * @param categoria   La categoría de la restricción.
 * @param subcategoria La subcategoría de la restricción.
 * @param usuario     El ID del usuario asociado a la restricción.
 * 
 * @author Javier Luque Pardo
 * 
 */
public class Restriccion {
    private int id;
    private String concepto;
    private String categoria;
    private String subcategoria;
    private int usuario;

    /**
     * Crea un nuevo objeto Restriccion sin inicializar sus atributos.
     */
    public Restriccion() {

    }

    /**
     * Crea un nuevo objeto Restriccion con los atributos especificados.
     *
     * @param id          El ID de la restricción.
     * @param concepto    El concepto de la restricción.
     * @param categoria   La categoría de la restricción.
     * @param subcategoria La subcategoría de la restricción.
     * @param usuario     El ID del usuario asociado a la restricción.
     */
    public Restriccion(int id, String concepto, String categoria, String subcategoria, int usuario) {
        this.id = id;
        this.concepto = concepto;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.usuario = usuario;
    }

    /**
     * Crea un nuevo objeto Restriccion con los atributos especificados.
     *
     * @param id          El ID de la restricción.
     * @param concepto    El concepto de la restricción.
     * @param categoria   La categoría de la restricción.
     * @param subcategoria La subcategoría de la restricción.
     */
    public Restriccion(int id, String concepto, String categoria, String subcategoria) {
        this.id = id;
        this.concepto = concepto;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
    }

    /**
     * Obtiene el ID de la restricción.
     *
     * @return El ID de la restricción.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la restricción.
     *
     * @param id El ID de la restricción.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el concepto de la restricción.
     *
     * @return El concepto de la restricción.
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Establece el concepto de la restricción.
     *
     * @param concepto El concepto de la restricción.
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * Obtiene la categoría de la restricción.
     *
     * @return La categoría de la restricción.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría de la restricción.
     *
     * @param categoria La categoría de la restricción.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene la subcategoría de la restricción.
     *
     * @return La subcategoría de la restricción.
     */
    public String getSubcategoria() {
        return subcategoria;
    }

    /**
     * Establece la subcategoría de la restricción.
     *
     * @param subcategoria La subcategoría de la restricción.
     */
    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    /**
     * Obtiene el ID del usuario asociado a la restricción.
     *
     * @return El ID del usuario asociado a la restricción.
     */
    public int getUsuario() {
        return usuario;
    }

    /**
     * Establece el ID del usuario asociado a la restricción.
     *
     * @param usuario El ID del usuario asociado a la restricción.
     */
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve una representación en cadena del objeto Restriccion.
     *
     * @return Una cadena que representa al objeto Restriccion.
     */
    @Override
    public String toString() {
        return "Restriccion [id=" + id + ", concepto=" + concepto + ", categoria=" + categoria + ", subcategoria="
                + subcategoria + ", usuario=" + usuario + "]";
    }
}


