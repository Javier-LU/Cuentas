package controlador;


import java.io.IOException;
import java.io.InputStream;

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
import java.util.UUID;
import java.io.File;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dao.DaoUsuarios;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.sql.SQLException;
/**
 * Servlet implementation class GestionImagenes
 */
@WebServlet("/GestionImagenes")
@MultipartConfig
public class GestionImagenes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String pathFiles ="D:\\Programacion\\Poryecto_1_Daw\\Proyecto\\Cuenta\\src\\main\\webapp\\Vista\\Photos\\Usuarios";
	private String pathBS = "Photos/Usuarios/"; 
	private File upload = new File(pathFiles);
    /**
     * Default constructor. 
     */
    public GestionImagenes() {
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

		String tipoImagen = request.getParameter("ima");
		
		
		Part part = request.getPart("photo");
		Path path = Paths.get(part.getSubmittedFileName());
		String fileName = path.getFileName().toString();	
		// Generar un nombre aleatorio para el archivo
		String randomName = UUID.randomUUID().toString();
		// Obtener la extensión del archivo original
		String extension = fileName.substring(fileName.lastIndexOf("."));
		// Crear el nuevo nombre de archivo con el nombre aleatorio y la extensión
		String newFileName = randomName + extension;
		
		InputStream input = part.getInputStream();
		
		File file = new File(upload, newFileName);
		 try {
		        Files.copy(input, file.toPath());
		    } catch (IOException e) {
		    	
		    	System.out.println("Error");
		    }
		 
			pathBS += newFileName;
			System.out.println(pathBS);
			System.out.println("tipooooo  " + tipoImagen);
			Imagenes img = new Imagenes(pathBS, tipoImagen );
			
			try {
				img.insertar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
		}
	}


