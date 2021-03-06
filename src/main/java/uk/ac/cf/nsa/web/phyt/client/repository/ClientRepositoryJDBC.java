package uk.ac.cf.nsa.web.phyt.client.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.client.DTO.ClientDTO;

import uk.ac.cf.nsa.web.phyt.client.model.ClientMapper;

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
    public ClientDTO getClientInfo(int id) {
        String sql="SELECT * FROM i_user where user_id = ?";
        clientDTO = (ClientDTO)jdbcTemplate.queryForObject(sql, new ClientMapper(),new Object[]{id});
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
