package uk.ac.cf.nsa.web.phyt.AllClients.Data.Mapper;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.cf.nsa.web.phyt.AllClients.Data.DTO.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AllClientsMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new Client(
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getTimestamp("lastWorkout"),
                rs.getInt("client_id"),
                rs.getInt("numOfWorkouts"));


    }


}
