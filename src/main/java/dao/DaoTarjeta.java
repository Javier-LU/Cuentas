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

public class DaoTarjeta {

	private Connection con = null;

	public DaoTarjeta() throws SQLException {
		con = DBConection.getConnection();
	}
	
	private ArrayList<Tarjeta> listarTarjeta() throws SQLException {
	    PreparedStatement ps = con.prepareStatement("select ID_tarjeta, nombre, vencimiento, descripcion, limite from tarjeta;\r\n"
	    		+ "");
	    ResultSet rs = ps.executeQuery();
	    ArrayList<Tarjeta> result = new ArrayList<>();
	    while (rs.next()) {
	        int id = rs.getInt("ID_tarjeta");	   
	        String nombre = rs.getString("nombre");	
	        java.sql.Date vencimiento = rs.getDate("vencimiento");
	        String descripcion = rs.getString("descripcion");	
	        BigDecimal limite = rs.getBigDecimal("limite");	
	     
	        result.add(new Tarjeta(id, nombre, vencimiento, descripcion, limite));
	    }
	    return result;
	}	
	
	
	
	
	public String damejsonTarjeta() throws SQLException {
		String json = "";
		Gson son = new Gson();		
		json = son.toJson(this.listarTarjeta());		
		return json;
	}
	
	
	
	
}
