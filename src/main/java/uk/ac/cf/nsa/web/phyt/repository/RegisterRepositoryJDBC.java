package uk.ac.cf.nsa.web.phyt.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.forms.UserForm;
import uk.ac.cf.nsa.web.phyt.model.RegisterMapper;

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
    public UserEntity getUserInfo(String username) {
        String sql="SELECT userid, username,password, name, email FROM t_user where username = ?";
        List<UserEntity> list = jdbcTemplate.query(sql,new Object[]{username}, new RegisterMapper());
        if (list!=null&&list.size()!=0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean deleteUser(String userName) {
        int rows =   jdbcTemplate.update("delete from t_user where  username = ?",userName);
        return rows>0;
    }

    @Override
    public boolean updateUser(UserForm userForm) {
        int rows = jdbcTemplate.update(
                "update t_user set name=?,email=? where username=?" ,
                new Object[]{ userForm.getName(), userForm.getEmail(),userForm.getUsername()});
        return rows>0;
    }
}
