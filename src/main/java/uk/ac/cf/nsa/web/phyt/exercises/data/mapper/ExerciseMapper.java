package uk.ac.cf.nsa.web.phyt.exercises.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Exercise;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExerciseMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Exercise(
                rs.getInt("id"),
                rs.getString("exercise_name"),
                rs.getString("exercise_desc"),
                rs.getString("category"),
                rs.getString("thumbnail_img"),
                rs.getString("thumbnail_alt"),
                rs.getTimestamp("created_at"),
                rs.getInt("img_count"),
                rs.getInt("vid_count"));
    }
}
