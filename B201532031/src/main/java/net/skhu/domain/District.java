package net.skhu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;




@Data
@ToString(exclude= {"cities"})
@EqualsAndHashCode(exclude= {"cities"})

@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    @Column(name="districtName")
    String name;
    
    @JsonIgnore
    @OneToMany(mappedBy="district")
    List<City> cities;
    
    
   
}