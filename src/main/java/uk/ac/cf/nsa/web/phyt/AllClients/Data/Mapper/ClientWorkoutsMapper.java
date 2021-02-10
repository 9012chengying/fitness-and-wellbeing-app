package uk.ac.cf.nsa.web.phyt.AllClients.Data.Mapper;

import uk.ac.cf.nsa.web.phyt.AllClients.Data.DTO.ClientWorkout;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientWorkoutsMapper implements RowMapper {


 @Override
 public Object mapRow(ResultSet rs, int numRow) throws SQLException{

            return new ClientWorkout(
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getBoolean("completed"),
                    rs.getTimestamp("completed_at"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("complete_by"),
                    rs.getInt("id"));
 }
}
