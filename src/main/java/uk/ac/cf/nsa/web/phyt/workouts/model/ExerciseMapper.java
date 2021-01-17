package uk.ac.cf.nsa.web.phyt.workouts.model;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.workouts.DTO.ExerciseDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExerciseMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ExerciseDTO(
                rs.getInt("workout_id"),
                rs.getInt("exercise_id"),
                rs.getString("exercise_name"),
                rs.getString("category"),
                rs.getString("equipment"),
                rs.getInt("thumbnail_id"),
                rs.getString("img_src"),
                rs.getString("alt_text"),
                rs.getString("type"));
    }
}
