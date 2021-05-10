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
    
    public ElementModel saveElement(ElementModel element){
        return elementRepository.save(element);
    }


    public Optional<ElementModel> getElementById(int element_id) {
        return elementRepository.findById(element_id);
    }

    public ResponseEntity updateElement(ElementModel newelement) {
        if(elementRepository.existsById(newelement.getID_ELEMENT())){
        /*if(elementRepository.existsById(elementID)){
            Optional<ElementModel> oldelement = elementRepository.findById(elementID);
            if(oldelement.isPresent()){
                elementRepository.delete(oldelement.get());
                ElementModel updatedElement = elementRepository.save(newelement);
                return updatedElement;
            }else{
                return oldelement.get();
            }*/
            int ID=newelement.getID_ELEMENT();
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
                    elementRepository.updatebyID(ID,av,des,name,nl,ns);
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
    public ArrayList<ElementModel> getElementsLsibu(String name_lsibu){
        /*ArrayList<ElementModel> AL1=(ArrayList<ElementModel>)elementRepository.findAll();
        Iterator<ElementModel> AL1_iterator=AL1.iterator();
        while(AL1_iterator.hasNext()){
            ElementModel em=AL1_iterator.next();
            if(!em.getNAME_LOCATION().equals(name_lsibu)){
                AL1_iterator.remove();
            }
        }*/
        return elementRepository.findbyLocation(name_lsibu);
    }
    public ArrayList<ElementModel> getElementsSport(String name_sport){
        /*ArrayList<ElementModel> AL1=(ArrayList<ElementModel>)elementRepository.findAll();
        Iterator<ElementModel> AL1_iterator=AL1.iterator();
        while(AL1_iterator.hasNext()){
            ElementModel em=AL1_iterator.next();
            if(!em.getNAME_LOCATION().equals(name_lsibu)){
                AL1_iterator.remove();
            }
        }*/
        return elementRepository.findbySport(name_sport);
    }
    public ArrayList<ElementModel> getElementsAvailable(){
        /*ArrayList<ElementModel> AL1=(ArrayList<ElementModel>)elementRepository.findAll();
        Iterator<ElementModel> AL1_iterator=AL1.iterator();
        while(AL1_iterator.hasNext()){
            ElementModel em=AL1_iterator.next();
            if(!em.getNAME_LOCATION().equals(name_lsibu)){
                AL1_iterator.remove();
            }
        }*/
        return elementRepository.findAvailables();
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
    public void deleteElement(int id){
        if(elementRepository.existsById(id)){
            elementRepository.deleteById(id);
        }
    }
    public int  changeavalaible(int id){
        if(elementRepository.existsById(id)){
           return elementRepository.changeAvailablebyID(id);
        }
        return 0;
    }
}