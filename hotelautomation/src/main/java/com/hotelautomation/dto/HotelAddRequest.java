package com.hotelautomation.dto;

import java.util.Objects;

public class HotelAddRequest {
	private Integer noOfFloors;
	private Integer noOfMainCorridor;
	private Integer noOfSubCorridor;


	public HotelAddRequest() {
	}

	public HotelAddRequest(Integer noOfFloors, Integer noOfMainCorridor, Integer noOfSubCorridor) {
		this.noOfFloors = noOfFloors;
		this.noOfMainCorridor = noOfMainCorridor;
		this.noOfSubCorridor = noOfSubCorridor;
	}

	public Integer getNoOfFloors() {
		return noOfFloors;
	}

	public Integer getNoOfMainCorridor() {
		return noOfMainCorridor;
	}

	public Integer getNoOfSubCorridor() {
		return noOfSubCorridor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		HotelAddRequest that = (HotelAddRequest) o;
		return Objects.equals(noOfFloors, that.noOfFloors) &&
			   Objects.equals(noOfMainCorridor, that.noOfMainCorridor) &&
			   Objects.equals(noOfSubCorridor, that.noOfSubCorridor);
	}

	@Override
	public int hashCode() {

		return Objects.hash(noOfFloors, noOfMainCorridor, noOfSubCorridor);
	}

}
