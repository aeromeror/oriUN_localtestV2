package com.oriun.oriun.Controllers;

import java.util.List;
import com.oriun.oriun.Models.AlquilerModel;
import com.oriun.oriun.Services.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AlquilerController {
    @Autowired
    AlquilerService alquilerService;

    @GetMapping("/alquileresall")
    public List<AlquilerModel> obtenerallEventos(){
        return alquilerService.getAlquileres();
    }
}
