package uk.ac.cf.nsa.web.phyt.repository;


import uk.ac.cf.nsa.web.phyt.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.forms.UserForm;


public interface RegisterRepository {

    boolean registerUser(UserForm userForm);

    UserEntity getUserInfo(String username);

    boolean deleteUser(String userName);

    boolean updateUser(UserForm userForm);
}
