package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.skhu.domain.City;

public interface CityRepository extends JpaRepository<City, Integer>  {

	List<City> findByDistrictName(String name);
	
	
	@Query("Select c from City c where c.district.name = :name")
	List<City> findCity(@Param("name") String name);
			
	
}
