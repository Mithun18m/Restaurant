package com.mindtree.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Restaurant 
{
	@Id
	@Column(name="id",unique = true, length = 100)
	private String id;
	
	private String name;
	private String cusine;
	private int distance;
	private int budget;
	private double rating;
	private String location;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCusine() {
		return cusine;
	}
	public void setCusine(String cusine) {
		this.cusine = cusine;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Restaurant(String id, String name, String cusine, int distance, int budget, double rating, String location) {
		super();
		this.id = id;
		this.name = name;
		this.cusine = cusine;
		this.distance = distance;
		this.budget = budget;
		this.rating = rating;
		this.location = location;
	}
	public Restaurant() {
		super();
	}
	
	

}
