package com.vehicle;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	

	Vehicle findByVIN(String vin);
	
	Vehicle findByMake(String make);
	
	Vehicle findByModel(String model);
	
	Page<Vehicle> findAllByMake(String make,Pageable page);
	
	Page<Vehicle> findAllByMakeAndModel(String make,String model,Pageable page);
	
	Page<Vehicle> findAllByMakeOrModel(String make,String model,Pageable page);
	
	
	
	@Transactional
	@Modifying
	@Query(value="delete from Vehicle where vin = :vin")
	void deleteByVIN(@Param("vin") String vin);
	
	@Query(value="select * from Vehicle u where u.make = :make or u.model = :model order by :orderBy :order" ,nativeQuery=true)
	  List<Vehicle> findByMakeOrModel(@Param("make") String make,
	                                  @Param("model") String model,
									  @Param("order") String orderBy,
								      @Param("orderBy") String order)
	  ;
	//@Query(value="select * from Vehicle u order by :orderBy :order" ,nativeQuery=true)
	//List<Vehicle> findAll(String orderBy, String order);
}