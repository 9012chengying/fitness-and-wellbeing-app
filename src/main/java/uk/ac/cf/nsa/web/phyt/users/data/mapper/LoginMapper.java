package uk.ac.cf.nsa.web.phyt.users.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserDTO(
                rs.getInt("userID"),
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getString("role"),
                rs.getString("username"),
                rs.getString("password")
        );

    }
}
