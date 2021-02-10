//package uk.ac.cf.nsa.web.phyt.users.data.repository;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import uk.ac.cf.nsa.web.phyt.users.data.DTO.Authorities;
//import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
//
//import java.util.*;
//
//// Code to set up UserPrincipal
//// adapted from linkedin Learning video - Spring:Security by Frank P Moley III 30-5-2018
//// accessed 20/01/20
//// https://www.linkedin.com/learning/spring-spring-security/authorization?u=76816418
//
//public class UserPrincipal implements UserDetails {
//
//    final private UserEntity user;
//    private List<Authorities> authorities;
//
//    public UserPrincipal(UserEntity user, List<Authorities> authorities){
//        super();
//        this.user = user;
//        this.authorities=authorities;
//    }
//
//    @Override
//        public Collection<? extends GrantedAuthority> getAuthorities() {
//            if(null==authorities){
//                return Collections.emptySet();
//            }
//        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
//            authorities.forEach(group ->{
//                grantedAuthorities.add(new SimpleGrantedAuthority(group.getAuthGroup()));
//            });
//            return grantedAuthorities;
//        }
//
//    @Override
//    public String getPassword() {
//        return this.user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return this.user.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.user.getEnabled();
//    }
//}
////End of referenced code
