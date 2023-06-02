package dao;

import modelo.*;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

/**
 * La clase DaoUsuarios proporciona métodos para realizar operaciones relacionadas con los usuarios en la base de datos.
 * 
 * @param con	La conexión a la base de datos.
 * 
 * @author  Javier Luque Pardo
 */
public class DaoUsuarios {

    private Connection con = null;

    /**
     * Crea un nuevo objeto DaoUsuarios y establece la conexión a la base de datos.
     *
     * @throws SQLException Si ocurre un error al establecer la conexión.
     */
    public DaoUsuarios(Connection con) {
        this.con = con;
    }
    
    
    public DaoUsuarios() throws SQLException {
    	this(DBConection.getConnection());
    }


    /**
     * Obtiene una lista de imágenes de tipo "login" desde la base de datos.
     *
     * @return La lista de imágenes de tipo "login".
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
    public ArrayList<Imagenes> listar() throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT ID_imagen, imagen FROM imagen WHERE tipo = 'login'");
        ResultSet rs = ps.executeQuery();
        ArrayList<Imagenes> result = new ArrayList<>();
        while (rs.next()) {
            result.add(new Imagenes(rs.getString("imagen"), rs.getInt("ID_imagen")));
        }
        return result;
    }

    /**
     * Obtiene un objeto JSON que representa la lista de imágenes de tipo "login".
     *
     * @return El objeto JSON que representa la lista de imágenes.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
    public String damejson() throws SQLException {
        String json = "";
        Gson son = new Gson();
        json = son.toJson(this.listar());
        return json;
    }

    /**
     * Obtiene una lista de usuarios desde la base de datos.
     *
     * @return La lista de usuarios.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
    public ArrayList<Usuario> listarUsuarios() throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT nombre FROM usuario");
        ResultSet rs = ps.executeQuery();
        ArrayList<Usuario> result = new ArrayList<>();
        while (rs.next()) {
            result.add(new Usuario(rs.getString("nombre")));
        }
        return result;
    }

    /**
     * Obtiene un objeto JSON que representa la lista de usuarios.
     *
     * @return El objeto JSON que representa la lista de usuarios.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
    public String damejsonUsuarios() throws SQLException {
        String json = "";
        Gson son = new Gson();
        json = son.toJson(this.listarUsuarios());
        return json;
    }

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param a El objeto Usuario a insertar.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
	public void insertar (Usuario a) throws SQLException {
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO usuario (nombre, ID_imagen, pass) VALUES (?, ?, ?)");
		ps.setString(1, a.getNombre());
		ps.setString(2, a.getImg());
		ps.setString(3, a.getPass());
		ps.executeUpdate();		
		ps.close();	
		
		String consulta = "CREATE USER '" +  a.getNombre() + "'@'localhost' IDENTIFIED BY '" + a.getPass() + "'";
	    Statement stmt = con.createStatement();
	    stmt.executeUpdate(consulta);
	   
	    consulta = "GRANT SELECT, INSERT, UPDATE, DELETE, DROP ON cuentas.* TO '" + a.getNombre() + "'@'localhost'";
	    stmt = con.createStatement();
	    stmt.executeUpdate(consulta);
	   

	    stmt = con.createStatement();
	    stmt.executeUpdate("FLUSH PRIVILEGES");
	    stmt.close();
	 
	}
}