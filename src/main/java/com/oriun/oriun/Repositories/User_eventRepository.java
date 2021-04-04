package com.oriun.oriun.Repositories;
import com.oriun.oriun.Models.User_eventModel;
import com.oriun.oriun.Models.User_eventPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//@Repository
public interface User_eventRepository extends JpaRepository<User_eventModel,User_eventPK>{
  
}
