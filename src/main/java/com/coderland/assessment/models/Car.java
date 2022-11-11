package com.coderland.assessment.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {
	
	@Id
	@GeneratedValue
	private Long id;
	private String brand;
	private String model;
	private Integer maximum_speed;
	private double engine;
	private String features;
	private Date launch_date;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getMaximum_speed() {
		return maximum_speed;
	}
	public void setMaximum_speed(Integer maximum_speed) {
		this.maximum_speed = maximum_speed;
	}
	public double getEngine() {
		return engine;
	}
	public void setEngine(double engine) {
		this.engine = engine;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public Date getLaunch_date() {
		return launch_date;
	}
	public void setLaunch_date(Date launch_date) {
		this.launch_date = launch_date;
	}
	
	
}
