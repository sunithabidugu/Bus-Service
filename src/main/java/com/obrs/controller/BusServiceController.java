package com.obrs.controller;



import com.obrs.entity.Bus;
import com.obrs.service.BusService;
import com.obrs.service.BusServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BusServiceController {

    @Autowired
    private BusServiceImpl busServiceImpl;

    @PostMapping("/add")
    public ResponseEntity<Bus> addBus(@RequestBody Bus bus) {
        Bus addedBus = busServiceImpl.addBus(bus);
        return new ResponseEntity<>(addedBus, HttpStatus.CREATED);
    }

    @PutMapping("/update/{busId}")

    public ResponseEntity<Bus> updateBus(@PathVariable Long busId,@RequestBody Bus bus) {
        try {
            Bus updated = busServiceImpl.updateBus(busId, bus);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{busId}")
    public ResponseEntity<String> deleteBusById(@PathVariable Long busId) {
        String message = busServiceImpl.deleteBusById(busId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/getBusById/{busId}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long busId) {
        Optional<Bus> bus = busServiceImpl.getBusById(busId);
        return bus.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Bus>> viewAllBuses() {
        List<Bus> buses = busServiceImpl.viewAllBuses();
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }
    @GetMapping("/explore-buses/{startLocation}/{endLocation}")

    public ResponseEntity<List<Bus>> exploreBuses(

            @PathVariable("startLocation") String startLocation,

            @PathVariable("endLocation") String endLocation) {

        List<Bus> buses = busServiceImpl.exploreBuses(startLocation, endLocation);

        return ResponseEntity.ok(buses);

    }
}
