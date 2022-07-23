package com.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pma.entity.Employee;
import com.pma.entity.Project;
import com.pma.repository.IEmployeeRepository;
import com.pma.repository.IProjectRepository;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	IProjectRepository projectRepository;
	
	@Autowired
	IEmployeeRepository employeeRepository;
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Project> projects= projectRepository.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject= new Project();
		List<Employee> employees= employeeRepository.findAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> employees,  Model model) {
	//use to saving data to database	
		projectRepository.save(project);
		
//		Iterable<Employee> chosenEmployees = employeeRepository.findAllById(employees);
//		
//		for(Employee emp: chosenEmployees) {
//			emp.setProject(project);
//			employeeRepository.save(emp);
//		}
		
		return "redirect:/projects/new";
	}
}
