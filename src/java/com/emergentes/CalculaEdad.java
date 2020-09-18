
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jorge
 */
@WebServlet(name = "CalculaEdad", urlPatterns = {"/CalculaEdad"})
public class CalculaEdad extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalculaEdad</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Calcula Edad</h1>");
            out.println("<form action='' method='post'>");
            out.println("<input type='submit' value='Regresar Menu' name='ok'>");
            out.println("</from>");
            out.println("<h2>Ingrese ?fecha=año de nacimiento</h2>");
            int fecha=Integer.parseInt(request.getParameter("fecha")); 
            if (fecha!=0) {
                out.println("Su edad es: <strong> "+(2020-fecha)+"</strong> años<br>");
            }else{
                out.println("Ingrese edad en la url");
            }
            
            
            out.println("</body>");
            out.println("</html>");
        } finally{
            out.close();
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("ok") != null){
            response.sendRedirect("index.jsp");
        }else{
        } 
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
