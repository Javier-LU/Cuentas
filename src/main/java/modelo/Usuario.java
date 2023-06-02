package modelo;

import java.sql.SQLException;

import dao.DaoUsuarios;


/**
 * La clase Usuario representa un usuario en el sistema de cuentas.
 * 
* @param nombre El nombre del usuario.
 * @param pass   La contraseña del usuario.
 * @param img    La imagen del usuario.
 * 
 * @Autor: Javier Luque Pardo
 */
public class Usuario {
    private String nombre;
    private String pass;
    private String img;

    /**
     * Crea un nuevo objeto Usuario sin inicializar sus atributos.
     */
    public Usuario() {

    }

    /**
     * Crea un nuevo objeto Usuario con los atributos especificados.
     *
     * @param nombre El nombre del usuario.
     * @param pass   La contraseña del usuario.
     * @param img    La imagen del usuario.
     */
    public Usuario(String nombre, String pass, String img) {
        this.nombre = nombre;
        this.pass = pass;
        this.img = img;
    }

    /**
     * Crea un nuevo objeto Usuario con el nombre especificado.
     *
     * @param nombre El nombre del usuario.
     */
    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getPass() {
        return pass;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param pass La contraseña del usuario.
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Obtiene la imagen del usuario.
     *
     * @return La imagen del usuario.
     */
    public String getImg() {
        return img;
    }

    /**
     * Establece la imagen del usuario.
     *
     * @param img La imagen del usuario.
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * Devuelve una representación en cadena del objeto Usuario.
     *
     * @return Una cadena que representa al objeto Usuario.
     */
    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", pass=" + pass + ", img=" + img + "]";
    }

    /**
     * Inserta el usuario en la base de datos.
     *
     * @throws SQLException Si ocurre un error durante la inserción en la base de datos.
     */
    public void insertar() throws SQLException {
        DaoUsuarios dao = new DaoUsuarios();
        dao.insertar(this);
    }
}




	
	
	

