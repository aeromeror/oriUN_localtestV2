package com.oriun.oriun.Controllers;

import java.util.List;

import com.oriun.oriun.Models.User_sportsModel;
import com.oriun.oriun.Services.User_sportsService;
import com.oriun.oriun.Services.UserService;
import com.oriun.oriun.Services.SportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User_sportsController {
    @Autowired

    User_sportsService user_sportsService;
    @Autowired
    UserService userService;
    @Autowired
    SportService sportService;

    @GetMapping("/usersports")
    public List<User_sportsModel> obtenerdeporteUsuarios(@RequestParam("user") String user_name){
        return user_sportsService.getUser_sports(user_name);
    }
    
    @PostMapping("/usersportsreg")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity registersport(@RequestParam("user") String user_name, @RequestParam("sport") String sport) {
        if(userService.existUser(user_name)){
            if(sportService.existSport(sport)){
                User_sportsModel usersport= new User_sportsModel();
                usersport.setNAME_SPORT(sport);
                usersport.setUSER_NAME(user_name);
                user_sportsService.saveUser_sport(usersport);
                return new ResponseEntity<>(
                        "your user sport register is succesfull ",
                        HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(
                        "Deporte no encontrado",
                        HttpStatus.NOT_FOUND);
            }
        }
        else{
            return new ResponseEntity<>(
                    "Usuario no encontrado",
                    HttpStatus.NOT_FOUND);
        }
	}

    @DeleteMapping("/usersportsdel")
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity deletesport(@RequestParam("user") String user_name, @RequestParam("sport") String sport) {
        if(userService.existUser(user_name)){
            if(sportService.existSport(sport)){
                User_sportsModel usersport= new User_sportsModel();
                usersport.setNAME_SPORT(sport);
                usersport.setUSER_NAME(user_name);
                user_sportsService.deleteUserSport(usersport);
                return new ResponseEntity<>(
                        "your user sport delete is succesfull ",
                        HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(
                        "Deporte no encontrado",
                        HttpStatus.NOT_FOUND);
            }
        }
        else{
            return new ResponseEntity<>(
                    "Usuario no encontrado",
                    HttpStatus.NOT_FOUND);
        }
	}
}
