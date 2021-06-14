package com.oriun.oriun.Services;

import com.oriun.oriun.Models.AlquilerModel;
import com.oriun.oriun.Repositories.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AlquilerService {
    @Autowired
    AlquilerRepository alquilerRepository;

    public List<AlquilerModel> getAlquileres(){
        return alquilerRepository.findAll();
    }
}
