package com.oriun.oriun.Repositories;

import java.util.List;

import com.oriun.oriun.Models.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EventRepository extends JpaRepository<EventModel,Integer>{
    @Query(value = "SELECT * FROM oriun_prueba.event  WHERE other_sport IS NOT NULL",
       nativeQuery = true)
    List<EventModel>findByOthers();
    @Query(value = "SELECT other_sport FROM oriun_prueba.event  WHERE other_sport IS NOT NULL ",
       nativeQuery = true)
    List<String>findByOtherSports();
}