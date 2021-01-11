package uk.ac.cf.nsa.web.phyt.exercises.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.exercises.data.repository.UserRepository;

@Repository
public class UserRepositoryJDBC implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    public int getTrainerID(String username, String password){
        return 0;
    }

    //Get user role from database
    public String getUserRole(String username, String password) {
        return null;
    }
}
