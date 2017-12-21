package net.skhu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;




@Data
@ToString(exclude= {"district"})
@EqualsAndHashCode(exclude= {"district"})
@Entity
public class City{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Integer population;
    String name;
    
    @ManyToOne
    @JoinColumn(name="districtId")
    District district;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
    
    
}