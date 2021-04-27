package com.oriun.oriun.Controllers;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oriun.oriun.Models.LocationsportModel;
import com.oriun.oriun.Services.LocationsportService;
@RestController
public class LocationSportController {
    @Autowired
    LocationsportService locationsportservice;
    @GetMapping("/locationssport")
    public ArrayList<LocationsportModel> obtenerLocationsibu(){
        return locationsportservice.getLocationsports();
    }

    @PostMapping("/glocationsport")
    public LocationsportModel guardarLocationsibu(@RequestBody LocationsportModel locationsport){
        return this.locationsportservice.saveLocationsport(locationsport);
    }
}
