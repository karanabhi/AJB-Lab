package Mappers;

import BankPOJO.Bank;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Abhishek Karan
 */
public class LoginMapper implements RowMapper<Bank> {

    @Override
    public Bank mapRow(ResultSet rs, int i) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet.");
        Bank bank = new Bank();
        bank.setUid(rs.getInt(1));
        return bank;
    }

}//bankMapper
