//package uk.ac.cf.nsa.web.phyt.users.service;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;
//import uk.ac.cf.nsa.web.phyt.users.data.repository.LoginRepository;
//import uk.ac.cf.nsa.web.phyt.users.data.repository.UserPrincipal;
//
//@Service
//public class UserService implements UserDetailsService {
//
//    final private LoginRepository loginRepository;
//
//    public UserService (LoginRepository loginRepository){
//        super();
//        this.loginRepository = loginRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        UserDTO user = this.loginRepository.findByUserName(username);
//        if(null == user){
//            throw new UsernameNotFoundException("Cannot find username " + username);
//        }
//        return new UserPrincipal(user);
//    }
//}
