package com.oriun.oriun.Services;

import com.oriun.oriun.Models.EventModel;
import com.oriun.oriun.Models.ReporteEvent;
import com.oriun.oriun.Models.ReporteModel;
import com.oriun.oriun.Repositories.EventRepository;
import com.oriun.oriun.Repositories.ReporteRepository;
import com.oriun.oriun.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ReporteService {
    @Autowired
    ReporteRepository reporteRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    UserRepository userRepository;

    public List<ReporteModel> getReportes(){
        return reporteRepository.findAll();
    }
    public ResponseEntity Reportar(ReporteModel rm){
        if(userRepository.existsById(rm.getUSER_NAME()) && eventRepository.existsById(rm.getID_EVENT())){
            if(reporteRepository.findByReporterandIEvent(rm.getUSER_NAME(), rm.getID_EVENT()).size()<1){
                reporteRepository.save(rm);
                return new ResponseEntity<>("Creado",
                        HttpStatus.CREATED );
            }
            else{
                return new ResponseEntity<>("El usuario ya reporto el evento",
                        HttpStatus.CONFLICT );
            }
        }
        else{
            return new ResponseEntity<>("Campos no validos",
                    HttpStatus.BAD_REQUEST );
        }
    }
    public ResponseEntity PerdonarEvento(int ide){
        if(eventRepository.existsById(ide)){
            reporteRepository.deletebyEvent(ide);
            return new ResponseEntity<>("Reportes para evento con id: "+ide+" eliminados",
                    HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("id no valido",
                    HttpStatus.BAD_REQUEST );
        }
    }
    /*public List<EventModel> getRepEvent(){
        return reporteRepository.findallWithEvent();
    }
    /*/public List<ReporteEvent> getRepEvent(){
        return reporteRepository.findallWithEvent();
    }
}
