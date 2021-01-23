package uk.ac.cf.nsa.web.phyt.client.model;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.client.DTO.WorkoutDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkoutMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new WorkoutDTO(
                rs.getInt("id"),
                rs.getInt("client_id"),
                rs.getInt("exercise_count"),
                rs.getInt("exercise_length"),
                rs.getInt("exercise_rest"),
                rs.getInt("rep_rest"),
                rs.getInt("reps"),
                rs.getString("equipment"),
                rs.getString("complete_by"),
                rs.getBoolean("completed"),
                rs.getString("completed_at"),
                rs.getString("created_at"),
                rs.getString("img_src"),
                rs.getString("alt_text"),
                rs.getString("type")
        );
    }
}
