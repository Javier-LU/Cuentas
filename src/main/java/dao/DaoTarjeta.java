package dao;
import java.util.Date;
import java.math.BigDecimal;
import modelo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

/**
 * La clase DaoTarjeta solo tiene implementado los metodos para obtener la lista de las tarjetas.
 * 
 * @param con	La conexión a la base de datos.
 * 
 * @author  Javier Luque Pardo
 */
public class DaoTarjeta {

    private Connection con = null;

    /**
     * Crea un nuevo objeto DaoTarjeta y establece la conexión a la base de datos.
     *
     * @throws SQLException Si ocurre un error al establecer la conexión.
     */
    public DaoTarjeta() throws SQLException {
        con = DBConection.getConnection();
    }

    /**
     * Obtiene una lista de tarjetas desde la base de datos.
     *
     * @return La lista de tarjetas.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
    private ArrayList<Tarjeta> listarTarjeta() throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT ID_tarjeta, nombre, vencimiento, descripcion, limite FROM tarjeta");
        ResultSet rs = ps.executeQuery();
        ArrayList<Tarjeta> result = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("ID_tarjeta");
            String nombre = rs.getString("nombre");
            Date vencimiento = rs.getDate("vencimiento");
            String descripcion = rs.getString("descripcion");
            BigDecimal limite = rs.getBigDecimal("limite");
            result.add(new Tarjeta(id, nombre, vencimiento, descripcion, limite));
        }
        return result;
    }

    /**
     * Obtiene un objeto JSON que representa la lista de tarjetas.
     *
     * @return El objeto JSON que representa la lista de tarjetas.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
    public String damejsonTarjeta() throws SQLException {
        String json = "";
        Gson son = new Gson();
        json = son.toJson(this.listarTarjeta());
        return json;
    }
}
