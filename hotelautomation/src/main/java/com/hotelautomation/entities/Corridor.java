package com.hotelautomation.entities;

public class Corridor {
	private Integer corridorId;
	private Boolean light;
	private Boolean ac;

	public Corridor(Integer corridorId, Boolean light, Boolean ac) {
		this.corridorId = corridorId;
		this.light = light;
		this.ac = ac;
	}

	public Boolean getLight() {
		return light;
	}

	public void setLight(Boolean light) {
		this.light = light;
	}

	public Boolean getAc() {
		return ac;
	}

	public void setAc(Boolean ac) {
		this.ac = ac;
	}

	public void setDefault(Corridor corridor){
		corridor.ac = Boolean.TRUE;
		corridor.light = Boolean.FALSE;
	}

	@Override
	public String toString() {
		return "Corridor{" +
			   "corridorId=" + corridorId +
			   ", light=" + light +
			   ", ac=" + ac +
			   '}';
	}
}
