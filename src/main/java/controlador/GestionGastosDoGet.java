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
 * Servlet implementation class GestionGastosDoGet
 * 
 * @author  Javier Luque Pardo
 * 
 */
@WebServlet("/GestionGastosDoGet")
public class GestionGastosDoGet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GestionGastosDoGet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Procesa las solicitudes HTTP GET enviadas al servlet. Obtiene los datos necesarios de las diferentes tablas de la base de datos
     * y los envía al cliente en formato JSON.
     *
     * @param request  			La solicitud HTTP recibida.
     * @param response 			La respuesta HTTP que se enviará.
     * @throws ServletException Si ocurre un error durante el procesamiento del servlet.
     * @throws IOException      Si ocurre un error de E/S durante el procesamiento del servlet.
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DaoGastos g = new DaoGastos();
			String gas = g.damejsonGastos();

	        DaoCategorias c = new DaoCategorias();
	        String cat = c.damejsonCategoria();

	        DaoCategoriasSub s = new DaoCategoriasSub();
	        String sub = s.damejsonSubcategoria();

	        DaoRestricciones r = new DaoRestricciones();
	        String res = r.damejsonRestriccion();

	        DaoTarjeta t = new DaoTarjeta();
	        String tar = t.damejsonTarjeta();

	        Gson gson = new Gson();

	        // Crear un JsonObject y agregar propiedades
	        JsonObject respuesta = new JsonObject();

	        respuesta.addProperty("gas", gas);
	        respuesta.addProperty("cat", cat);
	        respuesta.addProperty("sub", sub);
	        respuesta.addProperty("res", res);
	        respuesta.addProperty("tar", tar);
	        

	        String respuestaJSON = gson.toJson(respuesta);

	        PrintWriter out = response.getWriter();
	        out.println(respuestaJSON);
	        
	        out.close();
	    } catch (SQLException e) {
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
