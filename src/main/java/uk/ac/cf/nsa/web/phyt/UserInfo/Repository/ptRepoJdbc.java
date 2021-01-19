package uk.ac.cf.nsa.web.phyt.UserInfo.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.UserInfo.Forms.GeneralinfoPT;
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
        String sql = "UPDATE user set first_name = ?,last_name = ?,email = ?,user_name=? ,user_password=? WHERE id = 1";

        int update = jdbcTemplate.update(sql,new Object[] {personalTrainer.getFirstName(),personalTrainer.getLastName(),personalTrainer.getEmail(),personalTrainer.getUsername(),personalTrainer.getPassword()});
return update >0;
    }

    @Override
    public boolean updatePtGeneral(GeneralinfoPT generalinfoPT) {

        String sql = "UPDATE ptinfo set about = ?,qualifications = ? , PT_location= ? WHERE id = 1";

        int update = jdbcTemplate.update(sql,new Object[] {generalinfoPT.getAbout(),generalinfoPT.getQualifications(),generalinfoPT.getLocation()});

        return update>0;
    }
}
