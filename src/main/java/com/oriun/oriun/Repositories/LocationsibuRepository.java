package com.oriun.oriun.Repositories;
import com.oriun.oriun.Models.LocationsibuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Blob;

//@Repository
public interface LocationsibuRepository extends JpaRepository<LocationsibuModel,String>{
    @Modifying
    @Query(value = "UPDATE oriun_prueba.locationsibu SET OPEN=?2, IMAGE_LOCATION=?3 WHERE NAME_LOCATION= ?1",
            nativeQuery = true)
    int updatebyID(String name, boolean open, Blob im);
}