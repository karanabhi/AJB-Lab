package Mappers;

import BankPOJO.Bank;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Abhishek Karan
 */
public class TransactionsMapper implements RowMapper<Bank> {

    @Override
    public Bank mapRow(ResultSet rs, int i) throws SQLException {

        Bank bank = new Bank();
        bank.setAmount(rs.getDouble(1));
        bank.setUsername(rs.getString(2));
        bank.setTimestamp(rs.getString(3));
        return bank;
    }//mapRow()

}//class
