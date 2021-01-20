package uk.ac.cf.nsa.web.phyt.workouts.model;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.workouts.DTO.ExerciseWorkoutDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExerciseWorkoutMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ExerciseWorkoutDTO(
                rs.getInt("workout_id"),
                rs.getInt("exercise_id"),
                rs.getString("exercise_name"),
                rs.getString("category"),
                rs.getString("equipment"),
                rs.getString("thumbnail_img"),
                rs.getString("thumbnail_alt"));
    }
}
