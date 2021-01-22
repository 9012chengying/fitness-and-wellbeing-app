package uk.ac.cf.nsa.web.phyt.users.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.users.data.mapper.UserMapper;

@Repository
public class UserRepositoryJDBC implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    @Override
    public UserEntity findByUserName(String username) {
        UserEntity userEntity = (UserEntity) jdbcTemplate.queryForObject(
                "SELECT id,user_name,user_password, first_name, last_name, email, user_role, enabled FROM user where user_name = ? AND enabled=true",
                new UserMapper(),new Object[]{username});
        System.out.println(userEntity.toString());
        return userEntity;
    }


    public int getTrainerID(String username, String password){
        return 0;
    }

    //Get user role from database
    public String getUserRole(String username, String password) {
        return null;
    }
}
