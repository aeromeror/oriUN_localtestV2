package com.oriun.oriun.Controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Blob;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.oriun.oriun.Models.LocationsibuModel;
import com.oriun.oriun.Services.LocationSibuService;
import org.springframework.web.multipart.MultipartFile;
import org.hibernate.Hibernate;

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
    @PutMapping("/updlocation")
    public ResponseEntity actualizarLocationsibu(@RequestBody LocationsibuModel ls){
        return locationSibuService.updatelocationsibu(ls);
    }
    @DeleteMapping("/nolsibu")
    public ResponseEntity borrarLocationsibu(@RequestParam("name") String nls){
        return locationSibuService.deleteLocationsibu(nls);
    }
    @PutMapping("/uploadimgls")
    public ResponseEntity upimgls(@RequestParam("file")MultipartFile multipartFile,@RequestParam("name") String nls) throws IOException {
        byte[] im= multipartFile.getBytes();
        /*for (multipartFile : productsBean.getData()) {
            byte[] bytes = multipartFile.getBytes();
            im = new javax.sql.rowset.serial.SerialBlob(bytes);
        }*/
        //multipartFile.getInputStream();

        //Blob im=Hibernate.createBlob(multipartFile.getInputStream());
        return locationSibuService.updateimg(nls,im);
        /*return new ResponseEntity<>(String.format("Archivo %s subido exitosamente a "+nls,multipartFile.getOriginalFilename()),
                HttpStatus.OK);*/
    }
    @PutMapping("/Lsibuco")
    public int CambiarEstadoElemento(@RequestParam("name") String name){
        //ElementModel t=new ElementModel(element.getID_ELEMENT(),element.isAVAILABLE(),element.getDESCRIPTION(), element.getELEMENT_NAME(), element.getNAME_LOCATION(), element.getNAME_SPORT());
        return locationSibuService.changeopen(name);
    }
    @GetMapping("/myLSbyId")
    public LocationsibuModel obtenerLocationsibu(@RequestParam("name") String name){
        Optional <LocationsibuModel> myLS=locationSibuService.getlocationsibuByName(name);
        if(myLS.isPresent()){
            return myLS.get();
        }
        else {
            return new LocationsibuModel("(no hay lugar que concida con el nombre", false);
        }
    }
}
