package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.Employee;

@Mapper
public interface EmployeeMapper {
	Employee findOne(int id);
	List <Employee> findAll();
	void insert(Employee employee);
	void update(Employee employee);
	void delete(int id);

}
