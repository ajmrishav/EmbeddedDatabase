package com.embeddb.embeddb.PlayerDetailRepository;

import com.embeddb.embeddb.Entity.PlayerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PlayerDetailRepository extends JpaRepository<PlayerDetail,Integer> {

    List<PlayerDetail> findBydateOfBirthLessThan(Date date);

    // For Greater than findBySalaryGreaterThan(int salary);

    //

}
