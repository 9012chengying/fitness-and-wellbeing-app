package uk.ac.cf.nsa.web.phyt.repository;


import uk.ac.cf.nsa.web.phyt.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.forms.UserForm;

import java.util.List;

public interface RegisterRepository {

    boolean registerUser(UserForm userForm);

    List<UserEntity> getAllUsers();
}
