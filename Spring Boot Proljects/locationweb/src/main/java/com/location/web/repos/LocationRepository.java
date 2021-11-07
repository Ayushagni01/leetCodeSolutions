package com.location.web.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.location.web.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
	

@Query(value ="select type,count(type) from location group by type", nativeQuery=true)
public  List<Object[]> findTypeAndTypeCount();
	
}
//jpql