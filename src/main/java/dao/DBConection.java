package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * La clase DBConection proporciona métodos para establecer una conexión con la base de datos.
 * @author  Javier Luque Pardo
 */
public class DBConection {
	
	/**
	 * La instancia de conexión a la base de datos.
	 */
	public static Connection instance = null;
	
	/**
	 * La URL JDBC para la conexión a la base de datos.
	 */
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cuentas";
	
	/**
	 * Obtiene una conexión a la base de datos.
	 *
	 * @return La conexión a la base de datos.
	 * @throws SQLException Si ocurre un error al establecer la conexión.
	 */
	public static Connection getConnection() throws SQLException {
		
		if(instance == null) {
			Properties props = new Properties();
			props.put("user", "root");
			props.put("password", "");
			
			instance = DriverManager.getConnection(JDBC_URL, props);
		}
		
		return instance;
	}
}