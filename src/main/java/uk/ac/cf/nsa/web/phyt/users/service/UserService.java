package uk.ac.cf.nsa.web.phyt.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;
import uk.ac.cf.nsa.web.phyt.users.data.repository.RegisterRepository;
import uk.ac.cf.nsa.web.phyt.users.data.repository.UserRepository;
import uk.ac.cf.nsa.web.phyt.users.forms.UserForm;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    RegisterRepository registerRepository;

    public UserService(UserRepository userRepository, RegisterRepository registerRepository){
        this.userRepository=userRepository;
        this.registerRepository=registerRepository;
    }

    //Method to register a new trainer to the application
    public boolean setUpNewTrainer(UserForm userForm){
        if(!registerRepository.registerUser(userForm)){
            return false;
        } else {
            return true;
        }
    }

    //Method to get the user information held in the database
    public UserDTO getUserInfo(UserForm userForm){
         return registerRepository.getUserInfo(userForm.getUsername());
    }
}

