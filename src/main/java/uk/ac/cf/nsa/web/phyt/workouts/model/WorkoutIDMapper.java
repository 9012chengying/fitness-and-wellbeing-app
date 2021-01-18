package uk.ac.cf.nsa.web.phyt.workouts.model;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.workouts.DTO.WorkoutIDDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkoutIDMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new WorkoutIDDTO(
                rs.getInt("id"),
                rs.getInt("client_id"),
                rs.getBoolean("completed"));
    }
}