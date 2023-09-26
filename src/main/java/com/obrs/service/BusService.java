package com.obrs.service;

import java.util.List;
import java.util.Optional;

import com.obrs.entity.Bus;

public interface BusService {
	public List<Bus> viewAllBuses(); 
	public Bus addBus(Bus bus);
	Bus updateBus(Long busId, Bus bus);
	public String deleteBusById(Long busId);
	public List<Bus> exploreBuses(String startLocation, String endLocation) ;
	Optional<Bus> getBusById(Long busId);
	
	
	
	


}
