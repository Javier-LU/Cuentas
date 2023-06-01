package dao;

import modelo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class DaoCategorias {

	private Connection con = null;

	public DaoCategorias() throws SQLException {
		con = DBConection.getConnection();
	}
	
	// Json
	private ArrayList<Categorias> listarCategoria() throws SQLException {
		Categorias tosi = new Categorias();
	    PreparedStatement ps = con.prepareStatement("select ID_Categoria, nombre, imagen,  color from vista_categoria;");
	    ResultSet rs = ps.executeQuery();
	    ArrayList<Categorias> result = new ArrayList<>();
	    while (rs.next()) {
	        int id = rs.getInt("ID_Categoria");
	        String nombre = rs.getString("nombre");
	        String imgString = rs.getString("imagen");	        
	        String color = rs.getString("color");
	        result.add(new Categorias(id, nombre, imgString, color ));
	       
	    }
	    
	    return result;
	}	
	public String damejsonCategoria() throws SQLException {
		String json = "";
		Gson son = new Gson();		
		json = son.toJson(this.listarCategoria());		
		return json;
	}
	// **************************************************
	
	public void update(Categorias c) throws SQLException {
		
		if(!c.nombreVacia() && !c.colorVacia()) {
			PreparedStatement ps = con.prepareStatement("INSERT INTO  categoria (  nombre, ID_imagen, color) VALUES (?, ?, ?)");
			System.out.println("HA ENTRADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
			ps.setString(1, c.getNombre());
			ps.setInt(2, c.getImg());
			ps.setString(3, c.getColor());
			ps.executeUpdate();			
			ps.close(); 
		
		}else if(!c.nombreVacia()) {
			PreparedStatement ps = con.prepareStatement("UPDATE categoria SET nombre = ? WHERE ID_Categoria = ?");	
			
			ps.setString(1, c.getNombre());
			ps.setInt(2, c.getId());
			
			ps.executeUpdate();			
			ps.close(); 
			
		}else if (!c.imgVacia()) {
			PreparedStatement ps = con.prepareStatement("UPDATE categoria SET ID_imagen = ? WHERE ID_Categoria = ?");			
			
			ps.setInt(1, c.getImg());
			ps.setInt(2, c.getId());
			
			ps.executeUpdate();			
			ps.close();
			
		}else if (!c.colorVacia()) {
			
				PreparedStatement ps = con.prepareStatement("UPDATE categoria SET color = ? WHERE ID_Categoria = ?");			
				
				ps.setString(1, c.getColor());
				ps.setInt(2, c.getId());
				
				ps.executeUpdate();				
				ps.close();		
			
		}else {
			PreparedStatement ps = con.prepareStatement("DELETE FROM categoria WHERE ID_Categoria = ?");
			ps.setInt(1, c.getId());
			ps.executeUpdate();			
			ps.close();
		}	
		
		
		
	}
	
	

	
	
	
	
	
	
	
	
}
