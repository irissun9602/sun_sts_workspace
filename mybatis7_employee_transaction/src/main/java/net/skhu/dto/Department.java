package net.skhu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
public class Department implements Serializable {
	private static final long serialVersionUID =1L;
	
	int id;
	String name;
	Date time;
	List<Employee> employees;
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
