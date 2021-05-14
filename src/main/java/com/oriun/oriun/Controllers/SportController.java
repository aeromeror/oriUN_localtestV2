package com.oriun.oriun.Controllers;
import java.util.ArrayList;
import java.util.List;

import com.oriun.oriun.Models.User_sportsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.oriun.oriun.Models.EventModel;
import com.oriun.oriun.Models.NotificationModel;
import com.oriun.oriun.Models.SportModel;
import com.oriun.oriun.Services.EventService;
import com.oriun.oriun.Services.NotificationService;
import com.oriun.oriun.Services.SportService;
@RestController
//@RequestMapping("/sports")
public class SportController {
    @Autowired
    SportService sportService;
    @Autowired
    NotificationService notificationService;
    @Autowired
    EventService eventService;
    @GetMapping("/sports")
    public ArrayList<SportModel> obtenerDeportes(){
        return sportService.getSports();
    }
    
    @PostMapping("/g")
    public SportModel guardardeporte(@RequestBody SportModel sports){
        SportModel s = sportService.saveSport(sports);
        List<EventModel> others= eventService.getEventByOther(sports.getNAME_SPORT());
        eventService.updateEventSport(sports.getNAME_SPORT());
        for(int i=0;i<others.size();i++){
            EventModel t =others.get(i);
            notificationService.updateNotificationSport(sports.getNAME_SPORT(), t.getID_EVENT());
        }
        return s;
    }

    @DeleteMapping("/nosports")
    public ResponseEntity borrarDeporte(@RequestParam("sport") String sport){
        if(sportService.existSport(sport)){
            sportService.deleteSport(sport);
            return new ResponseEntity<>(
                    "your sport delete is succesfull ",
                    HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(
                    "Deporte no encontrado",
                    HttpStatus.NOT_FOUND);
        }
    }
}