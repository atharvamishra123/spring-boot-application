package com.demo.shopping.com.ApplicationConfiguration.SecurityServices;

import com.demo.shopping.com.Entity.User;
import com.demo.shopping.com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Optional;

public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<User> user = userRepository.findUserByUsername(username);
        User u = user.orElseThrow(()->new UsernameNotFoundException("User Not Found!"));
        return new CustomUserDetails(u);
    }
}
