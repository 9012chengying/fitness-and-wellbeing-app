package uk.ac.cf.nsa.web.phyt.users.data.repository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {

    final private UserDTO user;

    public UserPrincipal(UserDTO user){
        super();
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(null == this.user.getRole()){
            return Collections.emptySet();
        } else if(this.user.getRole().equalsIgnoreCase("trainer")){
            return Collections.singleton(new SimpleGrantedAuthority("trainer"));
        } else {
            return Collections.singleton(new SimpleGrantedAuthority("client"));
        }
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
