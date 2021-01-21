package uk.ac.cf.nsa.web.phyt.users.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;
import uk.ac.cf.nsa.web.phyt.users.forms.UserForm;
import uk.ac.cf.nsa.web.phyt.users.data.mapper.RegisterMapper;

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
                "insert into user (user_name,user_password,first_name,last_name,email, user_role) values(?,?,?,?,?,?)",
                new Object[]{userForm.getUsername(), userForm.getPassword(), userForm.getFirstname(),userForm.getLastname(), userForm.getEmail(), userForm.getRole()});
        return rows>0;
    }

    @Override
    public UserDTO getUserInfo(String username) {
        String sql="SELECT * FROM user where user_name = ?";
        List<UserDTO> list = jdbcTemplate.query(sql, new RegisterMapper(), new Object[]{username});
        if (list!=null&&list.size()!=0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean deleteUser(String userName) {
        int rows =   jdbcTemplate.update("delete from user where  user_name = ?",userName);
        return rows>0;
    }

    @Override
    public boolean updateUser(UserForm userForm) {
        int rows = jdbcTemplate.update(
                "update user set first_name=?,last_name=?,email=? where user_name=?" ,
                new Object[]{ userForm.getFirstname(),userForm.getLastname(),userForm.getEmail(),userForm.getUsername()});
        return rows>0;
    }
}
