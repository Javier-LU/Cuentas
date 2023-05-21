package controlador;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AAALmacen {

	
	 PrintWriter out = response.getWriter();
	 
	    out.println("<html>");
	      out.println("<head></head>");         
	      out.println("<body>");
	 
   out.println("<br>");
   out.println("Clave:");  
   out.println(nuevoGasto.toString());  


	     out.println("</body>");
    out.println("</html>");  
	
		
		out.close();
	
	
	
	//monstar en pantalla
	  PrintWriter out = response.getWriter();
      

      out.println("<html>");
      out.println("<head></head>");         
      out.println("<body>");
      
      
      // Recojo la fecha
      String fechaRQT = request.getParameter("date");			
		SimpleDateFormat backDate = new SimpleDateFormat("yyyy-MM-dd");		
		try {
			Date fechaformat = backDate.parse(fechaRQT);
			out.println(fechaformat);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   out.println("<br>");
	        out.println("<br>");
	        
      
		// Recojo el concepto                                
      String concepto = request.getParameter("concepto");
      out.println(concepto);
      
      out.println("<br>");
      out.println("<br>");
      
      
		int importe = Integer.parseInt(request.getParameter("importe"));
		 out.println(importe);
		   out.println("<br>");
	        out.println("<br>");
	        
		int saldo = Integer.parseInt(request.getParameter("saldo"));
		 out.println(saldo);
		    out.println("<br>");
		    
		    String categoria = request.getParameter("categoria");
		    String subcategoria = request.getParameter("subcategoria");
		    String creditoDebito = request.getParameter("credito_Debito");
		    String fechaFarjeta = request.getParameter("fecha_tarjeta");
		 
		 out.println("Categoria: " + categoria);
		 out.println("<br>");
		 out.println("Subcategoria: " + subcategoria);
		 out.println("<br>");
		 out.println("Crédito/Debito: " + creditoDebito);
		 out.println("<br>");
		 out.println("Fecha Tarjeta: " + fechaFarjeta);
      
      out.println("<br>");
      out.println("<br>");

      
  
      
      
      
      
      out.println("<br>");
      out.println("<br>");
      out.println("Usuariossssssssssssss:");

      out.println("<br>");
      out.println("Clave:");    


	     out.println("</body>");
       out.println("</html>");  
	
		
		out.close();
	
	
}
