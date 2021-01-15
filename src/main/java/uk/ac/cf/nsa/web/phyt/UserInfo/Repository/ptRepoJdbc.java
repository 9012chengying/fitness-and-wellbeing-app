package uk.ac.cf.nsa.web.phyt.UserInfo.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.UserInfo.Forms.PersonalTrainer;

@Repository
public class ptRepoJdbc implements ptRepo {

    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public ptRepoJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean updatePtInfo(PersonalTrainer personalTrainer) {
        String sql = "UPDATE pt set first_name = ?,last_name = ?,email = ? WHERE id = 1";

        int update = jdbcTemplate.update(sql,new Object[] {personalTrainer.getFirstName(),personalTrainer.getLastName(),personalTrainer.getEmail()});
return update >0;
    }
}
