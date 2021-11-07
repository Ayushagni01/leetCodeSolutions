package com.examServer.ExamServer.Controller;

import com.examServer.ExamServer.config.JwtUtil;
import com.examServer.ExamServer.model.JwtRequest;
import com.examServer.ExamServer.model.JwtResponse;
import com.examServer.ExamServer.model.User;
import com.examServer.ExamServer.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateCOntroller {

    //geerating tocken
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;


    //generate toekn
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        try{
            authentcate(jwtRequest.getUsername(),jwtRequest.getPassword());


        }catch(UsernameNotFoundException e)
        {
            throw new Exception("User not found");
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken(userDetails);
          return ResponseEntity.ok(new JwtResponse(token));
    }




    private void authentcate(String username,String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));


        }catch(DisabledException e)
        {
            throw new Exception("User Details");
        }catch (BadCredentialsException e)
        {
            throw new Exception("Invalid credentials"+e.getMessage());
        }
    }

    //return the details of current users
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal)
    {
        return (User) this.userDetailsService.loadUserByUsername(principal.getName());

    }





}
