package org.sid.controllers;

import java.security.Principal;
import java.util.List;

import org.sid.entities.Fiche;
import org.sid.entities.Project;
import org.sid.services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600,allowedHeaders="*")
@RestController
public class ProjectController {
	@Autowired
	IProjectService projectServices;
	
	@GetMapping("/projects")
	@ResponseBody
	public List<Project> getFiches(){
		return projectServices.retrieveAllProjects();
	}
	
	@PostMapping("/addProject")
	@ResponseBody
	public Project addProject(@RequestBody Project project) {
		return projectServices.addProject(project);
	}
	
}
