package modelo;

import java.util.Date;
import java.math.BigDecimal;

/**
 * La clase Tarjeta representa una tarjeta.
 * 
 * @param id          El ID de la tarjeta.
 * @param nombre      El nombre de la tarjeta.
 * @param vencimiento La fecha de vencimiento de la tarjeta.
 * @param descripcion La descripción de la tarjeta.
 * @param limite      El límite de la tarjeta.
 * @param usuario     El ID del usuario asociado a la tarjeta.
 * 
 * @author  Javier Luque Pardo
 * 
 */
public class Tarjeta {
    private int id;
    private String nombre;
    private Date vencimiento;
    private String descripcion;
    private BigDecimal limite;
    private int usuario;

    /**
     * Crea un nuevo objeto Tarjeta sin inicializar sus atributos.
     */
    public Tarjeta() {

    }

    /**
     * Crea un nuevo objeto Tarjeta con los atributos especificados.
     *
     * @param id          El ID de la tarjeta.
     * @param nombre      El nombre de la tarjeta.
     * @param vencimiento La fecha de vencimiento de la tarjeta.
     * @param descripcion La descripción de la tarjeta.
     * @param limite      El límite de la tarjeta.
     * @param usuario     El ID del usuario asociado a la tarjeta.
     */
    public Tarjeta(int id, String nombre, Date vencimiento, String descripcion, BigDecimal limite, int usuario) {
        this.id = id;
        this.nombre = nombre;
        this.vencimiento = vencimiento;
        this.descripcion = descripcion;
        this.limite = limite;
        this.usuario = usuario;
    }

    /**
     * Crea un nuevo objeto Tarjeta con los atributos especificados, sin el ID del usuario.
     *
     * @param id          El ID de la tarjeta.
     * @param nombre      El nombre de la tarjeta.
     * @param vencimiento La fecha de vencimiento de la tarjeta.
     * @param descripcion La descripción de la tarjeta.
     * @param limite      El límite de la tarjeta.
     */
    public Tarjeta(int id, String nombre, Date vencimiento, String descripcion, BigDecimal limite) {
        this.id = id;
        this.nombre = nombre;
        this.vencimiento = vencimiento;
        this.descripcion = descripcion;
        this.limite = limite;
    }

    /**
     * Obtiene el ID de la tarjeta.
     *
     * @return El ID de la tarjeta.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la tarjeta.
     *
     * @param id El ID de la tarjeta.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la tarjeta.
     *
     * @return El nombre de la tarjeta.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la tarjeta.
     *
     * @param nombre El nombre de la tarjeta.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de vencimiento de la tarjeta.
     *
     * @return La fecha de vencimiento de la tarjeta.
     */
    public Date getVencimiento() {
        return vencimiento;
    }

    /**
     * Establece la fecha de vencimiento de la tarjeta.
     *
     * @param vencimiento La fecha de vencimiento de la tarjeta.
     */
    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    /**
     * Obtiene la descripción de la tarjeta.
     *
     * @return La descripción de la tarjeta.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la tarjeta.
     *
     * @param descripcion La descripción de la tarjeta.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el límite de la tarjeta.
     *
     * @return El límite de la tarjeta.
     */
    public BigDecimal getLimite() {
        return limite;
    }

    /**
     * Establece el límite de la tarjeta.
     *
     * @param limite El límite de la tarjeta.
     */
    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    /**
     * Obtiene el ID del usuario asociado a la tarjeta.
     *
     * @return El ID del usuario asociado a la tarjeta.
     */
    public int getUsuario() {
        return usuario;
    }

    /**
     * Establece el ID del usuario asociado a la tarjeta.
     *
     * @param usuario El ID del usuario asociado a la tarjeta.
     */
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve una representación en cadena del objeto Tarjeta.
     *
     * @return Una cadena que representa al objeto Tarjeta.
     */
    @Override
    public String toString() {
        return "Tarjeta [id=" + id + ", nombre=" + nombre + ", vencimiento=" + vencimiento + ", descripcion="
                + descripcion + ", limite=" + limite + ", usuario=" + usuario + "]";
    }
}

