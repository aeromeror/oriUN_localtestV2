package com.oriun.oriun.Services;
import java.util.ArrayList;

import javax.transaction.Transactional;

import com.oriun.oriun.Models.LocationsportModel;
import com.oriun.oriun.Repositories.LocationsportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LocationsportService {
    @Autowired
    LocationsportRepository locationsportRepository;

    public ArrayList<LocationsportModel> getLocationsports(){
        return (ArrayList<LocationsportModel>)locationsportRepository.findAll();
    }
    
    public LocationsportModel saveLocationsport(LocationsportModel element){
        return locationsportRepository.save(element);
    }


    /*public LocationsportModel getLocationsportById(String element_id) {
        return locationsportRepository.findById(element_id);
    }

    /*public LocationsportModel updateLocationsport(String newname) {
        LocationsportModel updelement = locationsportRepository.findById(elementID);
        updelement.setName_loc_sport(newname);
        ElementModel updatedElement = elementRepository.save(updelement);
        return updatedElement;
    }*/

    /*public ResponseEntity<?> deleteElement(String elementID) {
        LocationsportModel element  = locationsportRepository.findById(elementID);
        locationsportRepository.delete(element);
        return ResponseEntity.ok().build();
    }*/

}