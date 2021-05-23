package com.oriun.oriun.Services;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import javax.transaction.Transactional;

import com.oriun.oriun.Models.ElementModel;
import com.oriun.oriun.Repositories.ElementRepository;
import com.oriun.oriun.Repositories.SportRepository;
import com.oriun.oriun.Repositories.LocationsibuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ElementService {
    @Autowired
    ElementRepository elementRepository;
    @Autowired
    SportRepository sportRepository;
    @Autowired
    LocationsibuRepository locationsibuRepository;

    public ArrayList<ElementModel> getElements(){
        return (ArrayList<ElementModel>)elementRepository.findAll();
    }
    public ArrayList<ElementModel> SubgetElements(int init,int size){
        return elementRepository.findSubList(init,size);
    }
    public ElementModel saveElement(ElementModel em){
        return elementRepository.save(em);
    }


    public ElementModel getElementById(int element_id) {
        Optional<ElementModel> temp=elementRepository.findById(element_id);
        if(temp.isPresent())return temp.get();
        return null;
    }

    public ResponseEntity updateElement(ElementModel newelement) {
        int Id_ne=newelement.getID_ELEMENT();
        if(elementRepository.existsById(Id_ne)){
        /*if(elementRepository.existsById(elementID)){
            Optional<ElementModel> oldelement = elementRepository.findById(elementID);
            if(oldelement.isPresent()){
                elementRepository.delete(oldelement.get());
                ElementModel updatedElement = elementRepository.save(newelement);
                return updatedElement;
            }else{
                return oldelement.get();
            }*/
            String nl=newelement.getNAME_LOCATION();
            if(!locationsibuRepository.existsById(nl)){
                return new ResponseEntity<>("Ubicacion no encontrada",
                        HttpStatus.NOT_FOUND );
            }
            else{
                String ns= newelement.getNAME_SPORT();
                if(!sportRepository.existsById(ns)){
                    return new ResponseEntity<>("Deporte no encontrado",
                            HttpStatus.NOT_FOUND );
                }
                else{
                    String des= newelement.getDESCRIPTION();
                    boolean av= newelement.isAVAILABLE();
                    String name= newelement.getELEMENT_NAME();
                    byte[] im=newelement.getELEMENT_IMAGE();
                    elementRepository.updatebyID(Id_ne,av,des,name,nl,ns,im);
                    return new ResponseEntity<>("Actualizado",
                            HttpStatus.OK);
                }
            }
        }
        else{
            return new ResponseEntity<>("Elemento antiguo no encontrado",
                    HttpStatus.BAD_REQUEST );
        }
    }
    public ResponseEntity uE(ElementModel newelement) {
        int Id_ne=newelement.getID_ELEMENT();
        if(elementRepository.existsById(Id_ne)){
        /*if(elementRepository.existsById(elementID)){
            Optional<ElementModel> oldelement = elementRepository.findById(elementID);
            if(oldelement.isPresent()){
                elementRepository.delete(oldelement.get());
                ElementModel updatedElement = elementRepository.save(newelement);
                return updatedElement;
            }else{
                return oldelement.get();
            }*/
            String nl=newelement.getNAME_LOCATION();
            if(!locationsibuRepository.existsById(nl)){
                return new ResponseEntity<>("Ubicacion no encontrada",
                        HttpStatus.NOT_FOUND );
            }
            else{
                String ns= newelement.getNAME_SPORT();
                if(!sportRepository.existsById(ns)){
                    return new ResponseEntity<>("Deporte no encontrado",
                            HttpStatus.NOT_FOUND );
                }
                else{
                    String des= newelement.getDESCRIPTION();
                    boolean av= newelement.isAVAILABLE();
                    //String name= newelement.getELEMENT_NAME();
                    byte[] im=newelement.getELEMENT_IMAGE();
                    elementRepository.updatebyIDnoname(Id_ne,av,des,nl,ns,im);
                    return new ResponseEntity<>("Actualizado",
                            HttpStatus.OK);
                }
            }
        }
        else{
            return new ResponseEntity<>("Elemento antiguo no encontrado",
                    HttpStatus.BAD_REQUEST );
        }
    }
    /*public ResponseEntity<?> deleteElement(int elementID) {
        ElementModel element  = elementRepository.findById(elementID);
        elementRepository.delete(element);
        return ResponseEntity.ok().build();
    }*/
    public ArrayList<ElementModel> getElementsLsibu(String name_lsibu,int init,int size){
        /*ArrayList<ElementModel> AL1=(ArrayList<ElementModel>)elementRepository.findAll();
        Iterator<ElementModel> AL1_iterator=AL1.iterator();
        while(AL1_iterator.hasNext()){
            ElementModel em=AL1_iterator.next();
            if(!em.getNAME_LOCATION().equals(name_lsibu)){
                AL1_iterator.remove();
            }
        }*/
        if(size<1)size=1000;
        if(init<1)init=0;
        return elementRepository.findbyLocation(name_lsibu,init,size);
    }
    public ArrayList<ElementModel> getElementsSport(String name_sport,int init,int size){
        if(size<1)size=1000;
        if(init<1)init=0;
        return elementRepository.findbySport(name_sport,init,size);
    }
    public ArrayList<ElementModel> getElementsAvailable(int init,int size){
        if(size<1)size=1000;
        if(init<1)init=0;
        return elementRepository.findAvailables(init,size);
    }
    public ElementModel saveElementLsibu(ElementModel element,String name_lsibu){
        if (element.getNAME_LOCATION().equals(name_lsibu)){
            return elementRepository.save(element);
        }
        return null;
    }
    public Optional<ElementModel> getElementByIdinLsibu(int element_id,String name_lsibu) {
        Optional<ElementModel> em=elementRepository.findById(element_id);
        if(em.isPresent()&& em.get().getNAME_LOCATION().equals(name_lsibu)){
            return em;
        }else{
            return null;
        }
    }
    public ElementModel updateElementLsibu(int elementID,ElementModel newelement,String name_lsibu) {
        Optional<ElementModel> oldelement = elementRepository.findById(elementID);
        if(oldelement.isPresent()&& newelement.getNAME_LOCATION().equals(name_lsibu)&& oldelement.get().getNAME_LOCATION().equals(name_lsibu)){
            elementRepository.delete(oldelement.get());
            ElementModel updatedElement = elementRepository.save(newelement);
            return updatedElement;
        }else{
            return oldelement.get();
        }
    }
    public ResponseEntity deleteElement(int id){
        if(elementRepository.existsById(id)){
            elementRepository.deleteById(id);
            return new ResponseEntity<>("Elemento Eliminado",
                    HttpStatus.OK);
        }
        {
            return new ResponseEntity<>("Elemento no existia",
                    HttpStatus.BAD_REQUEST );
        }
    }
    public int  changeavalaible(int id){
        if(elementRepository.existsById(id)){
           return elementRepository.changeAvailablebyID(id);
        }
        return 0;
    }
    public ResponseEntity updateimg(int id, byte[] img) {
        if(elementRepository.existsById(id)){
            elementRepository.updateimg(id,img);
            return new ResponseEntity<>("Imagen subida exitosamente",
                    HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Ubicacion antigua no encontrada",
                    HttpStatus.BAD_REQUEST );
        }
    }
}