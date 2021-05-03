package com.oriun.oriun.Repositories;

import com.oriun.oriun.Models.NotificationModel;
import java.time.LocalDate;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.sql.Date;

import java.util.List;
@Repository
public interface NotificationRepository extends JpaRepository<NotificationModel,Integer> {
    @Query(value = "SELECT * FROM oriun_prueba.notifications  WHERE NAME_SPORT = ?1 ",
       nativeQuery = true)
    List<NotificationModel>findByNAME_SPORT(String sport);

    @Query(value = "SELECT * FROM oriun_prueba.notifications  WHERE NOTIFICATION_DATE = ?1 ",
       nativeQuery = true)
    List<NotificationModel>findByNOTIFICATION_DATE(Date date);

    @Query(value = "SELECT * FROM oriun_prueba.notifications  WHERE NOTIFICATION_DATE >= ?1 ", 
       nativeQuery = true)
    List<NotificationModel>findByAVTIVE_DATE(Date date);
    
    @Query(value = "SELECT * FROM oriun_prueba.notifications  WHERE ID_EVENT = ?1 ",
    nativeQuery = true)
    List<NotificationModel>findByEVENT(int id_event);
    
    @Modifying
    @Query(value = "UPDATE oriun_prueba.notifications SET name_sport = ?1 WHERE id_event = ?2"
    , nativeQuery = true)
    void updateNotificationSport(String new_sport, int id_event);
  //@Query("select u from notifications u where u.USER_NAME = ?1")
  //NotificationModel findByUsername(String username);
    
}
