package com.obrs.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;


import lombok.Data;
@Data
@Entity
@Table(name="bus")
public class Bus {
	
	@Id
	@NotNull (message = "Bus ID is required")
	private long busId;

	@NotNull (message = "Start location is required")
	private String startLocation;
    
//	
	@NotNull (message = "End location is required")
    private String endLocation;

    @Positive(message = "Capacity must be a positive number")
    private int capacity;
 
    @NotNull(message = "Arrival time is required")
    @FutureOrPresent(message = "Arrival time must be in the future")
    private LocalDateTime arrivalTime;

    @NotNull(message = "Departure time is required")
    @FutureOrPresent(message = "Departure time must be in the future")
    private LocalDateTime departureTime;
    
    
	public Bus(long busId, String startLocation, String endLocation, int capacity, LocalDateTime arrivalTime,
			LocalDateTime departureTime) {
		super();
		this.busId = busId;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.capacity = capacity;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	public Bus() {
		super();
	}
	
	
	public long getBusId() {
		return busId;
	}
	public void setBusId(long busId) {
		this.busId = busId;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	public String getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", startLocation=" + startLocation + ", endLocation=" + endLocation
				+ ", capacity=" + capacity + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + "]";
	}
	
	
}