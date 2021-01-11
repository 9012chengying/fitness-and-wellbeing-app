package uk.ac.cf.nsa.web.phyt.model;


import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.DTO.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserDTO(
                rs.getInt("userID"),
                rs.getString("username"),
                rs.getString("password"));
    }
}
