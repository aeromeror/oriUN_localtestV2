package com.oriun.oriun.Repositories;

import java.util.List;

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

    @Modifying
    @Query(value = "UPDATE oriun_prueba.event SET name_sport = ?1, other_sport= NULL WHERE other_sport = ?1"
    , nativeQuery = true)
    void updateEventSport(String new_sport);
    @Query(value = "SELECT oriun_prueba.event.id_event,oriun_prueba.event.user_name,name_loc_sport,name_sport,event_description,event_init,event_end,capacity,other_sport,event_init_hour,event_finish_hour,event_title,creation_date FROM oriun_prueba.user_event inner join oriun_prueba.event ON oriun_prueba.event.id_event = oriun_prueba.user_event.id_event where oriun_prueba.user_event.user_name=?1 ",
       nativeQuery = true)
    List<EventModel>findUserEvents(String user_name);
    /*@Query(value = "SELECT * FROM oriun_prueba.event  WHERE event_title= "+event_t,
            nativeQuery = true)
    List<String>findByEvent_title(String event_t);*/
}