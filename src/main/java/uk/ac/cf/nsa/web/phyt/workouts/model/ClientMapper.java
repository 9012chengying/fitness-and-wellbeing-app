package uk.ac.cf.nsa.web.phyt.workouts.model;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.workouts.DTO.ClientDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ClientDTO(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("gender"),
                rs.getInt("age"),
                rs.getFloat("height"),
                rs.getFloat("weight"),
                rs.getString("email"));
    }
}
