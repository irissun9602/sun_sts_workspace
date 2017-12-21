package net.skhu.dto;

import java.util.List;
import java.io.Serializable;

public class District implements Serializable{
	private static final long serialVersionUID =1L;
	
	int id;
	String districtName;
	
	List<City> cities;
	
	
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
}
