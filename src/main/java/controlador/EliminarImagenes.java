package controlador;

import modelo.*;

import java.io.BufferedReader;
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
 * Servlet implementation class EliminarImagenes
 */
@WebServlet("/EliminarImagenes")
@MultipartConfig
public class EliminarImagenes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EliminarImagenes() {
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
		  BufferedReader reader = request.getReader();
		    String dir = reader.readLine();
		    System.out.println("eliminar: " + dir);
		    
		    Imagenes img = new Imagenes(dir);
		    try {
				img.eliminarFisico();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				img.eliminarBaseDatos();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    
	}

}
