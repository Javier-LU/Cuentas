package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Gastos;

public class DaoGastos {

	
	private Connection con = null;

	public DaoGastos() throws SQLException {
		con = DBConection.getConnection();
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
		
		
		//int filas = ps.executeUpdate();
		
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

