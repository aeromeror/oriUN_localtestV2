package com.oriun.oriun.Controllers;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oriun.oriun.Models.RolesModel;
import com.oriun.oriun.Services.RolesService;
@RestController
//@RequestMapping("/roles")
public class RolesController {
    @Autowired
    RolesService rolesService;
    @GetMapping("/roles")
    public ArrayList<RolesModel> obtenerRoles(){
        return rolesService.getRoles();
    }
    
    @PostMapping("/gr")
    public RolesModel guardarroles(@RequestBody RolesModel roles){
        return this.rolesService.saveRoles(roles);
    }

}