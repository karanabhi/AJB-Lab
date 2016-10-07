package DataAccess;

import BankPOJO.Bank;
import Mappers.LoginMapper;
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
    
    public Bank login(String uname, String pass) {
        
        query = "select uid from bank_user where uname=? and upass=? and status=?";
        bank = jdbcTemplateObject.queryForObject(query, new Object[]{uname, pass, 1}, new LoginMapper());
        if (bank.equals(null)) {
            bank.setUid(0);
        }
        return bank;
        
    }//login()

}//DataAccessTemplate
