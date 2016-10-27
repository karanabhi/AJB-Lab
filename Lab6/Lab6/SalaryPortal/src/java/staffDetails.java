
import DataAccess.DataAccess;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
public class staffDetails extends HttpServlet {

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
            out.println("<h1 align='center'>Staff Salary Details</h1>");
            out.println("<table align='center' border=true>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Staff Designation");
            out.println("</th>");
            out.println("<th>");
            out.println("Salary");
            out.println("</th>");
            out.println("</tr>");

            DataAccess da = new DataAccess();
            ResultSet rs = da.getStaffDetails(request.getParameter("depts"));

            try {
                while (rs.next()) {

                    out.println("<tr>");
                    out.println("<td>");
                    out.println(rs.getString(1));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(rs.getInt(2));
                    out.println("</td>");
                    out.println("</tr>");
                }//while

            } catch (Exception e) {
                e.getMessage();
            }//try-catch

            out.println("</table>");
            out.println("<a href='/SalaryPortal/index.jsp'>Go Back</a> </body>");
            out.println("</html>");

        }//pw try
    }

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
