package com.oriun.oriun.Controllers;

import com.oriun.oriun.Models.SolicitudModel;
import com.oriun.oriun.Services.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SolicitudController {
    @Autowired
    SolicitudService solicitudService;

    @GetMapping("/Solicitudsall")
    public List<SolicitudModel> obtenerallSolicitudes(){
        return solicitudService.getSolicitudes();
    }
    @PostMapping("SoliDesban")
    public ResponseEntity Reportar(@RequestBody SolicitudModel sm){
        return solicitudService.RegistrarSolicitud(sm);
    }
    @DeleteMapping("OlvidarSoli")
    public ResponseEntity OlvidarSolicitud(@RequestParam("user") String user) {
        return solicitudService.OlvidarSolicitud(user);
    }
}
