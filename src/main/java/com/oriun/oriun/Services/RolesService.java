package com.oriun.oriun.Services;

import com.oriun.oriun.Models.RolesModel;
import com.oriun.oriun.Repositories.RolesRepository;
import javax.transaction.Transactional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolesService {
    @Autowired
    
    RolesRepository rolesRepository;

    public ArrayList<RolesModel> getRoles(){
        return (ArrayList<RolesModel>)rolesRepository.findAll();
    }
    public RolesModel saveRoles(RolesModel roles){
        return rolesRepository.save(roles);
    }
}
