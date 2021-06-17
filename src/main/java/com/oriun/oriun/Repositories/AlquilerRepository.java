package com.oriun.oriun.Repositories;

import com.oriun.oriun.Models.AlqElem;
import com.oriun.oriun.Models.AlquilerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface AlquilerRepository extends JpaRepository<AlquilerModel,Integer> {
    @Query(value = "SELECT rent_date, id_rent,user_name,element.* FROM oriun_prueba.alquiler LEFT JOIN element ON alquiler.id_element=element.id_element WHERE name_location=?1 order by rent_date",
            nativeQuery = true)
    List<AlqElem> LAlquilerplus(String nloc);
    @Query(value = "SELECT * FROM oriun_prueba.alquiler WHERE id_element=?1 AND rent_date=?2",
            nativeQuery = true)
    List<AlquilerModel> LAfechaElemento(int ide, Date rdate);
}
