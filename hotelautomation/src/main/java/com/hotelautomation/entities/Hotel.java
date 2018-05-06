package com.hotelautomation.entities;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	private Integer hotelId;
	private List<Floor> floors;

	public Hotel(List<Floor> floors) {
		this.floors = floors;
	}

	public void addFloors(Floor floor) {
		if (floors == null) {
			floors = new ArrayList<>();
		}
		floors.add(floor);
	}

	public List<Floor> getFloors() {
		return floors;
	}

	@Override
	public String toString() {
		return "Hotel{" +
			   "hotelId='" + hotelId + '\'' +
			   ", floors=" + floors +
			   '}';
	}
}
