package uk.ac.cf.nsa.web.phyt.trainer.model;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.trainer.DTO.ClientDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ClientDTO(
                rs.getInt("trainer_id"),
                rs.getInt("id"),
                rs.getString("user_name"));
    }

}
