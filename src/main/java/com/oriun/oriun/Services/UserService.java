package com.oriun.oriun.Services;
import java.util.ArrayList;
import java.util.Optional;
import javax.transaction.Transactional;

import com.oriun.oriun.Models.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oriun.oriun.Repositories.UserRepository;

@Service
@Transactional
public class UserService {
    @Autowired
    
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>)userRepository.findAll();
    }
    public Optional< UserModel>  getUser(String name){
        return userRepository.findById(name);
    } 
    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }
}
