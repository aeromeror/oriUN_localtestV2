package com.oriun.oriun.Controllers;

import com.oriun.oriun.Models.EventModel;
import com.oriun.oriun.Models.ReporteEvent;
import com.oriun.oriun.Models.ReporteModel;
import com.oriun.oriun.Services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReporteController {
    @Autowired
    ReporteService reporteService;

    @GetMapping("/Reportessall")
    public List<ReporteModel> obtenerallReportes(){
        return reporteService.getReportes();
    }
    @PostMapping("Reportarevento")
    public ResponseEntity Reportar(@RequestBody ReporteModel rm){
        return reporteService.Reportar(rm);
    }
    @DeleteMapping("PerdonReporte")
    public ResponseEntity PerdonarEvento(@RequestParam("id_event") int id_eve) {
        return reporteService.PerdonarEvento(id_eve);
    }
    /*@GetMapping("/EventosReportados")
    public List<EventModel> EventosReportados(){
        return reporteService.getRepEvent();
    }
    /*/@GetMapping("/EventosReportados")
    public List<ReporteEvent> EventosReportados(){
        return reporteService.getRepEvent();
    }
}
