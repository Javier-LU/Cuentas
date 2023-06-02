package controlador;

import modelo.*;
import dao.*;

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
 * Servlet implementation class UpdateCategorias. Uso del doPost
 * 
 * @author  Javier Luque Pardo
 * 
 */
@WebServlet("/UpdateCategorias")
@MultipartConfig
public class UpdateCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UpdateCategorias() {
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
	 * Este método se invoca cuando se realiza una solicitud HTTP POST al servlet. 
	 * Recibe los datos enviados en la solicitud y realiza acciones basadas en esos datos.
	 * 
	 * @param idCatSubstring 		Substring de la cadena "idCat".
	 * @param idCatInt 				Entero obtenido a partir de "idCatSubstring".
	 * @param idImgCatSubstring 	Substring de la cadena "idImg".
	 * @param idImgInt 				Entero obtenido a partir de "idImgCatSubstring".
	 * @param idCatSinLetraINT 		Entero obtenido a partir de "idCatSinLetra".
	 * @param primeraLetra 			Primera letra de "idCat".
	 * @param primeraLetraColor 	Primera letra de "idColor".
	 * 
	 * @param request  la solicitud HTTP recibida.
	 * @param response la respuesta HTTP que se enviará al cliente.
	 * @throws ServletException si ocurre un error en el servlet.
	 * @throws IOException      si ocurre un error de entrada/salida.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		 String idCatSubstring;
	     int idCatInt = 0;
	     String idImgCatSubstring;
	     int idImgInt = 0;
	     int idCatSinLetraINT = 0;
	     char primeraLetra = 0;
	     String primeraLetraColor = "";
	     
	     // Obtener los datos de los parámetros enviados en la solicitud	
	    String idCat = request.getParameter("idCat");
	    String idImg = request.getParameter("idImg");
	    String idNombre = request.getParameter("idNombre");
	    String idColor = request.getParameter("idcolor");
	    String idCatSinLetra = request.getParameter("idCatSinLetra");
	    
	    // Realiza acciones con los datos rescatados	   
		    if (idCat.length() > 2) {
		    	// El idcat viene en formato "C_34". Necesito el número y la primera letra. 
		        idCatSubstring = idCat.substring(2);
		        idCatInt = Integer.parseInt(idCatSubstring);
		         primeraLetra = idCat.charAt(0);		   
		    }  
		    if (idImg.length() > 2) {
		    	// El idImg viene en un formato parecido. Necesito el número. 
		        idImgCatSubstring = idImg.substring(2);
		        idImg = idImgCatSubstring.replaceAll("'", "");
			    idImgInt = Integer.parseInt(idImg);		    
		    }
		    if ( !idCatSinLetra.isEmpty() && idCatSinLetra.length() >= 1)  {
		    	
		    	idCatSinLetraINT =  Integer.parseInt(idCatSinLetra);  
		    }
		    if (!idColor.isEmpty() && idColor.length() > 2) {
		    	// En caso de ser enviado un color, necesito la primera letra, la # para poder ejecutar la función.
		    	primeraLetraColor = idColor.substring(0, 1);
		    	 System.out.println("primeraLetraColor: " + primeraLetraColor);
		    } 
		    
		  //Dependiendo de la primeraLetra construira un objeto Categorías u otro.   
	    if (primeraLetra == 'C') {

	    Categorias categorias = new Categorias( idCatInt,  idNombre, idImgInt, idColor );
	   
	    try {
			categorias.update();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }else if (primeraLetra == 'S'){
		   CategoriaSub categoriaSub = new CategoriaSub( idCatInt, idCatSinLetraINT,  idNombre, idImgInt );
		   
		   try {
			categoriaSub.update();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	   }else if (primeraLetraColor.equals("#")){

		   Categorias categorias = new Categorias( idCatInt,  idNombre, idImgInt, idColor );
		   try {
			   categorias.update();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
		}else {

		   CategoriaSub categoriaSub = new CategoriaSub( idCatInt, idCatSinLetraINT,  idNombre, idImgInt );
		   System.out.println(idCatSinLetra);
		   System.out.println(idCatSinLetraINT);
		   System.out.println(categoriaSub.toString());
		   try {
				categoriaSub.update();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	}

}
