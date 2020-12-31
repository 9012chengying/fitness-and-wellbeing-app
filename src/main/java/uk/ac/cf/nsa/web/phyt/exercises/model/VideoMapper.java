package uk.ac.cf.nsa.web.phyt.exercises.model;



import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.exercises.DTO.VideoEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new VideoEntity(
                rs.getInt("id"),
                rs.getString("img_src"),
                rs.getString("alt_text"),
                rs.getString("type"),
                rs.getInt("exercise_id")
        );
    }
}
