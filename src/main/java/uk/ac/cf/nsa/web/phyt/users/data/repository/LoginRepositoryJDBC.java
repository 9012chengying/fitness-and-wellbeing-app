package uk.ac.cf.nsa.web.phyt.users.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;
import uk.ac.cf.nsa.web.phyt.users.forms.UserForm;
import uk.ac.cf.nsa.web.phyt.users.data.mapper.LoginMapper;

@Repository
public class LoginRepositoryJDBC implements LoginRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LoginRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

//    public boolean registerUser(UserForm userForm){
//        int rows = jdbcTemplate.update(
//                "SELECT from t_user(username,password) values(?,?,?,?)" ,
//                new Object[]{userForm.getUsername(), userForm.getPassword()});
//        return rows>0;
//    }

    @Override
    public UserDTO findByUserName(String username) {
        UserDTO userDTO = (UserDTO) jdbcTemplate.queryForObject(
        "SELECT id,user_name,user_password, user_role FROM user where user_name = ?",
         new LoginMapper(),new Object[]{username});
        return userDTO;
    }

}