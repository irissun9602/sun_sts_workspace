package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.City;
import net.skhu.dto.District;

import net.skhu.mapper.CityMapper;
import net.skhu.mapper.DistrictMapper;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired CityMapper cityMapper;
    @Autowired DistrictMapper districtMapper;
    

    @RequestMapping("list")
    public String list(Model model) {
        List<City>cities = cityMapper.findAll();
        model.addAttribute("cities", cities);
        return "city/list";
    }
    
    
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
	public String dynamicSQL(Model model) {
		List<City> cities = cityMapper.findAllOrderBy("name");
		model.addAttribute("cities", cities);

		return "city/list";
	}

	static String[] s = new String[] { "name", "districtName", "population DESC" };

	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String dynamicSQL(Model model, @RequestParam("orderIndex") int orderIndex) {

		String order = s[orderIndex];
		List<City> cities = cityMapper.findAllOrderBy(order);
		model.addAttribute("cities", cities);

		return "city/list";
	}

	

	
	
	//create, edit, delete 매퍼
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(Model model) {
		City city = new City();
		List<City> cities = cityMapper.findAllOrderBy("name");
		model.addAttribute("city", city);
		model.addAttribute("cities", cities);
		return "city/edit";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(Model model, City city) {
		cityMapper.insert(city);
		return "redirect:list";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam("id") int id) {
		City city = cityMapper.findOne(id);
		List<City> cities = cityMapper.findAllOrderBy("ID DESC");
		model.addAttribute("city", city);
		model.addAttribute("cities", cities);
		return "city/edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(Model model, City city) {
		cityMapper.update(city);
		return "redirect:list";
	}
    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
        cityMapper.delete(id);
        return "redirect:list";
    }

    
    @RequestMapping("cityList")
    public String cityList(Model model) {
    	model.addAttribute("cities", districtMapper.findAllWithCities());
    	return "city/cityList";
    }
}