package uk.ac.cf.nsa.web.phyt.workouts.model;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.workouts.DTO.WorkoutExercisesDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkoutExercisesMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new WorkoutExercisesDTO(
                rs.getInt("workout_id"),
                rs.getInt("client_id"),
                rs.getInt("exercise_length"),
                rs.getInt("exercise_rest"),
                rs.getInt("rep_rest"),
                rs.getInt("reps"),
                rs.getString("created_at"),
                rs.getString("complete_by"),
                rs.getString("completed_at"),
                rs.getInt("exercise_id"),
                rs.getString("exercise_name"),
                rs.getString("category"),
                rs.getString("equipment"),
                rs.getInt("thumbnail_id")
                );
    }
}
