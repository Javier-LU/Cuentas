package controlador;
import modelo.*;



import java.io.IOException;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.jsp.tagext.*;
import jakarta.servlet.descriptor.*;
import jakarta.servlet.ServletException;
 import java.io.IOException;  
 import java.text.*;
 import java.util.Date;
 import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class gestionGastos
 * 
  * @author  Javier Luque Pardo
 * 
 */
@WebServlet("/gestionGastos")
public class GestionGastos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    /**
     * Default constructor. 
     */
    public GestionGastos() {
        // TODO Auto-generated constructor stub
    }
    
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 
	 * Método para recibir y procesar los datos enviados en una solicitud (request).
	 * Construye un objeto 'Gastos' según los datos recibidos y realiza la inserción en la base de datos.
	 * 	
	 * @param request  			La solicitud HTTP recibida.
     * @param response 			La respuesta HTTP que se enviará.
     * @throws ServletException Si ocurre un error durante el procesamiento del servlet.
     * @throws IOException      Si ocurre un error de E/S durante el procesamiento del servlet.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    // Recepción de datos de fecha y conversón de String a Date
	    String fechaRQT = request.getParameter("date");
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date fecha = null;
	    try {
	        fecha = dateFormat.parse(fechaRQT);	        
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    
	    // Recepción de de los datos concepto e importe
	    String concepto = request.getParameter("concepto");	  
	    int importe = Integer.parseInt(request.getParameter("importe"));	
	    
	    // Recepción de de los datos saldo. Como saldo puede tener valor nulo, pregunto si tiene información.
	    String saldoStr = request.getParameter("saldo");
	    int saldo = 0;
	    if (saldoStr != null && !saldoStr.isEmpty()) {
	        try {
	            saldo = Integer.parseInt(saldoStr);
	        } catch (NumberFormatException e) {
	            e.printStackTrace();
	        }
	    }

	    // Recepción de de los datos categoría y subcategoría
	    int categoria = Integer.parseInt(request.getParameter("categoria"));	    
	    int subcategoria = Integer.parseInt(request.getParameter("subcategoria"));	
	    
	    // Recepción de de los datos anotaciones. La mayoria de las veces estará vacio y solo esta, declaro anotaciones como nulo. 
	    String anotaciones = request.getParameter("anotaciones");
	    if (anotaciones == null || anotaciones.trim().isEmpty()) {
	        anotaciones = null;
	    }	    
	    
	    //Recepción de los datos de creditoDebito que define si es una tarjeta de credito o de debito. 
	    int creditoDebito = Integer.parseInt(request.getParameter("credito_Debito"));	  

	    // Si es de un tipo o de otro, se deben de mandar información diferente a la base de datos. 
	    int tipoTarjeta = 0;
	    Date fechaTarjeta = null;
	    if (creditoDebito > 2) {	        
	        String fechaT = request.getParameter("fecha_tarjeta");
	        try {
	            fechaTarjeta = dateFormat.parse(fechaT);	            
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

	        tipoTarjeta = Integer.parseInt(request.getParameter("tipo_tarjeta"));
	    }

	    // Creación del objeto Gastos con los datos recibidos
	    Gastos nuevoGasto = new Gastos(fecha, concepto, importe, saldo, categoria, subcategoria, anotaciones, creditoDebito, fechaTarjeta, tipoTarjeta);

	    try {
	        nuevoGasto.insertar(); // Insertar en la base de datos
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	

}
