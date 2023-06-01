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


public class DaoImgenes {
	
	private Connection con = null;

	public DaoImgenes() throws SQLException {
		con = DBConection.getConnection();
	}
	
	////Insertar imagenes
	public void insertar (Imagenes a) throws SQLException {		
		PreparedStatement ps = con.prepareStatement("INSERT INTO imagen (tipo, imagen) VALUES (?, ?)");
		ps.setString(1, a.getTipo());
		ps.setString(2, a.getImg());	
		ps.executeUpdate();		
		ps.close(); 	
	}	
	
	
	//Eliminar imagenes
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
	
	public void eliminarBaseDatos (Imagenes a) throws SQLException {
		PreparedStatement ps = con.prepareStatement("DELETE FROM imagen WHERE imagen = ?");
		ps.setString(1, a.getImg());		
		ps.executeUpdate();		
		ps.close(); 		
	}
	// finnnnnnnnnnnnn ------------------------ Eliminar imagenes
	
	
	// Solictar las imagenes categorias
	private ArrayList<Imagenes> listarCategoria() throws SQLException {
	    PreparedStatement ps = con.prepareStatement("SELECT ID_imagen, imagen FROM imagen WHERE tipo = 'categoria'");
	    ResultSet rs = ps.executeQuery();
	    ArrayList<Imagenes> result = new ArrayList<>();
	    while (rs.next()) {
	        result.add(new Imagenes(rs.getString("imagen"), rs.getInt("ID_imagen")));
	    }
	    return result;
	}
	
	public String damejsonCategoria() throws SQLException {
		String json = "";
		Gson son = new Gson();		
		json = son.toJson(this.listarCategoria());		
		return json;
	
	}
	
	
	// Solictar las imagenes Subcategorias
	private ArrayList<Imagenes> listarSubcategoria() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT ID_imagen, imagen FROM imagen WHERE tipo NOT IN ('categoria', 'login')");
	    ResultSet rs = ps.executeQuery();
	    ArrayList<Imagenes> result = new ArrayList<>();
	    while (rs.next()) {
	        result.add(new Imagenes(rs.getString("imagen"), rs.getInt("ID_imagen")));
	    }
	   
	    return result;
	    
	}
	
	public String damejsonSubcategoria() throws SQLException {
		String json = "";
		Gson son = new Gson();		
		json = son.toJson(this.listarSubcategoria());
		
		return json;
	
	}
	
	
	// Solictar las imagenes Usuarios
	private ArrayList<Imagenes> listarUsuarios() throws SQLException {
	    PreparedStatement ps = con.prepareStatement("SELECT ID_imagen, imagen FROM imagen WHERE tipo = 'login'");
	    ResultSet rs = ps.executeQuery();
	    ArrayList<Imagenes> result = new ArrayList<>();
	    while (rs.next()) {
	        result.add(new Imagenes(rs.getString("imagen"), rs.getInt("ID_imagen")));
	    }
	    return result;
	}
	
	public String damejsonUsuarios() throws SQLException {
		String json = "";
		Gson son = new Gson();		
		json = son.toJson(this.listarUsuarios());		
		return json;
	}
	
	
	
	
}

	
	

