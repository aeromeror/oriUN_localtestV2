package com.oriun.oriun.Repositories;
import com.oriun.oriun.Models.ElementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public interface ElementRepository extends JpaRepository<ElementModel,Integer>{
    @Modifying
    @Query(value = "UPDATE oriun_prueba.element SET AVAILABLE =NOT AVAILABLE WHERE ID_ELEMENT= ?1",
            nativeQuery = true)
    int changeAvailablebyID(int id);
    @Modifying
    @Query(value = "UPDATE oriun_prueba.element SET AVAILABLE =?2,DESCRIPTION=?3,ELEMENT_NAME=?4,NAME_LOCATION=?5,NAME_SPORT=?6,ElEMENT_IMAGE=?7 WHERE ID_ELEMENT= ?1",
            nativeQuery = true)
    int updatebyID(int id_element,boolean available,String description,
                   String element_name,String name_location,String name_sport,byte[] im);
    @Modifying
    @Query(value = "UPDATE oriun_prueba.element SET AVAILABLE =?2,DESCRIPTION=?3,NAME_LOCATION=?4,NAME_SPORT=?5,ElEMENT_IMAGE=?6 WHERE ID_ELEMENT= ?1",
            nativeQuery = true)
    int updatebyIDnoname(int id_element,boolean available,String description,String name_location,String name_sport,byte[] im);
    @Query(value = "SELECT * FROM oriun_prueba.element WHERE NAME_LOCATION=?1",
            nativeQuery = true)
    ArrayList<ElementModel> findbyLocation(String name_location);
    @Query(value = "SELECT * FROM oriun_prueba.element WHERE NAME_SPORT=?1",
            nativeQuery = true)
    ArrayList<ElementModel> findbySport(String name_sport);
    @Query(value = "SELECT * FROM oriun_prueba.element WHERE AVAILABLE=TRUE",
            nativeQuery = true)
    ArrayList<ElementModel> findAvailables();

    @Modifying
    @Query(value = "DELETE from oriun_prueba.element WHERE NAME_LOCATION=?1",
            nativeQuery = true)
    int deleteElementsinLSibu(String name);
    //public List<ElementModel>findByNAME_SPORT();
    @Modifying
    @Query(value = "UPDATE oriun_prueba.element SET ElEMENT_IMAGE=?2 WHERE ID_ELEMENT= ?1",
            nativeQuery = true)
    int updateimg(int id, byte[] im);
}
