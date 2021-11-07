package com.examServer.ExamServer.Controller;

import com.examServer.ExamServer.model.Role;
import com.examServer.ExamServer.model.User;
import com.examServer.ExamServer.model.UserRole;
import com.examServer.ExamServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //creating user
    @PostMapping("/")
    public User CreateUser(@RequestBody User user) throws Exception {
        user.setProfile("default.png");
        //encoding password with Bcrypt password encoder
    user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

     Set<UserRole> roles=new HashSet<>();
     Role role=new Role();
     role.setRoleId(45L);
    role.setRoleName("NORMAL");
    UserRole userRole=new UserRole();
    userRole.setUser(user);
    userRole.setRole(role);
    roles.add(userRole);
     return this.userService.createUser(user,roles);
    }

    //get service

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username)
    {
        return this.userService.getUser(username);

    }

    //delete
    @DeleteMapping("/{userid}")
    public void deleteUser(@PathVariable("userid") Long userid)
    {
        this.userService.deleteUser(userid);

    }

    //update the api



}
