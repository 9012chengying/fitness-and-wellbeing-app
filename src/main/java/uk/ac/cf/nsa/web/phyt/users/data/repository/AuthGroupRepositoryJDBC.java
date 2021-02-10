package uk.ac.cf.nsa.web.phyt.users.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.Authorities;
import uk.ac.cf.nsa.web.phyt.users.data.mapper.AuthorityMapper;

import java.util.List;

@Repository
public class AuthGroupRepositoryJDBC implements AuthGroupRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthGroupRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    public List<Authorities> findByUserName(String username) {
       List<Authorities> authorities =  jdbcTemplate.query(
                "SELECT username, authority FROM authorities Where username = ?",
                new AuthorityMapper(),new Object[]{username});
       System.out.println(authorities.toString());
       return authorities;

    }
}
