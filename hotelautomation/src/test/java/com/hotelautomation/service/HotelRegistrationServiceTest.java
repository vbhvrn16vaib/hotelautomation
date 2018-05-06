package com.hotelautomation.service;

import com.hotelautomation.dto.HotelAddRequest;
import com.hotelautomation.entities.Hotel;
import java.util.Objects;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelRegistrationServiceTest {

	private HotelRegistrationService hotelRegistrationService = new HotelRegistrationServiceImpl();

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void addHotelWith1() {
		//given
		HotelAddRequest hotelAddRequest = new HotelAddRequest(1, 1, 1);

		//when
		Hotel hotel = hotelRegistrationService.addHotel(hotelAddRequest);

		//then
		Assert.assertTrue(Objects.nonNull(hotel.getFloors()));
	}

	@Test
	public void addHotelWith2() {
		//given
		HotelAddRequest hotelAddRequest = new HotelAddRequest(2, 1, 2);

		//when
		Hotel hotel = hotelRegistrationService.addHotel(hotelAddRequest);

		//then
		Assert.assertTrue(Objects.nonNull(hotel.getFloors()));
		Assert.assertEquals(2, hotel.getFloors().size());
	}
}