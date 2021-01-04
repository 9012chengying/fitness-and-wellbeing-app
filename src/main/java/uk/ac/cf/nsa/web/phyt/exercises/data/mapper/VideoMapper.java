package uk.ac.cf.nsa.web.phyt.exercises.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Video;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Video(
                rs.getInt("id"),
                rs.getString("img_src"),
                rs.getString("alt_text"),
                rs.getString("type"),
                rs.getInt("exercise_id")
        );
    }
}
