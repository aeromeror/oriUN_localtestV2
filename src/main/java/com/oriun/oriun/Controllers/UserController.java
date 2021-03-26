package com.oriun.oriun.Controllers;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oriun.oriun.Models.UserModel;
import com.oriun.oriun.Services.UserService;
@RestController
//@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user")
    public ArrayList<UserModel> obtenerUsuarios(){
        return userService.getUsers();
    }
    
    @PostMapping("/g")
    public UserModel guardarusuario(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

}
