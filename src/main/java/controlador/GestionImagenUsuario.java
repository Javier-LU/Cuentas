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
 * Servlet implementation class prueba. Uso del doGet.
 * 
 * @author  Javier Luque Pardo
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
     * Procesa las solicitudes HTTP GET enviadas al servlet. Obtiene información de usuarios y categorías desde
     * la base de datos y genera una respuesta en formato JSON que contiene los datos obtenidos.
     *
     * @param request  La solicitud HTTP recibida.
     * @param response La respuesta HTTP que se enviará.
     * @throws ServletException Si ocurre un error durante el procesamiento del servlet.
     * @throws IOException      Si ocurre un error de E/S durante el procesamiento del servlet.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
			DaoUsuarios c = new DaoUsuarios();
			String respuestaC;
			String usuarios;
			respuestaC = c.damejson();
			usuarios = c.damejsonUsuarios();

			Gson gson = new Gson();

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
