package uk.ac.cf.nsa.web.phyt.users.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.Authorities;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorityMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Authorities(
                rs.getString("username"),
                rs.getString("authority")
                );
    }
}
