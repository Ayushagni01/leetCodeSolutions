package com.examServer.ExamServer.service.impl;

import com.examServer.ExamServer.helper.UserFoundException;
import com.examServer.ExamServer.model.User;
import com.examServer.ExamServer.model.UserRole;
import com.examServer.ExamServer.repo.RoleRepository;
import com.examServer.ExamServer.repo.UserRepository;
import com.examServer.ExamServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository ur;

    @Autowired
    private RoleRepository rr;


    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception{

        //check user is already present or not
        User local=this.ur.findByUsername(user.getUsername());
        if(local!=null)
        {
            System.out.println("UserName is already Present");
            throw  new UserFoundException();
        }
        else{
            //creatign username in else block
           // fetching one role at a time and save it on the roles tables
            for(UserRole uu:userRoles)
            {
                rr.save(uu.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.ur.save(user);

        }

        return local;
    }

    @Override
    public User getUser(String username) {
        return this.ur.findByUsername(username);
    }

    @Override
    public void deleteUser(long id) {
        this.ur.deleteById(id);
    }


}
