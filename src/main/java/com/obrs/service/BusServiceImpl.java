package com.obrs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obrs.entity.Bus;
import com.obrs.exception.BusNotFoundException;
import com.obrs.repository.BusRepository;
import javax.persistence.EntityNotFoundException;
import com.obrs.service.BusService;


@Service
public class BusServiceImpl implements BusService{
		
		@Autowired 
		private BusRepository busRepository;

	
		public Bus addBus(Bus bus) {
			busRepository.save (bus);

			return bus;
			
		}
				@Override
		public String deleteBusById(Long busId) {
			Optional<Bus> bus = busRepository.findById(busId);
			String messsage =null;
			if(bus.isPresent()) {
				busRepository.deleteById(busId);
				messsage = new String("bus deleted succssfully");
			}
			else {
				throw new BusNotFoundException("no such Bus");
			}
			// TODO Auto-generated method stub
			return messsage;
			
		}

		@Override
		public Optional<Bus> getBusById(Long busId) {
			// TODO Auto-generated method stub
			 return busRepository.findById(busId);
		}

	
		public List<Bus> viewAllBuses() {
			return busRepository.findAll();
			// TODO Auto-generated method stub
		
		}
		
		public List<Bus> exploreBuses(String startLocation, String endLocation) {

            List<Bus> entities = busRepository.findByStartLocationAndEndLocation(startLocation, endLocation);

            return entities;

        }
		@Override
		public Bus updateBus(Long busId, Bus bus) {
			

	            Optional<Bus> existingBusOptional = busRepository.findById(bus.getBusId());

	 

	            if (existingBusOptional.isPresent()) {

	                Bus existingBus = existingBusOptional.get();

	 

	                // Update the properties of the existing bus with the values from the updatedData

	                existingBus.setStartLocation(bus.getStartLocation());

	                existingBus.setEndLocation(bus.getEndLocation());

	                existingBus.setCapacity(bus.getCapacity());

	                existingBus.setArrivalTime(bus.getArrivalTime());

	                existingBus.setDepartureTime(bus.getDepartureTime());

	 

	                // Save the updated bus to the repository

	                Bus savedBus = busRepository.save(existingBus);

	 

	                return savedBus;

	            } else {

	                throw new EntityNotFoundException("Bus with ID " + bus.getBusId() + " not found");

	            }

	        }


		
}
	