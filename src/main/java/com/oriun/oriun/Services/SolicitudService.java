package com.oriun.oriun.Services;

import com.oriun.oriun.Models.SolicitudModel;
import com.oriun.oriun.Repositories.SolicitudRepository;
import com.oriun.oriun.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SolicitudService {
    @Autowired
    SolicitudRepository solicitudRepository;
    @Autowired
    UserRepository userRepository;

    public List<SolicitudModel> getSolicitudes(){
        return solicitudRepository.findAll();
    }
    public ResponseEntity RegistrarSolicitud(SolicitudModel sm){
        if(userRepository.existsById(sm.getUSER_NAME())){
            String user=sm.getUSER_NAME();
            if(solicitudRepository.findByReporter(user).size()<1){
                solicitudRepository.save(sm);
                return new ResponseEntity<>("Solicitud agregada",
                        HttpStatus.OK );
            }
            else{
                return new ResponseEntity<>("Ya hay un solicitud en espera para este usuario",
                        HttpStatus.CONFLICT );
            }
        }
        else{
            return new ResponseEntity<>("Usuario no encontrado",
                    HttpStatus.BAD_REQUEST );
        }
    }
    public ResponseEntity OlvidarSolicitud(String user){
        if(userRepository.existsById(user)){
            solicitudRepository.deletebyUser(user);
            return new ResponseEntity<>("Solicitud de : "+user+" borrada",
                    HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Usuario no valido",
                    HttpStatus.BAD_REQUEST );
        }
    }
}
