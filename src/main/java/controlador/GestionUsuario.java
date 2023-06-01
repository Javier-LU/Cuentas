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
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/GestionUsuario")
public class GestionUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GestionUsuario() {
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
		 
		String nombre = request.getParameter("username");
		String img = request.getParameter("imgform");
		String pass = request.getParameter("password"); 
		
		Usuario us = new Usuario(nombre, pass, img);
		System.out.println(us.toString());
		
		try {
			us.insertar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	}

}
