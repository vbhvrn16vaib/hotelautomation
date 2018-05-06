package com.hotelautomation.service;

import com.hotelautomation.dto.HotelAddRequest;
import com.hotelautomation.entities.Hotel;

public interface HotelRegistrationService {

	Hotel addHotel(HotelAddRequest hotelAddRequest);

	Boolean removeHotel(int hotelId);

	Boolean editHotel(int hotelId, HotelAddRequest updatedHotelRequest);
}
