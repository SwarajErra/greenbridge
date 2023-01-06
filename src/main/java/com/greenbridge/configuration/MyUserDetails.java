package com.greenbridge.configuration;

import com.greenbridge.entity.Farmer;
import com.greenbridge.repository.FarmerRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
@NoArgsConstructor
@Component
public class MyUserDetails implements UserDetails {
    @Autowired
    private FarmerRepository farmerRepository;
    private String userName;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        /* Arrays.stream(user.getRoles().split(",").map(SimpleGrantedAuthority::new).collect(Collectors.toList())*/
    }

    @Override
    public String getPassword() {
        return farmerRepository.findByUserName(userName).getPassword();
    }

    @Override
    public String getUsername() {
        Farmer farmer = farmerRepository.findByUserName(userName);
        return farmer.getUserName();
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

    public UserDetails getUserDetails(String username) {
        this.userName = username;
        return this;
    }
}
