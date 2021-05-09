package com.oriun.oriun.Repositories;
import com.oriun.oriun.Models.ConfirmationTokenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationTokenModel,Integer>{
    @Query(value = "SELECT * FROM oriun_prueba.confirmation_token  WHERE confirmation_token = ?1 ",
    nativeQuery = true)
    ConfirmationTokenModel findByConfirmationToken(String confirmationToken);
}
