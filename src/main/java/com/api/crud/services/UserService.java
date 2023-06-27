package com.api.crud.services;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;
import java.util.ArrayList;
import java.util.Optional;
//import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    IUserRepository userRepository;
    
    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }
    
    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }
    
    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    } 
    
    public UserModel updateById(UserModel request, Long id ){
        UserModel user = userRepository.findById(id).get();
        
        // se setea el objeto user
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        userRepository.save(user);
        
        return user;
    }
    
    public Boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
