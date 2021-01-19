package uk.ac.cf.nsa.web.phyt.workouts.model;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.workouts.DTO.ExerciseMediaDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExerciseMediaMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ExerciseMediaDTO(
                rs.getInt("exercise_id"),
                rs.getString("type"),
                rs.getString("img_src"),
                rs.getString("alt_text"));
    }
}
