package uk.ac.cf.nsa.web.phyt.AllClients.Data.Mapper;

import uk.ac.cf.nsa.web.phyt.AllClients.Data.DTO.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AllClientsMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new Client(
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("lastWorkout")

        );


    }


}
