package com.greenbridge.controller;

import com.greenbridge.service.MyUserDetailsService;
import com.greenbridge.payload.AuthenticationRequest;
import com.greenbridge.payload.AuthenticationResponse;
import com.greenbridge.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createJwtToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),authenticationRequest.getPassword()));
        }
        catch (BadCredentialsException ex){
            throw new Exception("Incorrect username or password",ex);
        }
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
         String jwt = jwtUtil.generateToken(userDetails);
         return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }


}
