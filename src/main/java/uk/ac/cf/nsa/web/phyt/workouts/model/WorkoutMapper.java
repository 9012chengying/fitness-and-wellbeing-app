package uk.ac.cf.nsa.web.phyt.workouts.model;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.workouts.DTO.WorkoutDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkoutMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new WorkoutDTO(
                rs.getInt("id"),
                rs.getInt("client_id"),
                rs.getInt("exercise_length"),
                rs.getInt("exercise_rest"),
                rs.getInt("rep_rest"),
                rs.getInt("reps"),
                rs.getBoolean("completed"),
                rs.getDate("completed_at"),
                rs.getDate("created_at")
        );
    }
}
