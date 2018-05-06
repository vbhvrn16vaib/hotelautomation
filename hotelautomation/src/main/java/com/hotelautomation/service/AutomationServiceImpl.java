package com.hotelautomation.service;

import com.hotelautomation.dto.SensorRequest;
import com.hotelautomation.entities.Corridor;
import com.hotelautomation.entities.Floor;
import com.hotelautomation.entities.Hotel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutomationServiceImpl implements AutomationService {
	private Hotel hotel;
	private Logger log = LoggerFactory.getLogger(AutomationServiceImpl.class);

	public AutomationServiceImpl(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public Hotel defaultOutput() {
		log.info("Hotel details for sensor {} ", hotel.toString());
		return hotel;
	}

	@Override
	public void sensorInput(SensorRequest sensorRequest) {

		if (sensorRequest.getFloorId() < 0 || sensorRequest.getFloorId() > hotel.getFloors().size()) {
			log.error("Not good input !!");
			//TODO we can add our own custom excpetions
			throw new RuntimeException("This is invalid floor please check with admin to fix sensor !!");
		}

		if (sensorRequest.isMovement()) {
			log.info("Movement noticed in floor {}, corridor {} ", sensorRequest.getFloorId(), sensorRequest.getCorridorId());
			movementLogic(sensorRequest);
		} else if (sensorRequest.getIdealTime() >= 1) {
			log.info("No movement noticed for 1 min on floor {} ", sensorRequest.getFloorId());
			reset(sensorRequest.getFloorId()-1);
		}

	}

	private void reset(Integer floorId) {
		hotel.getFloors().get(floorId)
				.getSubCorridors()
				.forEach(corridor -> corridor.setDefault(corridor));
	}

	private void movementLogic(SensorRequest sensorRequest) {
		int corridorId = sensorRequest.getCorridorId() - 1;
		Floor floor = hotel.getFloors().get(sensorRequest.getFloorId() - 1);
		Corridor corridor = floor.getSubCorridors().get(corridorId);

		//Switch ON the light for movement
		log.info("Switching ON light for corridor {}", corridorId + 1);
		corridor.setLight(Boolean.TRUE);

		//Switch OFF the AC
		int corridorAcOff = corridorId;
		if (floor.getSubCorridors().size() > 1) {
			if (corridorId - 1 >= 0) {
				corridorAcOff = corridorId - 1;
			} else {
				corridorAcOff = corridorId + 1;
			}
		}
		log.info("Switching off AC for corridor {}", corridorAcOff + 1);
		floor.getSubCorridors().get(corridorAcOff).setAc(Boolean.FALSE);
	}
}
