package com.hotelautomation.dto;

public class SensorRequest {
	private Integer floorId;
	private Integer corridorId;
	private Integer idealTime;
	private Boolean isMovement;

	public SensorRequest() {
	}

	public SensorRequest(Integer floorId, Integer corridorId, Integer idealTime, Boolean isMovement) {
		this.floorId = floorId;
		this.corridorId = corridorId;
		this.idealTime = idealTime;
		this.isMovement = isMovement;
	}

	public SensorRequest(Integer floorId, Integer corridorId) {
		this(floorId, corridorId, 0, Boolean.TRUE);
	}

	public SensorRequest(Integer floorId, Integer corridorId, Integer idealTime) {
		this(floorId, corridorId, idealTime, Boolean.FALSE);
	}

	public Integer getFloorId() {
		return floorId;
	}

	public Integer getCorridorId() {
		return corridorId;
	}

	public Integer getIdealTime() {
		return idealTime;
	}

	public Boolean isMovement() {
		return isMovement;
	}
}
