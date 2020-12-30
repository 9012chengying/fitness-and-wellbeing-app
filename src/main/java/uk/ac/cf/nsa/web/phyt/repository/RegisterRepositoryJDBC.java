package uk.ac.cf.nsa.web.phyt.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.forms.UserForm;

import java.util.List;

@Repository
public class RegisterRepositoryJDBC implements RegisterRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RegisterRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }


    public boolean registerUser(UserForm userForm){
        int rows = jdbcTemplate.update(
                "insert into t_user(username,password,name,email) values(?,?,?,?)" ,
                new Object[]{userForm.getUsername(), userForm.getPassword(), userForm.getName(), userForm.getEmail()});
        return rows>0;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return null;
    }
}
