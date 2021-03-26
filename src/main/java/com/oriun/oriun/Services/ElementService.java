package com.oriun.oriun.Services;
import java.util.ArrayList;
import java.util.Optional;
import javax.transaction.Transactional;

import com.oriun.oriun.Models.ElementModel;
import com.oriun.oriun.Repositories.ElementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ElementService {
    @Autowired
    ElementRepository elementRepository;

    public ArrayList<ElementModel> getElements(){
        return (ArrayList<ElementModel>)elementRepository.findAll();
    }
    
    public ElementModel saveElement(ElementModel element){
        return elementRepository.save(element);
    }


    public Optional<ElementModel> getElemetById(int element_id) {
        return elementRepository.findById(element_id);
    }

    /*public ElementModel updateElement(int elementID,ElementModel newelement) {
        ElementModel updelement = elementRepository.findById(elementID);
        updelement.setElement_name(newelement.getElement_name());
        updelement.setElement_image(newelement.getElement_image());
        updelement.setDescription(newelement.getDescription());
        updelement.setAvailable(newelement.isAvailable());
        ElementModel updatedElement = elementRepository.save(updelement);
        return updatedElement;
    }

    /*public ResponseEntity<?> deleteElement(int elementID) {
        ElementModel element  = elementRepository.findById(elementID);
        elementRepository.delete(element);
        return ResponseEntity.ok().build();
    }*/

}