package dao;

import modelo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class DaoCategoriasSub {

	private Connection con = null;

	public DaoCategoriasSub() throws SQLException {
		con = DBConection.getConnection();
	}
	
	private ArrayList<CategoriaSub> listarSubcategoria() throws SQLException {
	    PreparedStatement ps = con.prepareStatement("select ID_subcategoria, nombre, ID_categoria, imagen from vista_subcategoria;");
	    ResultSet rs = ps.executeQuery();
	    ArrayList<CategoriaSub> result = new ArrayList<>();
	    while (rs.next()) {
	        int id = rs.getInt("ID_subcategoria");
	        int idCategoria = rs.getInt("ID_categoria");
	        String nombre = rs.getString("nombre");	        
	        String img = rs.getString("imagen");
	        result.add(new CategoriaSub(id, idCategoria, nombre,  img));
	    }
	    return result;
	}
	public String damejsonSubcategoria() throws SQLException {
		String json = "";
		Gson son = new Gson();		
		json = son.toJson(this.listarSubcategoria());		
		return json;
	}
	
	
	// **************************************************
	
	public void update(CategoriaSub c) throws SQLException {
		if(!c.nombreVacia() && !c.imgIntVacia() ) {
			System.out.println("HA ENTRADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO" + c.getImgInt());
			System.out.println("Nombre: " + c.getNombre());
			System.out.println("ID Categoría: " + c.getIdCategoria());
			System.out.println("ID Imagen: " + c.getImgInt());
			System.out.println("-------------------------------------------------------------------------------------------------------------: " + c.getImgInt());
			PreparedStatement ps = con.prepareStatement("INSERT INTO subcategoria (nombre, ID_categoria, ID_imagen) VALUES (?, ?, ?)");
			ps.setString(1, c.getNombre());			
			ps.setInt(2, c.getIdCategoria());
			ps.setInt(3, c.getImgInt());
			
			ps.executeUpdate();			
			ps.close(); 
			
		}	else if(!c.nombreVacia()) {
			System.out.println("1111111111111111111111111" + c.getImgInt());
			PreparedStatement ps = con.prepareStatement("UPDATE subcategoria SET nombre = ? WHERE ID_subcategoria = ?");	
			
			ps.setString(1, c.getNombre());
			ps.setInt(2, c.getId());
			
			ps.executeUpdate();			
			ps.close(); 
		}  else if (!c.imgIntVacia()){
			System.out.println("222222222222222222222222" + c.getImgInt());
			PreparedStatement ps = con.prepareStatement("UPDATE subcategoria SET ID_imagen = ? WHERE ID_subcategoria = ?");			
			
			ps.setInt(1, c.getImgInt());
			ps.setInt(2, c.getId());
			
			ps.executeUpdate();			
			ps.close();
			} else {
				System.out.println("3333333333333333333333333333333" + c.getImgInt());
				PreparedStatement ps = con.prepareStatement("DELETE FROM subcategoria WHERE ID_subcategoria = ?");
				ps.setInt(1, c.getId());
				ps.executeUpdate();			
				ps.close();
			}		
	}
	
	
	
	
	
}
