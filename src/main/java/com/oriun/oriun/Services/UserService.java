package com.oriun.oriun.Services;
import java.util.ArrayList;
import java.util.Optional;
import javax.transaction.Transactional;

import com.oriun.oriun.Models.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public UserModel getUserByEmail(String email){
        return userRepository.findByEMAIL(email);
    }
    public void updateUserState(String user_name){
        userRepository.updateUserState(user_name);
    }
    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }
    public UserModel updateUser(String userid,UserModel newuser) {
        Optional<UserModel> olduser = userRepository.findById(userid);
        if(olduser.isPresent()){
            userRepository.delete(olduser.get());
            UserModel updatedUser = userRepository.save(newuser);
            return updatedUser;
        }else{
            return olduser.get();
        }
    }
    public Boolean existUser(String userid){
        return userRepository.existsById(userid);
    }
}
