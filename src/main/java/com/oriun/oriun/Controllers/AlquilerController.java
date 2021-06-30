package com.oriun.oriun.Controllers;

import java.sql.Date;
import java.util.List;

import com.oriun.oriun.Models.AlqElem;
import com.oriun.oriun.Models.AlquilerModel;
import com.oriun.oriun.Models.ElementModel;
import com.oriun.oriun.Services.AlquilerService;
import com.oriun.oriun.Services.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.oriun.oriun.Services.UserService;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Optional;


@RestController
public class AlquilerController {
    @Autowired
    AlquilerService alquilerService;
    @Autowired
    UserService userService;
    @Autowired
    ElementService elementService;

    @GetMapping("/alquileresall")
    public List<AlquilerModel> obtenerallEventos(){
        return alquilerService.getAlquileres();
    }
    @PostMapping("/gAlquiler")
    public ResponseEntity RegAlquiler(@RequestBody AlquilerModel am){
        
        return alquilerService.registraralquiler(am);
    }
    @DeleteMapping("/noAlquiler")
    public ResponseEntity delAlquiler(@RequestParam("id") int id){
        if(alquilerService.deletealquiler(id)){
            return new ResponseEntity<>("Reserva eliminada",
                    HttpStatus.OK );
        }
        return new ResponseEntity<>("El id del alquiler no se encuentra",
                HttpStatus.NOT_FOUND );
    }
    @GetMapping("/lapluse")
    public List<AlqElem> LAlquilerplus(@RequestParam("name_loc") String nloc){
        return alquilerService.LAlquilerplus(nloc);
    }
    @GetMapping("/laElDate")
    public List<AlquilerModel> LAfechaElemento(@RequestParam("id_ele") int ide,@RequestParam("r_date") Date rdate){
        return alquilerService.LAfechaElemento(ide,rdate);
    }
    @GetMapping("/laUser")
    public List<AlqElem> LAUser(@RequestParam("user") String user){
        return alquilerService.LAbyUser(user);
    }
    @GetMapping("/laRdate")
    public List<AlquilerModel> LARdate(@RequestParam("r_date") Date rdate){
        return alquilerService.LAbyDate(rdate);
    }
    @GetMapping("/laElem")
    public List<AlquilerModel> LAElem(@RequestParam("id_ele") int ide){
        return alquilerService.LAbyElemento(ide);
    }

    @PostMapping("/solicitarAlq")
    public ResponseEntity alquilaritem(@RequestParam("user_name") String username, @RequestParam("id_elem") int id_ele,
            @RequestParam("i_date") Date idate, @RequestParam("tim") Time itime, @RequestParam("dur") int duration) {
        if (elementService.existElement(id_ele) && userService.existUser(username)) {
            AlquilerModel alqui = new AlquilerModel();
            ElementModel em = elementService.getElementById(id_ele);
            if (!alquilerService.IsUsed(idate, itime, duration,id_ele)) {
                alqui.setID_ELEMENT(id_ele);
                alqui.setUSER_NAME(username);
                alqui.setRENT_DATE(idate);
                alqui.setRENT_TIME(itime);
                LocalTime localtime = itime.toLocalTime();
                localtime = localtime.plusMinutes(duration);
                Time ftime = Time.valueOf(localtime);
                alqui.setRENT_DURATION(ftime);
                alquilerService.saveAlquiler(alqui);
                return new ResponseEntity<>(username + " ha reservado" + em.getELEMENT_NAME(),
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<>("El elemento ya esta alquilado/reservado",
                        HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>("Usuario o elementos no encontrados",
                    HttpStatus.BAD_REQUEST);
        }
    }
}
