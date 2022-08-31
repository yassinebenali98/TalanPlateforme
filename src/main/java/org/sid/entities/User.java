package org.sid.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;



@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	
	private String prenom;
	
	private String username;

	private String email;

	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	private String typeUser;
	
			
	@OneToOne

	private PlanningUser planningUser;
}
