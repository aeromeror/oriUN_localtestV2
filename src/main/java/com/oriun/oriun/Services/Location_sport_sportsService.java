package com.oriun.oriun.Services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import com.oriun.oriun.Repositories.Location_sport_sportsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Location_sport_sportsService {
    @Autowired
    Location_sport_sportsRepository location_sport_sportsrepository;

    public ArrayList<String> validlocationsport(String location){
        return location_sport_sportsrepository.ListsportsbyLocation(location);
    }
}
