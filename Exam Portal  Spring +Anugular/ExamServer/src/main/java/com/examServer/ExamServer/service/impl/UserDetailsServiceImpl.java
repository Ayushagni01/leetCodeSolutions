package com.examServer.ExamServer.service.impl;

import com.examServer.ExamServer.model.User;
import com.examServer.ExamServer.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    //load user by usenamne from database
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUsername = this.userRepository.findByUsername(username);
        if(byUsername==null)
        {
            System.out.println("No user Found for this credentials");
            throw new UsernameNotFoundException("N user FOund||");
        }
        return byUsername;
    }


}
