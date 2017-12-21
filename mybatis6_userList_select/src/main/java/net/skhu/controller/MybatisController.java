package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Department;
import net.skhu.dto.Student;
import net.skhu.dto.User;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;
import net.skhu.mapper.UserMapper;

@Controller
@RequestMapping("mybatis")
public class MybatisController {

	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	UserMapper userMapper;

	@RequestMapping(value = "cacheTest", method = RequestMethod.GET)
	public String cacheTest(Model model) {
		List<Department> departments = departmentMapper.findAll();
		model.addAttribute("departments", departments);
		model.addAttribute("department", departments.get(0));
		model.addAttribute("students", studentMapper.findAll().subList(0, 5));
		return "mybatis/cacheTest";
	}

	@RequestMapping(value = "cacheTest", method = RequestMethod.POST)
	public String cache(Model model, Department department) {
		departmentMapper.update(department);
		return "redirect:cacheTest";
	}

	@RequestMapping("departmentList1")
	public String departmentList1(Model model) {
		List<Department> departments = departmentMapper.findAll();
		for (Department department : departments) {
			List<Student> students = studentMapper.findByDepartmentId(department.getId());
			department.setStudents(students);
		}
		model.addAttribute("departments", departments);
		return "mybatis/departmentList";
	}

	@RequestMapping("departmentList2")
	public String departmentList2(Model model) {
		model.addAttribute("departments", departmentMapper.findAllWithStudents());
		return "mybatis/departmentList";
	}

	@RequestMapping(value = "userList", method = RequestMethod.GET)
	public String dynamicSQL(Model model) {
		List<User> list1 = userMapper.findAllOrderBy("ID DESC");
		model.addAttribute("list1", list1);

		return "mybatis/userList";
	}

	static String[] s = new String[] { "ID DESC", "name", "email" };

	@RequestMapping(value = "userList", method = RequestMethod.POST)
	public String dynamicSQL(Model model, @RequestParam("orderIndex") int orderIndex) {

		String order = s[orderIndex];
		List<User> list1 = userMapper.findAllOrderBy(order);
		model.addAttribute("list1", list1);

		return "mybatis/userList";
	}

}