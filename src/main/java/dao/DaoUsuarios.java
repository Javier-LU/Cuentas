package dao;

import modelo.*;


import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;


public class DaoUsuarios {

	
	private Connection con = null;

	public DaoUsuarios() throws SQLException {
		con = DBConection.getConnection();
	}
	
	
	
	public ArrayList<Imagenes> listar() throws SQLException {
	    PreparedStatement ps = con.prepareStatement("SELECT ID_imagen, imagen FROM imagen WHERE tipo = 'login'");
	    ResultSet rs = ps.executeQuery();
	    ArrayList<Imagenes> result = new ArrayList<>();
	    while (rs.next()) {
	        result.add(new Imagenes(rs.getString("imagen"), rs.getInt("ID_imagen")));
	    }
	    return result;
	}
	
	public String damejson() throws SQLException {
		String json = "";
		Gson son = new Gson();		
		json = son.toJson(this.listar());		
		return json;
	}
	// -----------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------
	public ArrayList<Usuario> listarUsuarios() throws SQLException {
	    PreparedStatement ps = con.prepareStatement("SELECT nombre FROM usuario ");
	    ResultSet rs = ps.executeQuery();
	    ArrayList<Usuario> result = new ArrayList<>();
	    while (rs.next()) {
	        result.add(new Usuario(rs.getString("nombre") ));
	    }
	    return result;
	}
	
	public String damejsonUsuarios() throws SQLException {
		String json = "";
		Gson son = new Gson();		
		json = son.toJson(this.listarUsuarios());		
		return json;
	}
	
	
	public void insertar (Usuario a) throws SQLException {
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO usuario (nombre, ID_imagen, contraseña) VALUES (?, ?, ?)");
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


