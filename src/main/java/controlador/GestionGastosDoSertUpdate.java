package controlador;

import modelo.*;
import dao.*;


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

import com.google.gson.Gson;
import com.google.gson.JsonObject;



import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class GestionGastosDoSertUpdate
 */
@WebServlet("/GestionGastosDoSertUpdate")
@MultipartConfig
public class GestionGastosDoSertUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GestionGastosDoSertUpdate() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gastos g = new Gastos();
		
		SimpleDateFormat dateFormato = new SimpleDateFormat("yyyy-MM-dd");
	 	Date fecha = null;
	 	String auxString1 = "";
	 	String auxString2 = "";
	 	int aux = 0;
	 
	 	
		Part partDato = request.getPart("dateUpdate");
	    Part partId = request.getPart("id");
	    Part partKey = request.getPart("llave");
	    

	    
	    String key = request.getParameter("llave");
	    
	    
	    auxString1 = request.getParameter("id");
	    auxString2 = auxString1.substring(2);
	    auxString1 = auxString2.trim();

	    int id = Integer.parseInt(auxString1);
	    System.out.println("----------------------------------------------------------");
	    System.out.println("----------------------------------------------------------");
	    System.out.println(id);
	    System.out.println("----------------------------------------------------------");
	    System.out.println("----------------------------------------------------------");
	    
	    
	    String dato = request.getParameter("dateUpdate");
	    
	    g.setKey(key);
	    g.setID(id);
	    
	    
	    
	    switch (key) {
	    case "da":
	    	  try {
	  	        fecha = dateFormato.parse(dato);	        
	  	    } catch (ParseException e) {
	  	        e.printStackTrace();
	  	    }
	      g.setFecha(fecha);
	      break;

	    case "co":
	    	g.setConcepto(dato);
	   
	      break;

	    case "im":

	      aux = Integer.parseInt(dato);
	      g.setImporte(aux);
	      break;

	    case "sa":
	    	  aux = Integer.parseInt(dato);
		      g.setSaldo(aux);
	      break;
	      
	    case "ca":
	    	
	    	  aux = Integer.parseInt(dato);
		      g.setCategoria(aux);
	      break;
	      
	    case "su":
		    auxString2 = dato.substring(2);
		    auxString1 = auxString2.trim();
	    	  aux = Integer.parseInt(auxString1);
		      g.setSubcategoria(aux);
	      break;
	      
	    case "an":
	    	g.setAnotaciones(dato);
	      break;

	    default:
	      System.out.println("Nombre de input desconocido");
	      break;
	  }
	    	
	    try {
			g.update();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
}
}
