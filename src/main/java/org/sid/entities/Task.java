package org.sid.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Long id;
	@ManyToOne
	private PlanningUser planningUser;
	
	@ManyToOne
	private  ProjectPlan projectPlan;

}
