package controlador;

import java.io.IOException;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.jsp.tagext.*;
import modelo.Imagenes;
import jakarta.servlet.descriptor.*;
import jakarta.servlet.ServletException;
 import java.io.IOException;  
 import java.text.*;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;

import dao.DaoUsuarios;

import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class prueba
 */
@WebServlet("/prueba")
public class prueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public prueba() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		try {
			DaoUsuarios c = new DaoUsuarios();
			String respuestaC;
			respuestaC = c.damejson();
			System.out.println(respuestaC);
			PrintWriter out = response.getWriter();
			    out.println(respuestaC);
			    out.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 
		
		
		/*
		try {
			DaoUsuarios c = new DaoUsuarios();
			ArrayList<Imagenes> lista = c.listar();
			for (Imagenes imagen : lista) {
				
			    System.out.println(imagen.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error de conexion a la bd");
			response.sendRedirect("/errores.html");
		}
		*/

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
