package com.obrs.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
@Data
@NoArgsConstructor
@AllArgsConstructor*/
public class BusServiceDTO {
	private Long busId;
	private String startLocation;
	private String endLocation;
    private int capacity;
	private LocalDateTime arrivalTime;
	private LocalDateTime departureTime;
	public BusServiceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BusServiceDTO(Long busId, String startLocation, String endLocation, int capacity, LocalDateTime arrivalTime,
			LocalDateTime departureTime) {
		super();
		this.busId = busId;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.capacity = capacity;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	public Long getBusId() {
		return busId;
	}
	public void setBusId(Long busId) {
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
	
}