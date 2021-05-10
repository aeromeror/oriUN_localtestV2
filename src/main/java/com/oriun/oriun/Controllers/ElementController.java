package com.oriun.oriun.Controllers;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/elntofsport")
    public ArrayList<ElementModel> obtenerElementosSport(@RequestParam("name_sport") String name_sport){
        return elementService.getElementsSport(name_sport);
    }
    @GetMapping("/elntav")
    public ArrayList<ElementModel> obtenerElementosAvailable(){
        return elementService.getElementsAvailable();
    }
    @DeleteMapping("/noelements")
    public void borrarElemento(@RequestParam("id") int id){
        elementService.deleteElement(id);
    }
    @PutMapping("/elementupd")
    public ResponseEntity actualizarElemento(@RequestBody ElementModel element){
        //ElementModel t=new ElementModel(element.getID_ELEMENT(),element.isAVAILABLE(),element.getDESCRIPTION(), element.getELEMENT_NAME(), element.getNAME_LOCATION(), element.getNAME_SPORT());
        return elementService.updateElement(element);
    }
    @PutMapping("/elementcs")
    public int CambiarEstadoElemento(@RequestParam("id") int id){
        //ElementModel t=new ElementModel(element.getID_ELEMENT(),element.isAVAILABLE(),element.getDESCRIPTION(), element.getELEMENT_NAME(), element.getNAME_LOCATION(), element.getNAME_SPORT());
        return elementService.changeavalaible(id);
    }
}