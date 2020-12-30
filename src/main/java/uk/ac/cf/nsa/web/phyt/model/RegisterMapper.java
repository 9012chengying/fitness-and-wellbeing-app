package uk.ac.cf.nsa.web.phyt.model;


import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.DTO.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserEntity(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("name"),
                rs.getString("email"));
    }
}
