package uk.ac.cf.nsa.web.phyt.users.data.repository;


import uk.ac.cf.nsa.web.phyt.users.data.DTO.TrainerDTO;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;
import uk.ac.cf.nsa.web.phyt.users.forms.UserForm;


public interface LoginRepository {

    //boolean registerUser(UserForm userForm);
    TrainerDTO findByUserName(String username);
}
