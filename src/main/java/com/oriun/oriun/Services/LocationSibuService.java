package com.oriun.oriun.Services;
import java.util.ArrayList;
import java.util.Optional;
import java.sql.Blob;

import javax.transaction.Transactional;

import com.oriun.oriun.Models.EventModel;
import com.oriun.oriun.Models.LocationsibuModel;

import com.oriun.oriun.Repositories.ElementRepository;
import com.oriun.oriun.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.oriun.oriun.Repositories.LocationsibuRepository;

@Service
@Transactional
public class LocationSibuService {
    @Autowired

    LocationsibuRepository locationsibuRepository;

    @Autowired
    ElementRepository elementRepository;

    public ArrayList<LocationsibuModel> getlocationsibu(){return (ArrayList<LocationsibuModel>)locationsibuRepository.findAll(); }

    public LocationsibuModel savelocationsibu(LocationsibuModel locationSibu){
        return locationsibuRepository.save(locationSibu);
    }
    public Optional<LocationsibuModel> getlocationsibuByName(String name) {
        return locationsibuRepository.findById(name);
    }
    public ResponseEntity updatelocationsibu(LocationsibuModel newlocationsibu) {
        String nl=newlocationsibu.getNAME_LOCATION();
        if(locationsibuRepository.existsById(nl)){
            boolean op=newlocationsibu.isOPEN();
            byte[] im=newlocationsibu.getIMAGE_LOCATION();
            locationsibuRepository.updatebyID(nl,op,im);
            return new ResponseEntity<>("Actualizado",
                    HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Ubicacion antigua no encontrada",
                    HttpStatus.BAD_REQUEST );
        }/*
        Optional<LocationsibuModel> oldlocationsibu = locationsibuRepository.findById(name);
        if(oldlocationsibu.isPresent()){
            locationsibuRepository.delete(oldlocationsibu.get());
            LocationsibuModel updatedLocationsibu = locationsibuRepository.save(newlocationsibu);
            return updatedLocationsibu;
        }else{
            return oldlocationsibu.get();
        }*/
    }
    public ResponseEntity deleteLocationsibu(String nls){
        if(locationsibuRepository.existsById(nls)){
            //if(elementRepository.findbyLocation(nls).size()>0){
                elementRepository.deleteElementsinLSibu(nls);
            //}
            locationsibuRepository.deleteById(nls);
            return new ResponseEntity<>("Ubicacion eliminada",
                    HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Ubicacion antigua no existia",
                    HttpStatus.BAD_REQUEST );
        }
    }
    public ResponseEntity updateimg(String nl, byte[] img) {
        if(locationsibuRepository.existsById(nl)){
            locationsibuRepository.updateimg(nl, img);
            return new ResponseEntity<>("Imagen subida exitosamente",
                    HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Ubicacion antigua no encontrada",
                    HttpStatus.BAD_REQUEST );
        }
    }
    public int  changeopen(String nls){
        if(locationsibuRepository.existsById(nls)){
            return locationsibuRepository.changeOpenbyID(nls);
        }
        return 0;
    }

}
