package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import com.google.gson.Gson;
import java.util.Date;
import modelo.Categorias;
import modelo.Gastos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class DaoGastos {

	
	private Connection con = null;

	public DaoGastos() throws SQLException {
		con = DBConection.getConnection();
	}
	
	private ArrayList<Gastos> listarCategoria() throws SQLException {
		Gastos g = new Gastos();
		Date f1 = g.getFecha1();
		Date f2 = g.getFecha2();;
		String key = g.getKey();
		PreparedStatement ps = null; 
		 ResultSet rs = null;
		
		if (key == null) {
	     ps = con.prepareStatement("select ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta from vista_gasto;");
		} else if (key.length() >= 3) {
			
			
			ps = con.prepareStatement("SELECT COUNT(*) FROM vista_gasto WHERE fecha BETWEEN ? AND ? AND nombre_categoria = ?;");
			        ps.setDate(1, new java.sql.Date(f2.getTime()));
			        ps.setDate(2, new java.sql.Date(f1.getTime()));
			        ps.setString(3, key);
			        rs = ps.executeQuery();
			        
			        if(rs.next() && rs.getInt(1) > 0) {
			        	ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? AND nombre_categoria = ? ORDER BY fecha DESC;");
			        	 ps.setDate(1, new java.sql.Date(f2.getTime()));
					     ps.setDate(2, new java.sql.Date(f1.getTime()));
					    ps.setString(3, key);
			        }else {
			        	ps = con.prepareStatement("SELECT COUNT(*) FROM vista_gasto WHERE fecha BETWEEN ? AND ? AND nombre_subcategoria = ?;");
			          	 ps.setDate(1, new java.sql.Date(f2.getTime()));
					     ps.setDate(2, new java.sql.Date(f1.getTime()));
					    ps.setString(3, key);
					    rs = ps.executeQuery();
					    
					    if(rs.next() && rs.getInt(1) > 0) {
				        	ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? AND nombre_subcategoria = ? ORDER BY fecha DESC;");
				        	 ps.setDate(1, new java.sql.Date(f2.getTime()));
						     ps.setDate(2, new java.sql.Date(f1.getTime()));
						     ps.setString(3, key);
					    } else {
					    	ps = con.prepareStatement("SELECT COUNT(*) FROM vista_gasto WHERE fecha BETWEEN ? AND ? AND concepto LIKE ? ;");
					    	
					    	 ps.setDate(1, new java.sql.Date(f2.getTime()));
						     ps.setDate(2, new java.sql.Date(f1.getTime()));
						     ps.setString(3, "%" + key + "%");
						     rs = ps.executeQuery();
						     
						     if(rs.next() && rs.getInt(1) > 0) {
						    	 ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? AND concepto LIKE ? ORDER BY fecha DESC;");	 
						    	 ps.setDate(1, new java.sql.Date(f2.getTime()));
							     ps.setDate(2, new java.sql.Date(f1.getTime()));
							     ps.setString(3, "%" + key + "%");
					    } else {
					    	System.out.println("Sin resultados ");
					    }
					    }
			        	
			        }
			  
			
			
		} else {
		
		
		switch (key) {
		
		case "f1":		
		ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY fecha DESC;");
	        ps.setDate(1, new java.sql.Date(f2.getTime()));
	        ps.setDate(2, new java.sql.Date(f1.getTime()));
	        break;
		case "c1":
			ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) DESC, MONTH(fecha) DESC, concepto DESC;");
			ps.setDate(1, new java.sql.Date(f2.getTime()));
	        ps.setDate(2, new java.sql.Date(f1.getTime()));	        
	        break;
		case "c2":		
				ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) DESC, MONTH(fecha) DESC, concepto ASC;");
		        ps.setDate(1, new java.sql.Date(f2.getTime()));
		        ps.setDate(2, new java.sql.Date(f1.getTime()));
		        break;
		case "c3":		
					ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) ASC, MONTH(fecha) ASC, concepto DESC;");
			        ps.setDate(1, new java.sql.Date(f2.getTime()));
			        ps.setDate(2, new java.sql.Date(f1.getTime()));
			        break;
		case "c4":			
					ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) ASC, MONTH(fecha) ASC, concepto ASC;");
			        ps.setDate(1, new java.sql.Date(f2.getTime()));
			        ps.setDate(2, new java.sql.Date(f1.getTime()));
			        break;
		case "i1":
					    ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) DESC, MONTH(fecha) DESC, importe DESC;");
					    ps.setDate(1, new java.sql.Date(f2.getTime()));
					    ps.setDate(2, new java.sql.Date(f1.getTime()));
					    break;
		case "i2":
					    ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) DESC, MONTH(fecha) DESC, importe ASC;");
					    ps.setDate(1, new java.sql.Date(f2.getTime()));
					    ps.setDate(2, new java.sql.Date(f1.getTime()));
					    break;
		case "i3":
					    ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) ASC, MONTH(fecha) ASC, importe DESC;");
					    ps.setDate(1, new java.sql.Date(f2.getTime()));
					    ps.setDate(2, new java.sql.Date(f1.getTime()));
		case "i4":
					    ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) ASC, MONTH(fecha) ASC, importe ASC;");
					    ps.setDate(1, new java.sql.Date(f2.getTime()));
					    ps.setDate(2, new java.sql.Date(f1.getTime()));
					    break;
		case "s1":
					    ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) DESC, MONTH(fecha) DESC, saldo DESC;");
					    ps.setDate(1, new java.sql.Date(f2.getTime()));
					    ps.setDate(2, new java.sql.Date(f1.getTime()));
					    break;
		case "s2":
					    ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) DESC, MONTH(fecha) DESC, saldo ASC;");
					    ps.setDate(1, new java.sql.Date(f2.getTime()));
					    ps.setDate(2, new java.sql.Date(f1.getTime()));
					    break;
		case "s3":
					    ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) ASC, MONTH(fecha) ASC, saldo DESC;");
					    ps.setDate(1, new java.sql.Date(f2.getTime()));
					    ps.setDate(2, new java.sql.Date(f1.getTime()));
					    break;
		case "s4":
					    ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) ASC, MONTH(fecha) ASC, saldo ASC;");
					    ps.setDate(1, new java.sql.Date(f2.getTime()));
					    ps.setDate(2, new java.sql.Date(f1.getTime()));
					    break;
		case "n1":
					    ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) DESC, MONTH(fecha) DESC, nombre_categoria DESC;");
					    ps.setDate(1, new java.sql.Date(f2.getTime()));
					    ps.setDate(2, new java.sql.Date(f1.getTime()));
					    break;
		case "n2":
					    ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) DESC, MONTH(fecha) DESC, nombre_categoria ASC;");
					    ps.setDate(1, new java.sql.Date(f2.getTime()));
					    ps.setDate(2, new java.sql.Date(f1.getTime()));
					    break;
		case "n3":
					    ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) ASC, MONTH(fecha) ASC, nombre_categoria DESC;");
					    ps.setDate(1, new java.sql.Date(f2.getTime()));
					    ps.setDate(2, new java.sql.Date(f1.getTime()));
					    break;
		case "n4":
					    ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) ASC, MONTH(fecha) ASC, nombre_categoria ASC;");
					    ps.setDate(1, new java.sql.Date(f2.getTime()));
					    ps.setDate(2, new java.sql.Date(f1.getTime()));
					    break;
		case "a1":
					    ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) DESC, MONTH(fecha) DESC, anotaciones DESC;");
					    ps.setDate(1, new java.sql.Date(f2.getTime()));
					    ps.setDate(2, new java.sql.Date(f1.getTime()));
					    break;
		case "a2":
					    ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) DESC, MONTH(fecha) DESC, anotaciones ASC;");
					    ps.setDate(1, new java.sql.Date(f2.getTime()));
					    ps.setDate(2, new java.sql.Date(f1.getTime()));
					    break;
		case "a3":
					    ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ?  ORDER BY YEAR(fecha) ASC, MONTH(fecha) ASC, anotaciones DESC;");
					    ps.setDate(1, new java.sql.Date(f2.getTime()));
					    ps.setDate(2, new java.sql.Date(f1.getTime()));
					    break;
		case "a4":
					    ps = con.prepareStatement("SELECT ID_gasto, fecha, concepto, importe, saldo, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria, color, Id_sub, Id_catSub, anotaciones, nombre_tarjeta, mes_tarjeta, tipo_tarjeta FROM vista_gasto WHERE fecha BETWEEN ? AND ? ORDER BY YEAR(fecha) ASC, MONTH(fecha) ASC, anotaciones ASC;");
					    ps.setDate(1, new java.sql.Date(f2.getTime()));
					    ps.setDate(2, new java.sql.Date(f1.getTime()));
					    break;
					}}



		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	    
	    
	    rs = ps.executeQuery();
	    ArrayList<Gastos> result = new ArrayList<>();
	    while (rs.next()) {
	    	SimpleDateFormat formatear = new SimpleDateFormat("yyyy-MM-dd");
	    	String fechaTarjeta;
	    	
	        int idGasto = rs.getInt("ID_gasto");
	        Date fechaInicial = rs.getDate("fecha");	        
	        String fecha = formatear.format(fechaInicial);
	        String concepto = rs.getString("concepto");
	        int importe = rs.getInt("importe");
	        int saldo = rs.getInt("saldo");
	        String imagenCategoria = rs.getString("imagen_categoria");
	        String imagenSubcategoria = rs.getString("imagen_subcategoria");
	        String nombreCategoria = rs.getString("nombre_categoria");
	        String nombreSubcategoria = rs.getString("nombre_subcategoria");
	        String color = rs.getString("color");
	        String anotaciones = rs.getString("anotaciones");
	        String nombreTarjeta = rs.getString("nombre_tarjeta");
	        Date fechaTarjetaInicial = rs.getDate("mes_tarjeta");
	        int IdSub = rs.getInt("Id_sub");
	        int IdCatSub = rs.getInt("Id_catSub");
	        if (fechaTarjetaInicial != null) {
	        	  fechaTarjeta = formatear.format(fechaTarjetaInicial);
	        	} else {
	        	  fechaTarjeta = "0"; // Asigna el valor predeterminado, en este caso "0"
	        	}
	        int tipoTarjeta = rs.getInt("tipo_tarjeta");
	        
	        result.add(new Gastos(fecha, concepto, importe, saldo, anotaciones, fechaTarjeta, tipoTarjeta, idGasto, imagenCategoria, imagenSubcategoria, nombreCategoria, nombreSubcategoria, nombreTarjeta, color, IdSub, IdCatSub));
	    }
	    
	    return result;
	}	
	
	
	
	
	public String damejsonGastos() throws SQLException {
		String json = "";
		Gson son = new Gson();	
		
		json = son.toJson(this.listarCategoria());	
		System.out.println("json json " + json);
		return json;
	}
	
	
	
	public void insertGastos (Gastos a) throws SQLException {
	
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO gasto (fecha, concepto, importe, saldo, ID_categoria, ID_subcategoria, anotaciones, ID_Tarjeta, mes_Tarjeta, tipo_tarjeta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setDate(1, new java.sql.Date(a.getFecha().getTime()));
		ps.setString(2, a.getConcepto());
		ps.setInt(3, a.getImporte());
		ps.setInt(4, a.getSaldo());
		ps.setInt(5, a.getCategoria());
		ps.setInt(6, a.getSubcategoria());
		ps.setString(7, a.getAnotaciones());
		ps.setInt(8, a.getCreditoDebito());		
		ps.setDate(9, (a.getFechaTarjeta() != null) ? new java.sql.Date(a.getFechaTarjeta().getTime()) : null);
		ps.setInt(10, a.getTipoTarjeta());

		ps.executeUpdate();

		
		ps.close(); 
	}
	
	
	
	public void uptdateGastos (Gastos a) throws SQLException{
		
		String key = a.getKey();
		int id = a.getID();
		
		PreparedStatement ps = null;
		
		
	    switch (key) {
	    case "da":
	    	ps = con.prepareStatement("UPDATE gasto SET fecha = ? WHERE ID_gasto = ?;");
	    	
	    	ps.setDate(1, new java.sql.Date(a.getFecha().getTime()));
	    	ps.setInt(2, id);

	      break;

	    case "co":
	    	ps = con.prepareStatement("UPDATE gasto SET concepto = ? WHERE ID_gasto = ?;");
	    	ps.setString(1, a.getConcepto());
	      	ps.setInt(2, id);

	      break;

	    case "im":
	    	ps = con.prepareStatement("UPDATE gasto SET importe = ? WHERE ID_gasto = ?;");
	    	ps.setInt(1, a.getImporte());
	      	ps.setInt(2, id);

	      break;

	    case "sa":
	    	ps = con.prepareStatement("UPDATE gasto SET saldo = ? WHERE ID_gasto = ?;");
	    	ps.setInt(1, a.getSaldo());
	      	ps.setInt(2, id);

	      break;
	      
	    case "ca":
	    	ps = con.prepareStatement("UPDATE gasto SET ID_categoria = ?, ID_subcategoria = NULL WHERE ID_gasto = ?;");
	  
	    	ps.setInt(1, a.getCategoria());
	      	ps.setInt(2, id);

	      break;
	      
	    case "su":
	    	ps = con.prepareStatement("UPDATE gasto SET ID_subcategoria = ? WHERE ID_gasto = ?;");
	    	
	    	ps.setInt(1, a.getSubcategoria());
	      	ps.setInt(2, id);

	      break;
	      
	    case "an":
	    	ps = con.prepareStatement("UPDATE gasto SET anotaciones = ? WHERE ID_gasto = ?;");
	    	
	    	ps.setString(1, a.getAnotaciones());
	      	ps.setInt(2, id);
	      	
	      break;

	      
	      
	    default:
	      System.out.println("Nombre de key desconocido");
	      break;
	  }
    	ps.executeUpdate();			
		ps.close();
		
		
	}
	
	
	
	
	
	/*
	public ArrayList<DaoUsuariosImagenes> listar() throws SQLException {
	    PreparedStatement ps = con.prepareStatement("SELECT imagen FROM imagen WHERE tipo = 'login'");
	    ResultSet rs = ps.executeQuery();

	    ArrayList<DaoUsuariosImagenes> result = new ArrayList<>();

	    while (rs.next()) {
	        result.add(new DaoUsuariosImagenes(rs.getString("imagen")));
	    }

	    return result;
	}


	
	if (result == null) {
		result = ArrayList<>();
	}
	*/
}

