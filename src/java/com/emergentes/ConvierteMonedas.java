
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jorge
 */
@WebServlet(name = "ConvierteMonedas", urlPatterns = {"/ConvierteMonedas"})
public class ConvierteMonedas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConvierteMonedas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>CONVETIDOR DE MONEDA</h1>");
            out.println("<br>");
            out.println("<form action='' method='post'>");
            
           
            out.println("Ingrese cantidad <br>");
            out.println("En <strong>Bolivianos</strong> o <strong>Dolares :</strong> ");
            out.println("<input size='10px' type='text' name='moneda'> ");
            out.println("<br>");          
            out.println("<br>"); 
            out.println("<input type='submit' value='Convertir a Dolares' name='dolares'");
            out.println("<br>");
            out.println("<input type='submit' value='Convertir a Bolivianos' name='bolivianos'");
            out.println("<br>");
            
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        double resultado=0;
        String tipomoneda="";
        DecimalFormat df = new DecimalFormat("#.00");
        
        if (request.getParameter("dolares") != null&&request.getParameter("bolivianos")==null) {
            double moneda= Double.parseDouble(request.getParameter("moneda"));
            resultado=moneda/6.89;
            tipomoneda="dolares";
        }
        if (request.getParameter("dolares") == null&&request.getParameter("bolivianos")!=null) {
            double moneda= Double.parseDouble(request.getParameter("moneda"));
            resultado=moneda*6.89;
            tipomoneda="bolivianos";
        }
        
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculadora de monedas</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>El Resulado es: "+df.format(resultado)+ " "+tipomoneda+"</h1>");
               
              
            
            out.println("</body>");
            out.println("</html>");
        }
        
            
        
        
        
    }

    

}
