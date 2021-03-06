package uk.ac.cf.nsa.web.phyt.users.data.mapper;


import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserDTO(
                rs.getInt("id"),
                rs.getString("user_name"),
                rs.getString("user_password"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getString("user_role")
        );
    }
}
