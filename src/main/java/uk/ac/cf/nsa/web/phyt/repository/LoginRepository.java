package uk.ac.cf.nsa.web.phyt.repository;


import uk.ac.cf.nsa.web.phyt.DTO.UserDTO;
import uk.ac.cf.nsa.web.phyt.forms.UserForm;


public interface LoginRepository {

    boolean registerUser(UserForm userForm);

    UserDTO getUserInfo(String username);
}
