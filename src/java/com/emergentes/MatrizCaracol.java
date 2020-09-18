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
@WebServlet(name = "MatrizCaracol", urlPatterns = {"/MatrizCaracol"})
public class MatrizCaracol extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MatrizCaracol</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Matris Caracol</h1>"
                    + "<h2>Ingrese Tamaño de la matriz: </h2>"
                    + "<form action='' method='post'>"
                    + "<input size='10px' type='text' name='num'>"
                    + "<input type='submit' value='Procesar' name='Procesar'>"
                    + "</form>");

            out.println("</body>");
            out.println("</html>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int fil = Integer.parseInt(request.getParameter("num"));

        int col = Integer.parseInt(request.getParameter("num"));

        int matrizAux = 1;

        int[][] matrizc = new int[fil + 1][col + 1];

        for (int pos = 1; pos <= fil / 2; pos++) {
            for (int i = pos; i <= col - pos; i++) {
                matrizc[pos][i] = matrizAux;
                matrizAux++;
            }
            for (int i = pos; i <= col - pos; i++) {
                matrizc[i][col - pos + 1] = matrizAux;
                matrizAux++;
            }
            for (int i = col - pos + 1; i >= pos + 1; i--) {
                matrizc[col - pos + 1][i] = matrizAux;
                matrizAux++;
            }
            for (int i = col - pos + 1; i >= pos + 1; i--) {
                matrizc[i][pos] = matrizAux;
                matrizAux++;
            }
        }

        if (col % 2 == 1) {
            matrizc[col / 2 + 1][col / 2 + 1] = matrizAux;

        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MatrizCaracol</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 >MATRIZ CARACOL N=" + fil + "</h1><br>");
            out.println("<style type='text/css'>");
            out.println("table, tr,th{border: 2px solid black;border-collapse: collapse;margin: 0 auto;}");
            out.println("th{width: 40px;}");
            out.println("h1{text-align: center;}");
            
            out.println("</style>");

            out.println("<table>");
            for (int i = 1; i <= fil; i++) {
                out.println("<tr>");
                for (int j = 1; j <= col; j++) {
                    
                    out.println("<th>"+matrizc[i][j]+"</th>");
                    
                }
                out.println("</tr>");
            }
   
            out.println("</table>");
            out.println("</html>");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
