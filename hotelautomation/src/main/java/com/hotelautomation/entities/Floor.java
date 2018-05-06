package com.hotelautomation.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Floor {
	private Integer floorId;
	private List<Corridor> mainCorridors;
	private List<Corridor> subCorridors;

	public Floor(Integer floorId) {
		this.floorId = floorId;
	}

	public void addMainCorridors(Integer corridorId) {
		if (Objects.isNull(mainCorridors)) {
			mainCorridors = new ArrayList<>();
		}
		Corridor mainCorridor = new Corridor(corridorId, Boolean.TRUE, Boolean.TRUE);
		mainCorridors.add(mainCorridor);
	}

	public void addSubCorridors(Integer corridorId) {
		if (Objects.isNull(subCorridors)) {
			subCorridors = new ArrayList<>();
		}
		Corridor subCorridor = new Corridor(corridorId, Boolean.FALSE, Boolean.TRUE);
		subCorridors.add(subCorridor);
	}

	public List<Corridor> getSubCorridors() {
		return subCorridors;
	}

	@Override
	public String toString() {
		return "Floor{" +
			   "floorId=" + floorId +
			   ", mainCorridors=" + mainCorridors +
			   ", subCorridors=" + subCorridors +
			   '}';
	}
}
