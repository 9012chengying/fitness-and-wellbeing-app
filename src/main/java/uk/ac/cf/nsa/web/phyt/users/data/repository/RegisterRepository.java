package uk.ac.cf.nsa.web.phyt.users.data.repository;


import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.users.forms.UserForm;


public interface RegisterRepository {

    boolean registerUser(UserForm userForm);

    UserDTO getUserInfo(String username);

    boolean deleteUser(String userName);

    boolean updateUser(UserForm userForm);
}
