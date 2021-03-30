package com.oriun.oriun.Repositories;
import com.oriun.oriun.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//@Repository
public interface UserRepository extends JpaRepository<UserModel,String>{
  //@Query("select u from user u where u.USER_NAME = ?1")
  //UserModel findByUsername(String username);
}
