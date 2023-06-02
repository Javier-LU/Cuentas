package dao;

import java.io.File;
import modelo.*;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

/**
* La clase DaoImgenes proporciona métodos para realizar operaciones relacionadas con las imágenes en la base de datos.
* 
* @param con	La conexión a la base de datos.
* 
* @author  Javier Luque Pardo
*/
public class DaoImgenes {
	
	private Connection con = null;

    /**
     * Crea un nuevo objeto DaoImgenes y establece la conexión a la base de datos.
     *
     * @throws SQLException Si ocurre un error al establecer la conexión.
     */
	public DaoImgenes() throws SQLException {
		con = DBConection.getConnection();
	}
	
    /**
     * Inserta una imagen en la base de datos.
     *
     * @param a La imagen a insertar.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
	public void insertar (Imagenes a) throws SQLException {		
		PreparedStatement ps = con.prepareStatement("INSERT INTO imagen (tipo, imagen) VALUES (?, ?)");
		ps.setString(1, a.getTipo());
		ps.setString(2, a.getImg());	
		ps.executeUpdate();		
		ps.close(); 	
	}		
	
    /**
     * Elimina una imagen físicamente del sistema de archivos.
     *
     * @param a La imagen a eliminar.
     */
	public void eliminarFisico(Imagenes a) {
		 try {
			 String original = a.getImg();
			 String reemplazado = original.replace("/", "\\");
			 String rutaBase = "D:\\Programacion\\Poryecto_1_Daw\\Proyecto\\Cuenta\\src\\main\\webapp\\Vista\\";
	            File file = new File(rutaBase + reemplazado);
	            System.out.println(file);
	            if (file.delete()) {
	                System.out.println("El archivo ha sido eliminado.");
	            } else {
	                System.out.println("La eliminación del archivo ha fallado.");
	            }
	        } catch (Exception e) {
	            System.out.println("Ha ocurrido un error.");
	        }
	    }
	
    /**
     * Elimina una imagen de la base de datos.
     *
     * @param a La imagen a eliminar.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
	public void eliminarBaseDatos (Imagenes a) throws SQLException {
		PreparedStatement ps = con.prepareStatement("DELETE FROM imagen WHERE imagen = ?");
		ps.setString(1, a.getImg());		
		ps.executeUpdate();		
		ps.close(); 		
	}

	
	
    /**
     * Obtiene una lista de imágenes de categorías desde la base de datos.
     *
     * @return La lista de imágenes de categorías.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
	private ArrayList<Imagenes> listarCategoria() throws SQLException {
	    PreparedStatement ps = con.prepareStatement("SELECT ID_imagen, imagen FROM imagen WHERE tipo = 'categoria'");
	    ResultSet rs = ps.executeQuery();
	    ArrayList<Imagenes> result = new ArrayList<>();
	    while (rs.next()) {
	        result.add(new Imagenes(rs.getString("imagen"), rs.getInt("ID_imagen")));
	    }
	    return result;
	}
	
    /**
     * Obtiene un objeto JSON que representa la lista de imágenes de categorías.
     *
     * @return El objeto JSON que representa la lista de imágenes de categorías.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */	
	public String damejsonCategoria() throws SQLException {
		String json = "";
		Gson son = new Gson();		
		json = son.toJson(this.listarCategoria());		
		return json;
	
	}
		
	 /**
     * Obtiene una lista de imágenes de subcategorías desde la base de datos.
     *
     * @return La lista de imágenes de subcategorías.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
	private ArrayList<Imagenes> listarSubcategoria() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT ID_imagen, imagen FROM imagen WHERE tipo NOT IN ('categoria', 'login')");
	    ResultSet rs = ps.executeQuery();
	    ArrayList<Imagenes> result = new ArrayList<>();
	    while (rs.next()) {
	        result.add(new Imagenes(rs.getString("imagen"), rs.getInt("ID_imagen")));
	    }	   
	    return result;	    
	}
	
    /**
     * Obtiene un objeto JSON que representa la lista de imágenes de subcategorías.
     *
     * @return El objeto JSON que representa la lista de imágenes de subcategorías.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */	
	public String damejsonSubcategoria() throws SQLException {
		String json = "";
		Gson son = new Gson();		
		json = son.toJson(this.listarSubcategoria());		
		return json;	
	}
	
	
    /**
     * Obtiene una lista de imágenes de usuarios desde la base de datos.
     *
     * @return La lista de imágenes de usuarios.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
	private ArrayList<Imagenes> listarUsuarios() throws SQLException {
	    PreparedStatement ps = con.prepareStatement("SELECT ID_imagen, imagen FROM imagen WHERE tipo = 'login'");
	    ResultSet rs = ps.executeQuery();
	    ArrayList<Imagenes> result = new ArrayList<>();
	    while (rs.next()) {
	        result.add(new Imagenes(rs.getString("imagen"), rs.getInt("ID_imagen")));
	    }
	    return result;
	}
	
    /**
     * Obtiene un objeto JSON que representa la lista de imágenes de usuarios.
     *
     * @return El objeto JSON que representa la lista de imágenes de usuarios.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */	
	public String damejsonUsuarios() throws SQLException {
		String json = "";
		Gson son = new Gson();		
		json = son.toJson(this.listarUsuarios());		
		return json;
	}
	
	
	
	
}

	
	

