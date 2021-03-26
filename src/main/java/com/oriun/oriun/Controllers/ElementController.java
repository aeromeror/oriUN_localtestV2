package com.oriun.oriun.Controllers;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oriun.oriun.Models.ElementModel;
import com.oriun.oriun.Services.ElementService;
@RestController
//@RequestMapping("/sports")
public class ElementController {
    @Autowired
    ElementService elementService;
    @GetMapping("/el")
    public ArrayList<ElementModel> obtenerElementos(){
        return elementService.getElements();
    }
    
    @PostMapping("/el")
    public ElementModel guardardeporte(@RequestBody ElementModel element){
        return this.elementService.saveElement(element);
    }

}