package com.oriun.oriun.Services;
import java.util.ArrayList;

import javax.transaction.Transactional;

import com.oriun.oriun.Models.SportModel;
import com.oriun.oriun.Repositories.SportRepositorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SportService {
    @Autowired
    
    SportRepositorie sportRepositorie;

    public ArrayList<SportModel> getSports(){
        return (ArrayList<SportModel>)sportRepositorie.findAll();
    }
    
    public SportModel saveSport(SportModel sport){
        return sportRepositorie.save(sport);
    }
}
