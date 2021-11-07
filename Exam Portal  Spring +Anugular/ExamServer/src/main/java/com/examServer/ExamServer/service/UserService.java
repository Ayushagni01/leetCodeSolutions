package com.examServer.ExamServer.service;

import com.examServer.ExamServer.model.User;
import com.examServer.ExamServer.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    public User getUser(String username);
    //delete user
    public void deleteUser(long id);

}
