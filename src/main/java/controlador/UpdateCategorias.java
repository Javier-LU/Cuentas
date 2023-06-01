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
 * Servlet implementation class UpdateCategorias
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
	     
		
		
		Part partCat = request.getPart("idCat");
	    Part partImg = request.getPart("idImg");
	    Part partNombre = request.getPart("idNombre");
	    Part partColor = request.getPart("idcolor");
	    Part partidCatSinLetra = request.getPart("idCatSinLetra");
	    
	    
	    String idCat = request.getParameter("idCat");
	    String idImg = request.getParameter("idImg");
	    String idNombre = request.getParameter("idNombre");
	    String idColor = request.getParameter("idcolor");
	    String idCatSinLetra = request.getParameter("idCatSinLetra");
	    
	    
	    System.out.println("╔════════════════════════════════╗");
	    System.out.println("║        Título Bonito            ║");
	    System.out.println("╚════════════════════════════════╝");
	    
	    System.out.println("Valor de idCat: " + idCat);
	    System.out.println("Valor de idImg: " + idImg);
	    System.out.println("Valor de idNombre: " + idNombre);
	    System.out.println("Valor de idColor: " + idColor);
	    System.out.println("Valor de idCatSinLetra: " + idCatSinLetra);
	    System.out.println("╔════════════════════════════════╗");
	    System.out.println("║        Título Bonito            ║");
	    System.out.println("╚════════════════════════════════╝");
	    
	    
	    // Realiza acciones con los datos rescatados
	    
	    
	    

	   
		    if (idCat.length() > 2) {
		    	 System.out.println("idCat: " + idCat);
		        idCatSubstring = idCat.substring(2);
		        idCatInt = Integer.parseInt(idCatSubstring);
		         primeraLetra = idCat.charAt(0);
		        // Resto del código
		    }
		    
		   
		    if (idImg.length() > 2) {
		    	 System.out.println("idImg: " + idImg);
		        idImgCatSubstring = idImg.substring(2);
		        idImg = idImgCatSubstring.replaceAll("'", "");
			    idImgInt = Integer.parseInt(idImg);
		        // Resto del código
		    }
		    
		    if ( !idCatSinLetra.isEmpty() && idCatSinLetra.length() >= 1)  {
		    	System.out.println("idCatSinLetra: " + idCatSinLetra);
		    	idCatSinLetraINT =  Integer.parseInt(idCatSinLetra);  
		    }
		    
		   
		    if (!idColor.isEmpty() && idColor.length() > 2) {
		    	 System.out.println("idColor: " + idColor);
		    	primeraLetraColor = idColor.substring(0, 1);
		    	 System.out.println("primeraLetraColor: " + primeraLetraColor);
		    } 
		    
		    
		
	   
	    
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
		   System.out.println("siiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii: ");
		   Categorias categorias = new Categorias( idCatInt,  idNombre, idImgInt, idColor );
		   try {
			   categorias.update();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
		}else {
			System.out.println("nOOOOOOOOOOOOOOOOOOOOOOOOOOOOO: ");
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
	 
	    CategoriaSub categoriaSub = new CategoriaSub();
	    
	    System.out.println("idCat: " + idCat);
	    System.out.println("idImg: " + idImg);
	    System.out.println("idNombre: " + idNombre);
	    System.out.println("idColor: " + idColor);
	    System.out.println("idCatSinLetra: " + idCatSinLetra);
	    System.out.println("--------------------------------------------------- " );
	   
	    
	}

}
