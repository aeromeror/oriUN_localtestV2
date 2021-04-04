package com.oriun.oriun.Repositories;
import com.oriun.oriun.Models.User_sportsModel;
import com.oriun.oriun.Models.User_sportsPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//@Repository
public interface User_sportsRepository extends JpaRepository<User_sportsModel,User_sportsPK>{
  
}