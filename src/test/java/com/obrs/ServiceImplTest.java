package com.obrs;

 

import static org.junit.jupiter.api.Assertions.*;

 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

 

import com.obrs.entity.Bus;
import com.obrs.exception.BusNotFoundException;
import com.obrs.repository.BusRepository;
import com.obrs.service.BusServiceImpl;

 

import static org.mockito.Mockito.*;
    import java.util.Optional;
    import java.util.List;
    import java.util.ArrayList;

 

    public class ServiceImplTest {

 

        @InjectMocks
        private BusServiceImpl busService;
        
        @Mock
        private BusRepository busRepository;
        

 

        @BeforeEach
        public void setUp() {
            MockitoAnnotations.initMocks(this);
        }

 

        @Test
        public void testAddBus() {
            Bus busToAdd = new Bus(); // Create a sample Bus object
            when(busRepository.save(busToAdd)).thenReturn(busToAdd);

 

            Bus addedBus = busService.addBus(busToAdd);

 

            assertEquals(busToAdd, addedBus);
        }

 
		/*
		 * @Test public void testUpdateBus() { Bus busToUpdate = new Bus(); // Create a
		 * sample Bus object
		 * when(busRepository.save(busToUpdate)).thenReturn(busToUpdate);
		 * 
		 * 
		 * 
		 * Bus updatedBus = busService.updateBus(1L, busToUpdate);
		 * 
		 * 
		 * 
		 * assertEquals(busToUpdate, updatedBus); }
		 */

 

        

 

        @Test
        public void testDeleteBusById_NonExistingBus() {
            Long busIdToDelete = 1L;
            when(busRepository.findById(busIdToDelete)).thenReturn(Optional.empty());

 

            assertThrows(BusNotFoundException.class, () -> busService.deleteBusById(busIdToDelete));
        }

        @Test
        public void testDeleteBusByIdNotFound() {
            Long busIdToDelete = 1L;
            when(busRepository.findById(busIdToDelete)).thenReturn(Optional.empty());

            assertThrows(BusNotFoundException.class, () -> busService.deleteBusById(busIdToDelete));
            verify(busRepository, never()).deleteById(busIdToDelete);
        }
 

        @Test
        public void testGetBusById_ExistingBus() {
            Long busIdToRetrieve = 1L;
            Bus existingBus = new Bus();
            when(busRepository.findById(busIdToRetrieve)).thenReturn(Optional.of(existingBus));

 

            Optional<Bus> retrievedBus = busService.getBusById(busIdToRetrieve);

 

            assertTrue(retrievedBus.isPresent());
            assertEquals(existingBus, retrievedBus.get());
        }

 

        @Test
        public void testGetBusById_NonExistingBus() {
            Long busIdToRetrieve = 1L;
            when(busRepository.findById(busIdToRetrieve)).thenReturn(Optional.empty());

 

            Optional<Bus> retrievedBus = busService.getBusById(busIdToRetrieve);

 

            assertFalse(retrievedBus.isPresent());
        }

 

        @Test
        public void testViewAllBuses() {
            List<Bus> buses = new ArrayList<>();
            buses.add(new Bus());
            buses.add(new Bus());
            when(busRepository.findAll()).thenReturn(buses);

 

            List<Bus> allBuses = busService.viewAllBuses();

 

           assertEquals(buses.size(), allBuses.size());
        }
        @Test
        public void testExploreBuses() {
            String startLocation = "Start";
            String endLocation = "End";
            List<Bus> expectedBuses = new ArrayList<>();
            // Add expected Bus objects to the list
            when(busRepository.findByStartLocationAndEndLocation(startLocation, endLocation)).thenReturn(expectedBuses);

            List<Bus> buses = busService.exploreBuses(startLocation, endLocation);

            assertNotNull(buses);
            assertEquals(expectedBuses, buses);
        }
        

        











    }


