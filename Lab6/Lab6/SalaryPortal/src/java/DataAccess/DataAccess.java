package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

/**
 *
 * @author Abhishek Karan
 */
public class DataAccess {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/abhi";
    static final String USER = "root";
    static final String PASS = "student";
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;

    private Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return con;
    }//getConnection()

    public ResultSet getDepartmentDetails() {
        con = getConnection();
        try {
            String query = "select dname from department_master";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            e.getMessage();
        }
        return rs;
    }//getStaffDetails()

    public ResultSet getStaffDetails(String dname) {
        con = getConnection();
        try {
            String query = "select s.sname,s.salary from staff s,department_master dm where dm._id=s.did and dm.dname=?";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setString(1, dname);
            rs = pstmt.executeQuery();
        } catch (Exception e) {
            e.getMessage();
        }
        return rs;
    }//getStaffDetails()
}
