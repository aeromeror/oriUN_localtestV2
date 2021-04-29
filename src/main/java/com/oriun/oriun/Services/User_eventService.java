package com.oriun.oriun.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import com.oriun.oriun.Models.User_eventModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.oriun.oriun.Repositories.User_eventRepository;

@Service
@Transactional
public class User_eventService {
    @Autowired
    
    User_eventRepository user_eventRepository;

    public ArrayList<User_eventModel> getallUser_events(){
        return (ArrayList<User_eventModel>)user_eventRepository.findAll();
    }
    public List< User_eventModel>  getUser_event(String name){
        return user_eventRepository.findByUSER_NAME(name);
    }
    public List< User_eventModel>  getUser_eventbyEvent(int id_event){
        return user_eventRepository.findByID_EVENT(id_event);
    }
    public User_eventModel saveUser_event(User_eventModel user){
        return user_eventRepository.save(user);
    }
    public ResponseEntity deleteUserEvent(User_eventModel event){
        user_eventRepository.delete(event);
        return new ResponseEntity<>(
                                         HttpStatus.OK);
    }
    public boolean UserinEvent(int id_event,String name){
        return 0<user_eventRepository.findUSER_NAMEinID_EVENT(id_event,name).size();
    }
}