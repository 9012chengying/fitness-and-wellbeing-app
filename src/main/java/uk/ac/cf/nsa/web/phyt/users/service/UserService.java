package uk.ac.cf.nsa.web.phyt.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.Authorities;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.users.data.repository.RegisterRepository;
import uk.ac.cf.nsa.web.phyt.users.data.repository.UserPrincipal;
import uk.ac.cf.nsa.web.phyt.users.data.repository.UserRepository;
import uk.ac.cf.nsa.web.phyt.users.forms.UserForm;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    RegisterRepository registerRepository;
    PhytUserDetailsService phytUserDetailsService;

    public UserService(UserRepository userRepository, RegisterRepository registerRepository, PhytUserDetailsService phytUserDetailsService) {
        this.userRepository = userRepository;
        this.registerRepository = registerRepository;
        this.phytUserDetailsService = phytUserDetailsService;
    }

    //Method to register a new trainer to the application
    public boolean setUpNewTrainer(UserForm userForm) {
        if (!registerRepository.registerUser(userForm)) {
            return false;
        } else {
            return true;
        }
    }

    //Method to get the user information held in the database
    public UserDTO getUserInfo(UserForm userForm) {
        return registerRepository.getUserInfo(userForm.getUsername());
    }


    //get authentication information & store user Information in a new UserDTO
    public UserEntity authenticateUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.toString());
        String currentUserName = authentication.getName();
        UserDetails userPrincipal = phytUserDetailsService.loadUserByUsername(currentUserName);
        return userRepository.findByUserName(userPrincipal.getUsername());
    }

}


