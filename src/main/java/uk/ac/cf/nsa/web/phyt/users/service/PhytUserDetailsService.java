package uk.ac.cf.nsa.web.phyt.users.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.Authorities;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.users.data.repository.AuthGroupRepository;
import uk.ac.cf.nsa.web.phyt.users.data.repository.UserPrincipal;
import uk.ac.cf.nsa.web.phyt.users.data.repository.UserRepository;

import java.util.List;

// Code to set up UserDetailsService
// adapted from linkedin Learning video - Spring:Security by Frank P Moley III 30-5-2018
// accessed 20/01/20
// https://www.linkedin.com/learning/spring-spring-security/authorization?u=76816418

@Service
public class PhytUserDetailsService implements UserDetailsService {

    final private UserRepository userRepository;
    final private AuthGroupRepository authGroupRepository;

    public PhytUserDetailsService(UserRepository userRepository, AuthGroupRepository authGroupRepository){
        super();
        this.userRepository = userRepository;
        this.authGroupRepository=authGroupRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("Cannot find username " + username);
        }
        List<Authorities> authorities = this.authGroupRepository.findByUserName(username);
        return new UserPrincipal(user, authorities);
    }
}

    //End of referenced code
