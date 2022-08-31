package org.sid.entities;

import java.util.List;

import javax.persistence.*;


@Entity
public class PlanningUser {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="planningUser")
	private List<Task> Tasks;
	
	@OneToOne

	private User user;
}
