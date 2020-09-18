
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jorge
 */
@WebServlet(name = "Calculadora", urlPatterns = {"/Calculadora"})
public class Calculadora extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Calculadora</title>"
                    + "</head>"
                    + "<body>"
                    + "<h1>CALCULADORA</h1>"
                    
                    + "<form action='' method='post'>"
                 
                   
                    + "Ingrese cantidad: <br>"
                    + "<input size='10px' type='text' name='num1'>"
                    + "<select name='operacion'>"
                    + "<option >SUMAR</option>"
                    + "<option >RESTAR</option>"
                    + "<option >MULTIPLICAR</option>"
                    + "<option >DIVIDIR</option>"
                    + "</select>"
                    + "<input size='10px' type='text' name='num2'>"
                    + "<input type='submit' value='procesar' name='ok'>"
                    + "</form>");            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        long numb1=0,numb2=0,res=0;
        String operacion="";
        char op;
        operacion=request.getParameter("operacion");
        numb1=Long.parseLong(request.getParameter("num1"));
        numb2=Long.parseLong(request.getParameter("num2"));
        op=operacion.charAt(0);
        
        switch(op){
            case 'S':{
                res=numb1+numb2;
                break;
            }
            case 'R':{
                res=numb1-numb2;
                break;
            }
            case 'M':{
                res=numb1*numb2;
                break;
            }
            case 'D':{
                res=numb1/numb2;
                break;
            }
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
            
            out.println("<h1>EL RESULTADO ES: "+res+"</h1>");
               
              
            
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
