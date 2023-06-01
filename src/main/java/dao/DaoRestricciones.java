package dao;

import modelo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class DaoRestricciones {

	private Connection con = null;

	public DaoRestricciones() throws SQLException {
		con = DBConection.getConnection();
	}
	
	private ArrayList<Restriccion> listarRestriccion() throws SQLException {
	    PreparedStatement ps = con.prepareStatement("select ID_restriccion, concepto, nombre_categoria, nombre_subcategoria, ID_usuario from vista_restriccion;");
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
	
	public String damejsonRestriccion() throws SQLException {
		String json = "";
		Gson son = new Gson();		
		json = son.toJson(this.listarRestriccion());		
		return json;
	}
	
	

	
}
