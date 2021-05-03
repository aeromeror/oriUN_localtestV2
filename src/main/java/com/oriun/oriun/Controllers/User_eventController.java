package com.oriun.oriun.Controllers;

import java.util.List;

import com.oriun.oriun.Models.User_eventModel;
import com.oriun.oriun.Services.User_eventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User_eventController {
    @Autowired
    User_eventService user_eventService;

    @GetMapping("/asistents")
    public List<User_eventModel> obtenerAsistencia(@RequestParam("id_event") int id_event){
        return user_eventService.getUser_eventbyEvent(id_event);
    }
}
