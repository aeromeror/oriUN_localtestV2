package com.oriun.oriun.Repositories;
import com.oriun.oriun.Models.Location_sportsPK;
import com.oriun.oriun.Models.Location_sport_sportsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//@Repository
public interface Location_sport_sportsRepository extends JpaRepository<Location_sport_sportsModel,Location_sportsPK>{
    
}