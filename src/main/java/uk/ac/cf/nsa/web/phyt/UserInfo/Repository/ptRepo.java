package uk.ac.cf.nsa.web.phyt.UserInfo.Repository;

import uk.ac.cf.nsa.web.phyt.UserInfo.Forms.PersonalTrainer;

public interface ptRepo {
//    String firstname, String lastname,String email
    boolean updatePtInfo(PersonalTrainer personalTrainer);

}
