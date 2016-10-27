package DataAccess;

import BankPOJO.Bank;
import Mappers.LoginMapper;
import com.mysql.jdbc.PreparedStatement;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Abhishek Karan
 */
public class DataAccessTemplate {

    private JdbcTemplate jdbcTemplateObject;
    Bank bank = null;
    String query = "";

    public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
        this.jdbcTemplateObject = jdbcTemplateObject;
    }

    public List<Bank> login(Bank banks) {

        query = "select uid from bank_user where uname=? and upass=? and status=? ";
        return jdbcTemplateObject.query(query, new Object[]{banks.getUsername(), banks.getPassword(), 1}, new LoginMapper());

    }//login()

    public int signUp(Bank banks) {

        if (!checkAccNo(banks).isEmpty()) {
            return -2;
        }
        if (!checkUname(banks).isEmpty()) {
            return -1;
        }

        query = "insert into bank_user(uname,upass,account_no) values(?,?,?)";
        return jdbcTemplateObject.update(query, new Object[]{banks.getUsername(), banks.getPassword(), banks.getAccount_number()});

    }//signup()

    private List<Bank> checkAccNo(Bank bank) {

        query = "select uid from bank_user where account_no=? ";
        return jdbcTemplateObject.query(query, new Object[]{bank.getAccount_number()}, new LoginMapper());

    }//checkAccno()

    private List<Bank> checkUname(Bank bank) {

        query = "select uid from bank_user where uname=? ";
        return jdbcTemplateObject.query(query, new Object[]{bank.getUsername()}, new LoginMapper());

    }//checkUname()

    public int updateAdmin(Bank bank, char stat) {

        query = "update bank_user set status=? where account_no=?";
        if (stat == 'G') {
            return jdbcTemplateObject.update(query, new Object[]{1, bank.getAccount_number()});
        } else if (stat == 'F') {
            return jdbcTemplateObject.update(query, new Object[]{0, bank.getAccount_number()});
        }
        return 0;
    }//UpdateAdmin()

}//DataAccessTemplate
