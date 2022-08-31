package org.sid.services;

import java.util.List;

import org.sid.entities.Fiche;
import org.sid.entities.Project;
import org.sid.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements IProjectService{

	@Autowired
	 ProjectRepository projectRepo;
	
	
	@Override
	public List<Project> retrieveAllProjects() {
		List<Project> projects= (List<Project>) projectRepo.findAll();
		return projects;
	}

	@Override
	public Project addProject(Project f) {
		
		return projectRepo.save(f);
	}

	@Override
	public void deleteProject(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Project updateProject(Project f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project retrieveProject(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
