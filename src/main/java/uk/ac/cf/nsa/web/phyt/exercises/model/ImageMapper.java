package uk.ac.cf.nsa.web.phyt.exercises.model;


import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.exercises.DTO.ImageEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ImageEntity(
                rs.getInt("id"),
                rs.getString("img_src"),
                rs.getString("alt_text"),
                rs.getString("type"),
                rs.getInt("exercise_id")
        );
    }

}
