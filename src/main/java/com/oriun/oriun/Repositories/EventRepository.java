package com.oriun.oriun.Repositories;

import java.util.List;
import java.util.ArrayList;

import com.oriun.oriun.Models.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
    @Query(value = "SELECT other_sport,COUNT(*) FROM oriun_prueba.event  WHERE other_sport IS NOT NULL GROUP BY other_sport",
       nativeQuery = true)
    List<Object[]>findByOtherSportscount();
    @Query(value = "SELECT * FROM oriun_prueba.event  WHERE other_sport = ?1 ",
       nativeQuery = true)
    List<EventModel>findByOther_Sport(String other_sport);
    @Query(value = "SELECT * FROM oriun_prueba.event  WHERE event_init>current_date() OR (event_init=current_date() AND event_init_hour>current_time())",
            nativeQuery = true)
    ArrayList<EventModel>findCurrent();
    @Modifying
    @Query(value = "UPDATE oriun_prueba.event SET name_sport = ?1, other_sport= NULL WHERE other_sport = ?1"
    , nativeQuery = true)
    void updateEventSport(String new_sport);
    @Query(value = "SELECT oriun_prueba.event.* FROM oriun_prueba.user_event inner join oriun_prueba.event ON oriun_prueba.event.id_event = oriun_prueba.user_event.id_event where oriun_prueba.user_event.user_name=?1 ",
       nativeQuery = true)
    List<EventModel>findUserEvents(String user_name);
    /*@Query(value = "SELECT * FROM oriun_prueba.event  WHERE event_title= "+event_t,
            nativeQuery = true)
    List<String>findByEvent_title(String event_t);*/
}