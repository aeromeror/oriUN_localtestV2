package com.oriun.oriun.Controllers;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oriun.oriun.Models.ElementModel;
import com.oriun.oriun.Services.ElementService;
@RestController
//@RequestMapping("/element")
public class ElementController {
    @Autowired
    ElementService elementService;
    @GetMapping("/elements")
    public ArrayList<ElementModel> obtenerElementos(){
        return elementService.getElements();
    }
    @PostMapping("/element")
    public ElementModel guardarElemento(@RequestBody ElementModel element){
        return this.elementService.saveElement(element);
    }
    @GetMapping("/elntofsibu")
    public ArrayList<ElementModel> obtenerElementossibu(@RequestParam("name_location") String name_lsibu){
        return elementService.getElementsLsibu(name_lsibu);
    }
}