package com.oriun.oriun.Controllers;

import java.sql.Date;
import java.util.List;

import com.oriun.oriun.Models.AlqElem;
import com.oriun.oriun.Models.AlquilerModel;
import com.oriun.oriun.Services.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class AlquilerController {
    @Autowired
    AlquilerService alquilerService;

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
}
