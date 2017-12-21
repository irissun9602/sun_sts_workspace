package net.skhu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.skhu.dto.City;
import net.skhu.dto.District;

@Mapper
public interface CityMapper {
	City findOne(int id);
	City findByDistrictId(int id);
	List<City> findAllOrderBy( @Param("order") String order);
	List<City> findAll();
	void insert(City article);
	void delete(int id);
	void update(City article);
	
	
}
