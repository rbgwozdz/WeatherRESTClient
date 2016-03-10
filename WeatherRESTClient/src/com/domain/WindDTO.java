package com.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WindDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long weatherId;
	private int speed;
    private int deg;
    
	public long getId() {
		return id;
	}
	public long getWeatherId() {
		return weatherId;
	}
	public void setWeatherId(long weatherId) {
		this.weatherId = weatherId;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDeg() {
		return deg;
	}
	public void setDeg(int deg) {
		this.deg = deg;
	}
    
    
}
