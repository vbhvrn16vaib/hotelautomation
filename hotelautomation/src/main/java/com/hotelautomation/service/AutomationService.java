package com.hotelautomation.service;

import com.hotelautomation.dto.SensorRequest;
import com.hotelautomation.entities.Hotel;

public interface AutomationService {

	Hotel defaultOutput();

	void sensorInput(SensorRequest sensorRequest);
}
