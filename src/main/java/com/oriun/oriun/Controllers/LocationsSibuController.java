package com.oriun.oriun.Controllers;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oriun.oriun.Models.LocationsibuModel;
import com.oriun.oriun.Services.LocationSibuService;
@RestController
//@RequestMapping("/locationsibu")
public class LocationsSibuController {
    @Autowired
    LocationSibuService locationSibuService;
    @GetMapping("/locationssibu")
    public ArrayList<LocationsibuModel> obtenerLocationsibu(){
        return locationSibuService.getlocationsibu();
    }

    @PostMapping("/glocationsibu")
    public LocationsibuModel guardarLocationsibu(@RequestBody LocationsibuModel locationsibu){
        return this.locationSibuService.savelocationsibu(locationsibu);
    }
}
