package com.oriun.oriun.Controllers;

import java.util.ArrayList;

import com.oriun.oriun.Services.Location_sport_sportsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Location_sport_sportsController {
    @Autowired
    Location_sport_sportsService location_sport_sportsservice;
    @GetMapping("/location_sport")
    public ResponseEntity validlocationsport(@RequestParam("sport") String sport,@RequestParam("location")String location){
        ArrayList<String>Sports=location_sport_sportsservice.validlocationsport(location);
        if(Sports.size()==0){
            return new ResponseEntity<>(
            HttpStatus.OK );
        }else{
            if(Sports.contains(sport)){
                return new ResponseEntity<>(
            HttpStatus.OK );
            }else{
                return new ResponseEntity<>(Sports,
                    HttpStatus.NOT_FOUND );
            }
        }
    }
}
