package com.api.crud.controllers;

import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public ArrayList<UserModel> getUser(){
        return this.userService.getUsers();
    }
    
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
        return this.userService.getById(id);
    } 
    
    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }  
    
    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request,@PathVariable("id") Long id ){
        return this.userService.updateById(request, id);
    }
    
    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        
        if(ok){
            return "User with id" + id + "deleted";
        } else {
            return "the user with id:" + id + "not exist in Data base";
        }
       
    }
}
