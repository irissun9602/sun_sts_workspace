package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.skhu.dto.Employee;

@Mapper
public interface EmployeeMapper {
	Employee findOne(int id);
	List <Employee> findAll();
	List <Employee> findAllOrderBy(@Param("count")int count, @Param("order") String order);
	void insert(Employee employee);
	void update(Employee employee);
	void delete(int id);

}
