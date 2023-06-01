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
 * Servlet implementation class GestionGastosDoSet
 */
@WebServlet("/GestionGastosDoSetOrderBy")
@MultipartConfig
public class GestionGastosDoSetOrderBy extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GestionGastosDoSetOrderBy() {
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
		 	Date fecha1 = null;
		 	Date fecha2 = null;
		 	
			Part partF1 = request.getPart("fecha1");
		    Part partF2 = request.getPart("fecha2");
		    Part partKey = request.getPart("nose");
		    

		    
		    String f1 = request.getParameter("fecha1");	
		    System.out.println("Part1 fecha1: " + f1);
		    try {
		        fecha1 = dateFormato.parse(f1);	        
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		    String f2 = request.getParameter("fecha2");
		    System.out.println("Part1 fecha2 " + f2);
		    try {
		        fecha2 = dateFormato.parse(f2);	        
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		    String key = request.getParameter("nose");

		    System.out.println("Part1 key " + key);
		    
		    
		    g.setFecha1(fecha1);
		    g.setFecha2(fecha2);
		    g.setKey(key);
		    
		    
		    
		    
	}
}
