package com.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CloudsDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long weatherId;
	private int al;

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

	public int getAl() {
		return al;
	}

	public void setAl(int all) {
		this.al = all;
	}
	
}
