
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jorge
 */
@WebServlet(name = "Dados", urlPatterns = {"/Dados"})
public class Dados extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Random aleatorio=new Random();
        int num1=aleatorio.nextInt(6)+1;
        int num2=aleatorio.nextInt(6)+1;
        int res=num1+num2;
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Dados</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>JUEGOS DE DADOS</h1>"
                    
                    + "<h2>Sus Numeros son : "+num1+" y "+num2+" Sumados son "+res+"</h2><br>"
                    + "<form action='' method='post'>"
                    + "<input type='submit' value='Volver a Intentar' name='ok'>"
                    
                    + "</form>");
            if(res==7||res==11){
                out.println("<h2 style='color:green'>USTED GANA</h2>");
            }else{
                out.println("<h2 style='color:red'>USTED PIERDE</h2>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        
        if(request.getParameter("ok") != null){
            response.sendRedirect("Dados");
            
            
        }else{
        }    
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
