package org.sid.services;

import java.util.List;

import org.sid.entities.Project;

public interface IProjectService {
	
	List<Project> retrieveAllProjects();

	Project addProject(Project f);

	void deleteProject(Long id);

	Project updateProject(Project f);

	Project retrieveProject(Long id);

}
