package com.oriun.oriun.Repositories;

import com.oriun.oriun.Models.NotificationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface NotificationRepository extends JpaRepository<NotificationModel,Integer> {
    @Query(value = "SELECT * FROM oriun_prueba.notifications  WHERE USER_NAME = ?1 ",
       nativeQuery = true)
    List<NotificationModel>findByUSER_NAME(String user_name);

  //@Query("select u from notifications u where u.USER_NAME = ?1")
  //NotificationModel findByUsername(String username);
    
}
