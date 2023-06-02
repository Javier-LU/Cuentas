package dao;

import modelo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;


/**
 * Clase de acceso a datos para la tabla Subcategoria.
 * Permite realizar operaciones de consulta y actualización relacionadas con la tabla Subcategoria en la base de datos.
 * 
 *  @param con	La conexión a la base de datos.
 * 
 * 	@author  Javier Luque Pardo
 * 
 */
public class DaoCategoriasSub {

	private Connection con = null;	
	
    /**
     * Constructor de la clase DaoCategoriasSub.
     * Establece la conexión con la base de datos.
     *
     * @throws SQLException Si ocurre un error al establecer la conexión.
     */
	public DaoCategoriasSub() throws SQLException {
		con = DBConection.getConnection();
	}
	
	/**
     * Obtiene una lista de subcategorías desde la base de datos.
     *
     * @return La lista de subcategorías.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
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
	
    /**
     * Obtiene la lista de subcategorías en formato JSON.
     *
     * @return La lista de subcategorías en formato JSON.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
	public String damejsonSubcategoria() throws SQLException {
		String json = "";
		Gson son = new Gson();		
		json = son.toJson(this.listarSubcategoria());		
		return json;
	}
	
	
    /**
     * Actualiza una subcategoría en la base de datos.
     *
     * @param c La subcategoría a actualizar.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
	public void update(CategoriaSub c) throws SQLException {
		if(!c.nombreVacia() && !c.imgIntVacia() ) {
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO subcategoria (nombre, ID_categoria, ID_imagen) VALUES (?, ?, ?)");
			ps.setString(1, c.getNombre());			
			ps.setInt(2, c.getIdCategoria());
			ps.setInt(3, c.getImgInt());
			
			ps.executeUpdate();			
			ps.close(); 
			
		}	else if(!c.nombreVacia()) {
			
			PreparedStatement ps = con.prepareStatement("UPDATE subcategoria SET nombre = ? WHERE ID_subcategoria = ?");	
			
			ps.setString(1, c.getNombre());
			ps.setInt(2, c.getId());
			
			ps.executeUpdate();			
			ps.close(); 
		}  else if (!c.imgIntVacia()){
			
			PreparedStatement ps = con.prepareStatement("UPDATE subcategoria SET ID_imagen = ? WHERE ID_subcategoria = ?");			
			
			ps.setInt(1, c.getImgInt());
			ps.setInt(2, c.getId());
			
			ps.executeUpdate();			
			ps.close();
			} else {
				
				PreparedStatement ps = con.prepareStatement("DELETE FROM subcategoria WHERE ID_subcategoria = ?");
				ps.setInt(1, c.getId());
				ps.executeUpdate();			
				ps.close();
			}		
	}
	
	
	
	
	
}
