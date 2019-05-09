package br.com.betterworld.security.service;

import br.com.betterworld.security.entity.User;
import br.com.betterworld.security.jwt.JwtUserFactory;
import br.com.betterworld.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userService.findByEmail(email);
        if (user == null){
            throw  new UsernameNotFoundException( String.format("No user found with username '%s'.", email));
        }else{
            return JwtUserFactory.create(user);
        }

    }

}
