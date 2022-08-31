package org.sid.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProjectPlan {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Long id;
	private Date start;
	private Date end;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="planningUser")
	private List<Task> Tasks;

}
