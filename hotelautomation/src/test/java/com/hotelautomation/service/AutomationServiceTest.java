package com.hotelautomation.service;

import com.hotelautomation.dto.HotelAddRequest;
import com.hotelautomation.dto.SensorRequest;
import com.hotelautomation.entities.Hotel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AutomationServiceTest {

	private HotelRegistrationService hotelRegistrationService = new HotelRegistrationServiceImpl();

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void defaultOutput() {

		//given
		HotelAddRequest hotelAddRequest = new HotelAddRequest(2, 1, 2);
		Hotel hotel = hotelRegistrationService.addHotel(hotelAddRequest);
		AutomationService automationService = new AutomationServiceImpl(hotel);

		//when
		Hotel response = automationService.defaultOutput();

		//then
		Assert.assertEquals(response.getFloors().size(), 2);
	}

	@Test
	public void motionDetectedInCorridor1OfFloor1() {

		//given
		HotelAddRequest hotelAddRequest = new HotelAddRequest(2, 1, 2);
		Hotel hotel = hotelRegistrationService.addHotel(hotelAddRequest);
		AutomationService automationService = new AutomationServiceImpl(hotel);

		SensorRequest sensorRequest = new SensorRequest(1, 1);

		//when
		automationService.sensorInput(sensorRequest);
		Hotel response = automationService.defaultOutput();
		//then
		Assert.assertEquals(response.getFloors().size(), 2);
	}

	@Test
	public void motionDetectedInCorridor2OfFloor1() {

		//given
		HotelAddRequest hotelAddRequest = new HotelAddRequest(2, 1, 2);
		Hotel hotel = hotelRegistrationService.addHotel(hotelAddRequest);
		AutomationService automationService = new AutomationServiceImpl(hotel);

		SensorRequest sensorRequest = new SensorRequest(1, 2);

		//when
		automationService.sensorInput(sensorRequest);
		Hotel response = automationService.defaultOutput();

		//then
		Assert.assertEquals(response.getFloors().size(), 2);
	}

	@Test
	public void motionDetectedInFloor1WithMinuteIdeal() {

		//given
		HotelAddRequest hotelAddRequest = new HotelAddRequest(2, 1, 2);
		Hotel hotel = hotelRegistrationService.addHotel(hotelAddRequest);
		AutomationService automationService = new AutomationServiceImpl(hotel);

		SensorRequest sensorRequest1 = new SensorRequest(1, 2);
		SensorRequest sensorRequest2 = new SensorRequest(1, null, 1);

		//when
		automationService.sensorInput(sensorRequest1);
		Hotel response1 = automationService.defaultOutput();
		Assert.assertFalse(response1.getFloors().get(0).getSubCorridors().get(0).getAc());

		automationService.sensorInput(sensorRequest2);
		Hotel response = automationService.defaultOutput();
		Assert.assertTrue(response.getFloors().get(0).getSubCorridors().get(0).getAc());

		//then
		Assert.assertEquals(response.getFloors().size(), 2);
	}

	@Test
	public void motionDetectedInFloor2WithMinuteIdeal() {

		//given
		HotelAddRequest hotelAddRequest = new HotelAddRequest(2, 1, 2);
		Hotel hotel = hotelRegistrationService.addHotel(hotelAddRequest);
		AutomationService automationService = new AutomationServiceImpl(hotel);

		SensorRequest sensorRequest = new SensorRequest(1, null, 1);

		//when
		automationService.sensorInput(sensorRequest);
		Hotel response = automationService.defaultOutput();

		//then
		Assert.assertEquals(response.getFloors().size(), 2);
	}
}