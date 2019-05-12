package br.com.betterworld.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtUser implements UserDetails {

    private static final long serialVersionUID = -7471177486146141709L;

    private final String id;
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(String id, String username, String password, Collection<? extends GrantedAuthority> authorities){

        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @JsonIgnore
    public String getId(){
        return id;
    }

    @Override
    public String getUsername(){
        return  username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired(){
        return  true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked(){
        return  true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired(){
        return  true;
    }

    @JsonIgnore
    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return authorities;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }
}
