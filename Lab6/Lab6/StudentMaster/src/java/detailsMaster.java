/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DataAccess.*;
import java.sql.ResultSet;

/**
 *
 * @author Abhishek Karan
 */
public class detailsMaster extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align='center'>Student Details</h1>");
            out.println("<table align='center' border=true>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Student Name");
            out.println("</th>");
            out.println("<th>");
            out.println("Student Age");
            out.println("</th>");
            out.println("<th>");
            out.println("Student CGPA");
            out.println("</th>");
            out.println("<th>");
            out.println("Student Branch");
            out.println("</th>");
            out.println("</tr>");

            DataAccess da = new DataAccess();
            ResultSet rs = da.getDetails();
            try {

                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(rs.getString(1));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(rs.getInt(2));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(rs.getInt(3));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(rs.getString(4));
                    out.println("</td>");
                    out.println("</tr>");
                }//while
            } catch (Exception e) {
                e.getMessage();
            }//try-catch

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

        }//pw try
    }//processRequest

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
