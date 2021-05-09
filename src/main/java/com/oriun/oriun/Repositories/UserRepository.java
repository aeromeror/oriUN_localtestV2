package com.oriun.oriun.Repositories;
import java.util.List;

import com.oriun.oriun.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//@Repository
public interface UserRepository extends JpaRepository<UserModel,String>{
  //@Query("select u from user u where u.USER_NAME = ?1")
  //UserModel findByUsername(String username);
  @Query(value = "SELECT * FROM oriun_prueba.user  WHERE EMAIL = ?1 ",
    nativeQuery = true)
    UserModel findByEMAIL(String email);

  @Modifying
  @Query(value = "UPDATE oriun_prueba.user SET ENABLED = 1,WHERE USER_NAME= ?1",
          nativeQuery = true)
  void updateUserState(String user_name);
}
