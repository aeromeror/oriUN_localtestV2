package com.oriun.oriun.Repositories;
import com.oriun.oriun.Models.LocationsportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//@Repository
public interface LocationsportRepository extends JpaRepository<LocationsportModel,String>{
    
}
