package com.hotelautomation.service;

import com.hotelautomation.dto.HotelAddRequest;
import com.hotelautomation.entities.Floor;
import com.hotelautomation.entities.Hotel;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HotelRegistrationServiceImpl implements HotelRegistrationService {

	private Logger log = LoggerFactory.getLogger(HotelRegistrationServiceImpl.class);

	@Override
	public Hotel addHotel(HotelAddRequest hotelAddRequest) {

		List<Floor> floors = IntStream.range(0, hotelAddRequest.getNoOfFloors()).mapToObj(
				floorNumber -> {
					Floor floor = new Floor(floorNumber + 1);
					createMainCorridor(floor, hotelAddRequest.getNoOfMainCorridor());
					createSubCorridor(floor, hotelAddRequest.getNoOfFloors());
					log.info("Created floor {} Successfully : {} ", floorNumber+1, floor.toString());
					return floor;
				}
		).collect(Collectors.toList());

		return new Hotel(floors);
	}

	@Override
	public Boolean removeHotel(int hotelId) {
		throw new UnsupportedOperationException("This is Not yet implemented !!!");
	}

	@Override
	public Boolean editHotel(int hotelId, HotelAddRequest updatedHotelRequest) {
		throw new UnsupportedOperationException("This is Not yet implemented !!!");
	}


	private void createSubCorridor(Floor floor, Integer noOfSubCorridor) {
		IntStream.range(0, noOfSubCorridor).map(x -> x + 1).forEach(floor::addSubCorridors);
	}

	private void createMainCorridor(Floor floor, Integer noOfMainCorridor) {
		IntStream.range(0, noOfMainCorridor).map(x -> x + 1).forEach(floor::addMainCorridors);
	}
}
