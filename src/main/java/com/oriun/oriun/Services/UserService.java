package com.oriun.oriun.Services;
import java.util.ArrayList;

import javax.transaction.Transactional;

import com.oriun.oriun.Models.UserModel;
import com.oriun.oriun.Repositories.UserRepositorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    
    UserRepositorie userRepositorie;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>)userRepositorie.findAll();
    }
    /*public UserModel getUser(int id){
        return (UserModel) userRepositorie.findById(id);
    }*/ 
    public UserModel saveUser(UserModel user){
        return userRepositorie.save(user);
    }
}
