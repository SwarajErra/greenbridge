package com.greenbridge.service;

import com.greenbridge.configuration.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MyUserDetails myUserDetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return myUserDetails.getUserDetails(username);
    }
}
