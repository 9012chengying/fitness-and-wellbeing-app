package uk.ac.cf.nsa.web.phyt.workouts.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.workouts.DTO.ClientDTO;

import uk.ac.cf.nsa.web.phyt.workouts.model.ClientMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientRepositoryJDBC implements ClientRepository {

    private JdbcTemplate jdbcTemplate;
    private ClientDTO clientDTO;

    @Autowired

    public ClientRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }


    @Override
    public ClientDTO getClientInfo(String name) {
        String sql="SELECT * FROM i_user where name = ?";
        clientDTO = (ClientDTO)jdbcTemplate.queryForObject(sql, new ClientMapper(),new Object[]{name});
        if (clientDTO!=null){
            return clientDTO;
        }
        return null;
    }

    @Override
    public boolean updateClientInfo(ClientDTO clientDTO) {
        int rows = jdbcTemplate.update(
                "update i_user set name=?,gender=?,age=?,height=?,weight=?,email=? where name=?" ,
                new Object[]{ clientDTO.getName(),clientDTO.getGender(),clientDTO.getAge(),clientDTO.getWeight(),clientDTO.getHeight(),clientDTO.getEmail()});
        return rows>0;
    }

}
