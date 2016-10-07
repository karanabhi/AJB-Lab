package DataAccess;

import com.mysql.jdbc.*;
import java.sql.DriverManager;
import java.sql.ResultSet;

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

    private Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return con;
    }//getConnection()

    private int checkUname(String uname) {
        con = getConnection();

        try {
            String query = "select uid from bank_user where uname=? ";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setString(1, uname);
            rs = pstmt.executeQuery();

            if (!rs.next()) {
                return 1;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return 0;
    }//checkUname()

    public int signUp(String name, String pass, String acc) {
        con = getConnection();
        int x = 0;
        try {

            if (checkAccNo(acc) == 0) {
                return -2;
            }
            if (checkUname(name) == 0) {
                return -1;
            }

            String query = "insert into bank_user(uname,upass,account_no) values(?,?,?)";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, pass);
            pstmt.setString(3, acc);
            x = pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return x;
    }//signUp()

    public int login(String name, String pass) {
        con = getConnection();
        int uid = 0;
        try {
            String query = "select uid from bank_user where uname=? and upass=? and status=?";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, pass);
            pstmt.setInt(3, 1);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                uid = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return uid;
    }//login()

    public ResultSet getRole(int uid) {
        con = getConnection();
        String role = null;
        try {
            String query = "select urole from user_master where uid=? ";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setInt(1, uid);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                role = rs.getString(1);
            }

            query = "select uname from user_master where urole=? ";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setString(1, role);
            rs = pstmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return rs;
    }//getRole()

    public int checkAccNo(String acc) {
        con = getConnection();

        try {
            String query = "select uid from bank_user where account_no=? ";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setString(1, acc);
            rs = pstmt.executeQuery();

            if (!rs.next()) {
                return 1;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return 0;
    }//checkUname()

    public ResultSet fetchData(int uid) {
        con = getConnection();

        try {
            String query = "select uname,account_no,balance from bank_user where uid=? ";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setInt(1, uid);
            rs = pstmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }//fetchData()

    public ResultSet fetchpayeeTrans(int payee) {
        con = getConnection();

        try {
            String query = "select bt.amount,bu.uname,bt.timestamp from bank_trans bt,bank_user bu "
                    + " where bt.payer=bu.uid and payee=? ";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setInt(1, payee);
            rs = pstmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }//fetchPayeeTrans()

    public ResultSet fetchpayerTrans(int payer) {
        con = getConnection();

        try {
            String query = "select bt.amount,bu.uname,bt.timestamp from bank_trans bt,bank_user bu "
                    + " where bt.payer=bu.uid and payer=? ";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setInt(1, payer);
            rs = pstmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }//fetchPayeeTrans()

    public int updateAmount(String acc, double amt, int uid) {
        con = getConnection();
        try {
            String query = "update bank_user set balance=balance+? where account_no=?";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setDouble(1, amt);
            pstmt.setString(2, acc);

            if (pstmt.executeUpdate() == 0) {
                return 0;
            } else {
                query = "update bank_user set balance=balance-? where uid=?";
                pstmt = (PreparedStatement) con.prepareStatement(query);
                pstmt.setDouble(1, amt);
                pstmt.setInt(2, uid);

                if (pstmt.executeUpdate() == 0) {
                    return 0;
                } else {
                    return 1;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return 0;
    }//updateAmt()

    public int updateBankTrans(int payee, String accno, double amt) {
        con = getConnection();
        try {

            String query = "select uid from bank_user where account_no=?";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setString(1, accno);

            rs = pstmt.executeQuery();
            rs.next();
            int payer = rs.getInt("uid");

            query = "insert into bank_trans(payee,payer,amount) values(?,?,?)";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setInt(1, payee);
            pstmt.setInt(2, payer);
            pstmt.setDouble(3, amt);

            if (pstmt.executeUpdate() == 0) {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return 1;
    }//updatetrans()

    public int updateAdmin(String acnt,char stat) {
        con = getConnection();
        try {
            String query = "update bank_user set status=? where account_no=?";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setString(2, acnt);
            if(stat=='G'){
            pstmt.setInt(1, 1);
            }else if(stat=='F'){
            pstmt.setInt(1, 0);
            }
                      
            if (pstmt.executeUpdate() == 0) {
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return 1;
    }

}//DataAccess

