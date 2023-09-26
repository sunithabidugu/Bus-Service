package com.obrs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.obrs.entity.Bus;


	@Repository
	public interface BusRepository extends JpaRepository<Bus,Long>{

		List<Bus> findByStartLocationAndEndLocation(String startLocation, String endLocation);
		

	


}