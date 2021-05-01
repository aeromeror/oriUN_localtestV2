package com.oriun.oriun.Repositories;
import com.oriun.oriun.Models.ElementModel;
import com.oriun.oriun.Models.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface ElementRepository extends JpaRepository<ElementModel,Integer>{
    @Modifying
    @Query(value = "UPDATE oriun_prueba.element SET AVAILABLE =NOT AVAILABLE WHERE ID_ELEMENT= ?1",
            nativeQuery = true)
    int changeAvailablebyID(int id);
    @Modifying
    @Query(value = "UPDATE oriun_prueba.element SET AVAILABLE =?2,DESCRIPTION=?3,ELEMENT_NAME=?4,NAME_LOCATION=?5,NAME_SPORT=?6 WHERE ID_ELEMENT= ?1",
            nativeQuery = true)
    int updatebyID(int id_element,boolean available,String description,
                   String element_name,String name_location,String name_sport);
    //public List<ElementModel>findByNAME_SPORT();
}
