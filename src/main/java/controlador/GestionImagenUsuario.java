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
import com.google.gson.JsonObject;
import dao.DaoUsuarios;

import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class prueba
 */
@WebServlet("/gestionImagenUsuario")
public class GestionImagenUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public GestionImagenUsuario() {
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
			String usuarios;
			respuestaC = c.damejson();
			usuarios = c.damejsonUsuarios();
			//System.out.println(respuestaC);
			//System.out.println(usuarios);
			
			
			    //out.println(respuestaC);
			    //out.close();
			Gson gson = new Gson();

			// Crear un JsonObject y agregar propiedades
			JsonObject respuesta = new JsonObject();
			respuesta.addProperty("respuestaC", respuestaC);
			respuesta.addProperty("usuarios", usuarios);
			
			String respuestaJSON = gson.toJson(respuesta);
			
			PrintWriter out = response.getWriter();
			out.println(respuestaJSON);
			 
			 System.out.println(respuestaJSON);
			 
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
