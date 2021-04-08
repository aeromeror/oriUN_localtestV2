package com.oriun.oriun.Services;
import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import com.oriun.oriun.Models.EventModel;
import com.oriun.oriun.Models.LocationsibuModel;

import com.oriun.oriun.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oriun.oriun.Repositories.LocationsibuRepository;

@Service
@Transactional
public class LocationSibuService {
    @Autowired

    LocationsibuRepository locationsibuRepository;

    public ArrayList<LocationsibuModel> getlocationsibu(){return (ArrayList<LocationsibuModel>)locationsibuRepository.findAll(); }

    public LocationsibuModel savelocationsibu(LocationsibuModel locationSibu){
        return locationsibuRepository.save(locationSibu);
    }
    public Optional<LocationsibuModel> getlocationsibuByName(String name) {
        return locationsibuRepository.findById(name);
    }
    public LocationsibuModel updatelocationsibu(String name,LocationsibuModel newlocationsibu) {
        Optional<LocationsibuModel> oldlocationsibu = locationsibuRepository.findById(name);
        if(oldlocationsibu.isPresent()){
            locationsibuRepository.delete(oldlocationsibu.get());
            LocationsibuModel updatedLocationsibu = locationsibuRepository.save(newlocationsibu);
            return updatedLocationsibu;
        }else{
            return oldlocationsibu.get();
        }
    }
    public LocationsibuModel deleteLocationsibu(LocationsibuModel locationsibu){
        locationsibuRepository.delete(locationsibu);
        return locationsibu;
    }

}
