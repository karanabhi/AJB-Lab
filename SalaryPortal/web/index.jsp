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

       <!-- <table align="center" border="true">
            <tr>
                <th>List of Departments</th>
            </tr>
            <tr>
            <form action="\SalaryPoral\details" method="post">-->
                <%
                    DataAccess da = new DataAccess();
                    ResultSet rs = da.getDepartmentDetails();
                    try {
                        while (rs.next()) {
                %>
                <%= rs.getString(1)%>
                <%
                        }//while
                    } catch (Exception e) {
                        e.getMessage();
                    }
                %>            

<!--

            </form>           
        </tr>
-->
    </table>
</body>
</html>
