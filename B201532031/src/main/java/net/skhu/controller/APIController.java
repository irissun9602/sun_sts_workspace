package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.City;
import net.skhu.repository.CityRepository;
import net.skhu.domain.District;
import net.skhu.repository.DistrictRepository;

@RestController
@RequestMapping("api")
public class APIController {

    @Autowired CityRepository cityRepository;
    @Autowired DistrictRepository districtRepository;

    @RequestMapping("test1")
    public List<City> city() {
        List<City> list = null;
        list = cityRepository.findByDistrictName("경기도");
    	
    	
    	return list;
    }

    
    @RequestMapping("test2")
    public List<City> queryCity() {
        List<City> list =null;
        list =cityRepository.findCity("경기도");
        return list;
    }
    
    
}