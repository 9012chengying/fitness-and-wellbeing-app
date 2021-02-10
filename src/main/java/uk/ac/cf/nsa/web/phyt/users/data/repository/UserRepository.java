package uk.ac.cf.nsa.web.phyt.users.data.repository;

import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.users.forms.UserForm;

public interface UserRepository {

    UserEntity findByUserName(String username);

    //interface method to get trainer id from login information
    int getTrainerID(String username, String password);

    //Get user role from database
    String getUserRole(String username, String password);

    //Updates User Info
    boolean updateUser(UserForm userForm);

}
