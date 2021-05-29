package com.oriun.oriun.Controllers;
import java.io.IOException;
import java.util.ArrayList;

import com.oriun.oriun.Models.ElementBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.oriun.oriun.Models.ElementModel;
import com.oriun.oriun.Services.ElementService;
import org.springframework.web.multipart.MultipartFile;

@RestController
//@RequestMapping("/element")
public class ElementController {
    @Autowired
    ElementService elementService;
    @GetMapping("/elements")
    public ArrayList<ElementModel> obtenerElementos(@RequestParam("init") int init,@RequestParam("size")int size){
        if(init<1)init=0;
        if(size<1){
            return elementService.getElements();
        }
        return elementService.SubgetElements(init,size);
    }
    @GetMapping("/nelements")
    public long nElementos(){
        return elementService.Nelements();
    }
    @GetMapping("/Singlelmts")
    public ArrayList<ElementBasic> singleElementos(){
        return elementService.SingleList();
    }
    @GetMapping("/MyElement")
    public ElementModel miElemento(@RequestParam("id") int id){
        return elementService.getElementById(id);
    }
    @PostMapping("/element")
    public ElementModel guardarElemento(@RequestBody ElementModel el){
        if((el.getDESCRIPTION()!=null)&&(el.getELEMENT_NAME()!=null)&&(el.getNAME_LOCATION()!=null)&&(el.getNAME_SPORT()!=null)){
            return this.elementService.saveElement(el);
        }
        return null;
    }
    @GetMapping("/elntofsibu")
    public ArrayList<ElementModel> obtenerElementossibu(@RequestParam("name_location") String name_lsibu,@RequestParam("init") int init,@RequestParam("size")int size){
        return elementService.getElementsLsibu(name_lsibu,init,size);
    }
    @GetMapping("/elntofsport")
    public ArrayList<ElementModel> obtenerElementosSport(@RequestParam("name_sport") String name_sport,@RequestParam("init") int init,@RequestParam("size")int size){
        return elementService.getElementsSport(name_sport,init,size);
    }
    @GetMapping("/elntav")
    public ArrayList<ElementModel> obtenerElementosAvailable(@RequestParam("init") int init,@RequestParam("size")int size){
        return elementService.getElementsAvailable(init,size);
    }
    @DeleteMapping("/noelements")
    public ResponseEntity borrarElemento(@RequestParam("id") int id){
        return elementService.deleteElement(id);
    }
    @PutMapping("/elementupd")
    public ResponseEntity actualizarElemento(@RequestBody ElementModel element)//,@RequestParam("id") int id,@RequestParam("available") boolean av,@RequestParam("description") String des,@RequestParam("namel") String nl,@RequestParam("names") String ns,@RequestParam("imagee") byte[] image
    {
        //ElementModel t=new ElementModel(element.getID_ELEMENT(),element.isAVAILABLE(),element.getDESCRIPTION(), element.getELEMENT_NAME(), element.getNAME_LOCATION(), element.getNAME_SPORT());
        //ElementModel el=new ElementModel(id,av,des,"dgosdfg",nl,ns,image);
        return elementService.updateElement(element);
    }
    @PutMapping("/a")
    public ResponseEntity ae(@RequestBody ElementModel element){
        //ElementModel t=new ElementModel(element.getID_ELEMENT(),element.isAVAILABLE(),element.getDESCRIPTION(), element.getELEMENT_NAME(), element.getNAME_LOCATION(), element.getNAME_SPORT());
        return elementService.uE(element);
    }
    @PutMapping("/elementcs")
    public int CambiarEstadoElemento(@RequestParam("id") int id){
        //ElementModel t=new ElementModel(element.getID_ELEMENT(),element.isAVAILABLE(),element.getDESCRIPTION(), element.getELEMENT_NAME(), element.getNAME_LOCATION(), element.getNAME_SPORT());
        return elementService.changeavalaible(id);
    }
    @PutMapping("/uploadimgel")
    public ResponseEntity upimgel(@RequestParam("file") MultipartFile multipartFile, @RequestParam("ide") int id_im) throws IOException {
        byte[] im= multipartFile.getBytes();
        return elementService.updateimg(id_im,im);
    }
}