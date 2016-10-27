<%-- 
    Document   : index
    Created on : Sep 30, 2016, 3:35:25 PM
    Author     : Abhishek Karan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DataAccess.*,java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">Salary Portal</h1>

        <table align="center">
            <tr>
                <th colspan="5">List of Departments</th>
            </tr>            
            <form action="/SalaryPortal/details" method="post">
                <td>
                    <select name="depts">
                        <%
                            DataAccess da = new DataAccess();
                            ResultSet rs = da.getDepartmentDetails();
                            try {
                                while (rs.next()) {
                        %>
                        <option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option>
                        <%
                                }//while
                            } catch (Exception e) {
                                e.getMessage();
                            }
                        %>  
                    </select>                    
                </td>
                <td><input type="submit" value="Show"></td>
            </form>           
        </tr>       
    </table>
</body>
</html>
