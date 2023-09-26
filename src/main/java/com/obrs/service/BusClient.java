package com.obrs.service;
	import org.springframework.cloud.openfeign.FeignClient;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	 

	import com.obrs.dto.BusServiceDTO;

	 

	import java.util.List;

	 

	@FeignClient(name = "BUS-SERVICE")
	public interface BusClient {

	 

	    @GetMapping("/api/all")
	    ResponseEntity<List<BusServiceDTO>> viewAllBuses();

	 

	    @PostMapping("/api/add")
	    ResponseEntity<BusServiceDTO> addBus(@RequestBody BusServiceDTO busDTO);

	 

	    @PutMapping("/api/update")
	    ResponseEntity<BusServiceDTO> updateBus(@PathVariable String busId, @RequestBody BusServiceDTO busDTO);

	 

	    @DeleteMapping("/api/delete")
	    ResponseEntity<String> deleteBusById(@PathVariable String busId);

	 

	    @GetMapping("/api/{busId}")
	    ResponseEntity<BusServiceDTO> getBusById(@PathVariable String busId);

	    @GetMapping("/api/explore-buses/{startLocation}/{endLocation}")
	    ResponseEntity<List<BusServiceDTO>> exploreBuses(@PathVariable("startLocation") String startLocation,@PathVariable("endLocation") String endLocation);
	}

	 


