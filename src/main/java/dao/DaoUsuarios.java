package dao;

import modelo.*;


import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoUsuarios {

	
	private Connection con = null;

	public DaoUsuarios() throws SQLException {
		con = DBConection.getConnection();
	}
	
	public ArrayList<Imagenes> listar() throws SQLException {
	    PreparedStatement ps = con.prepareStatement("SELECT imagen FROM imagen WHERE tipo = 'login'");
	    ResultSet rs = ps.executeQuery();

	    ArrayList<Imagenes> result = new ArrayList<>();

	    while (rs.next()) {
	        result.add(new Imagenes(rs.getString("imagen")));
	    }

	    return result;
	}
	
	public String damejson() throws SQLException {
		String json = "";
		Gson son = new Gson();
		
		json = son.toJson(this.listar());
		
		return json;
	}  
	
	
	
	
	
}


