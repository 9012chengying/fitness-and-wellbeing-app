package uk.ac.cf.nsa.web.phyt.exercises.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Image;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Image(
                rs.getInt("id"),
                rs.getString("img_src"),
                rs.getString("alt_text"),
                rs.getString("type"),
                rs.getInt("exercise_id")
        );
    }

}
