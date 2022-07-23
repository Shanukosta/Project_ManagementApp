package com.pma.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pma.dto.EmployeeProject;
import com.pma.dto.ProjectStage;
import com.pma.entity.Project;
import com.pma.repository.IEmployeeRepository;
import com.pma.repository.IProjectRepository;

@Controller
public class HomeController {

	@Value("${version}")
	private String ver;
	
	@Autowired
	IProjectRepository projectRepo;
	@Autowired
	IEmployeeRepository employeeRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		model.addAttribute("versionNumber", ver);
		
		List<Project> projects = projectRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		List<ProjectStage> projectStageCnt = projectRepo.getProjectStage();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectStageCnt);
		model.addAttribute("projectStatusCnt", jsonString);
		
		List<EmployeeProject> employeesProjectCnt = employeeRepo.employeeProjects();
		model.addAttribute("employeesListProjectCnt", employeesProjectCnt);
		
		return "main/home";
	}
	
	
	
	
}
