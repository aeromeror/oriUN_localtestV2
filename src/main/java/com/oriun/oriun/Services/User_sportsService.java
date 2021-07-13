package com.oriun.oriun.Services;

import java.util.List;

import javax.transaction.Transactional;

import com.oriun.oriun.Models.User_sportsModel;
import com.oriun.oriun.Repositories.User_sportsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class User_sportsService {
    @Autowired
    
    User_sportsRepository user_sportsRepository;

    public List< User_sportsModel>getUser_sports(String name){
        return user_sportsRepository.findByUSER_NAME(name);
    } 
    public User_sportsModel saveUser_sport(User_sportsModel usersport){
        return user_sportsRepository.save(usersport);
    }
    public void deleteUserSport(User_sportsModel usersport){
        user_sportsRepository.delete(usersport);
        /*return new ResponseEntity<>(
                                         HttpStatus.OK);*/
    }
}
