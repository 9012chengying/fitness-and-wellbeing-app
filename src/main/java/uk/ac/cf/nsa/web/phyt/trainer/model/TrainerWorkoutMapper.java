package uk.ac.cf.nsa.web.phyt.trainer.model;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.trainer.DTO.TrainerWorkoutDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerWorkoutMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TrainerWorkoutDTO(
                rs.getInt("id"),
                rs.getInt("trainer_id"),
                rs.getInt("client_id"),
                rs.getString("user_name"),
                rs.getInt("exercise_count"),
                rs.getString("created_at"),
                rs.getString("complete_by"),
                rs.getBoolean("completed"),
                rs.getString("completed_at"),
                rs.getString("thumbnail_img"));
    }
}
