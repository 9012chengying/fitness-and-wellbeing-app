package uk.ac.cf.nsa.web.phyt.users.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.users.data.repository.UserPrincipal;
import uk.ac.cf.nsa.web.phyt.users.data.repository.UserRepository;

@Service
public class PhytUserDetailsService implements UserDetailsService {

    final private UserRepository userRepository;

    public PhytUserDetailsService(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("Cannot find username " + username);
        }
        return new UserPrincipal(user);
    }
}
