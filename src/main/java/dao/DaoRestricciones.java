package dao;

import modelo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

/**
  * La clase DaoRestricciones solo tiene implementado los metodos para obtener la lista de las restricciones.
 * 
 * @param con	La conexión a la base de datos.
 * 
 * @author  Javier Luque Pardo
 */

public class DaoRestricciones {

	private Connection con = null;

	  /**
     * Crea un nuevo objeto DaoRestricciones y establece la conexión a la base de datos.
     *
     * @throws SQLException Si ocurre un error al establecer la conexión.
     */
    public DaoRestricciones() throws SQLException {
        con = DBConection.getConnection();
    }

    /**
     * Obtiene una lista de restricciones desde la base de datos.
     *
     * @return La lista de restricciones.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
    private ArrayList<Restriccion> listarRestriccion() throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT ID_restriccion, concepto, nombre_categoria, nombre_subcategoria, ID_usuario FROM vista_restriccion");
        ResultSet rs = ps.executeQuery();
        ArrayList<Restriccion> result = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("ID_restriccion");
            String nombre = rs.getString("concepto");
            String cat = rs.getString("nombre_categoria");
            String sub = rs.getString("nombre_subcategoria");
            result.add(new Restriccion(id, nombre, cat, sub));
        }
        return result;
    }

    /**
     * Obtiene un objeto JSON que representa la lista de restricciones.
     *
     * @return El objeto JSON que representa la lista de restricciones.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
    public String damejsonRestriccion() throws SQLException {
        String json = "";
        Gson son = new Gson();
        json = son.toJson(this.listarRestriccion());
        return json;
    }
}