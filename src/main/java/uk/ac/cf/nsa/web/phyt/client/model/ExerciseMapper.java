package uk.ac.cf.nsa.web.phyt.client.model;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.client.DTO.ExerciseDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExerciseMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ExerciseDTO(
                rs.getInt("id"),
                rs.getString("exercise_name"),
                rs.getString("exercise_desc"),
                rs.getString("category"));
    }
}
