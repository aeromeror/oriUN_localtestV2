package com.oriun.oriun.Controllers;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oriun.oriun.Models.SportModel;
import com.oriun.oriun.Services.SportService;
@RestController
//@RequestMapping("/sports")
public class SportController {
    @Autowired
    SportService sportService;
    @GetMapping("/sports")
    public ArrayList<SportModel> obtenerDeportes(){
        return sportService.getSports();
    }
    
    @PostMapping("/g")
    public SportModel guardardeporte(@RequestBody SportModel sports){
        return this.sportService.saveSport(sports);
    }

}