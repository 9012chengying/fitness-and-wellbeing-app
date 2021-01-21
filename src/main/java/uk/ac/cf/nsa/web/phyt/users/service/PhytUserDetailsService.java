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
