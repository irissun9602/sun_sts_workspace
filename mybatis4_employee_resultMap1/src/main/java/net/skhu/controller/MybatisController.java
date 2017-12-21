package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.skhu.dto.Department;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.EmployeeMapper;
import net.skhu.dto.Employee;
@Controller
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired DepartmentMapper departmentMapper;
    @Autowired EmployeeMapper employeeMapper;
    
    
    @RequestMapping(value="cacheTest", method=RequestMethod.GET)
    public String cacheTest(Model model) {
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("departments", departments);
        model.addAttribute("department", departments.get(0));
        model.addAttribute("employees", employeeMapper.findAll().subList(0, 5));
        return "mybatis/cacheTest";
    }

    @RequestMapping(value="cacheTest", method=RequestMethod.POST)
    public String cache(Model model, Department department) {
        departmentMapper.update(department);
        return "redirect:cacheTest";
    }
    
    @RequestMapping(value="departmentList1")
    public String departmentList1(Model model) {
    	List<Department> departments = departmentMapper.findAll();
    	for(Department department : departments) {
    		List<Employee> employees = employeeMapper.findByDepartmentId(department.getId());
    		department.setEmployees(employees);
    	}
    	model.addAttribute("departments", departments);
    	return "mybatis/departmentList";
    }

}