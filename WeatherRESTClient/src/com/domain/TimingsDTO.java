package com.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TimingsDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long weatherId;
	private int sunrise;
	private int sunset;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getWeatherId() {
		return weatherId;
	}
	public void setWeatherId(long weatherId) {
		this.weatherId = weatherId;
	}
	public int getSunrise() {
		return sunrise;
	}
	public void setSunrise(int sunrise) {
		this.sunrise = sunrise;
	}
	public int getSunset() {
		return sunset;
	}
	public void setSunset(int sunset) {
		this.sunset = sunset;
	}
	
	
}
