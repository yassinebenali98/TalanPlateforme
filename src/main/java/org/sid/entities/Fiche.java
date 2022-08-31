package org.sid.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Fiche {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String reference;
	private String titre;
	private String risque;
	private String senario;
	private String elementImpacte;
	private String description;
	private String recommandation;
	private String type;
	private String complexite;
	private String priorite;
	private String cvssVector;
	private int cvssScore;
	private String av;
	private String ac;
	private String pr;
	private String ui;
	private String i;
	private String s;
	private String c;
	private String a;	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getRisque() {
		return risque;
	}
	public void setRisque(String risque) {
		this.risque = risque;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	
	
	public String getI() {
		return i;
	}
	public void setI(String i) {
		this.i = i;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getElementImpacte() {
		return elementImpacte;
	}
	public void setElementImpacte(String elementImpacte) {
		this.elementImpacte = elementImpacte;
	}
	
	public String getRecommandation() {
		return recommandation;
	}
	public void setRecommandation(String recommandation) {
		this.recommandation = recommandation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getComplexite() {
		return complexite;
	}
	public void setComplexite(String complexite) {
		this.complexite = complexite;
	}
	public String getPriorite() {
		return priorite;
	}
	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}
	public String getCvssVector() {
		return cvssVector;
	}
	public void setCvssVector(String cvssVector) {
		this.cvssVector = cvssVector;
	}
	public int getCvssScore() {
		return cvssScore;
	}
	public void setCvssScore(int cvssScore) {
		this.cvssScore = cvssScore;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAv() {
		return av;
	}
	public void setAv(String av) {
		this.av = av;
	}
	public String getAc() {
		return ac;
	}
	public void setAc(String ac) {
		this.ac = ac;
	}
	public String getPr() {
		return pr;
	}
	public void setPr(String pr) {
		this.pr = pr;
	}
	public String getUi() {
		return ui;
	}
	public void setUi(String ui) {
		this.ui = ui;
	}
	

	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}


	public String getSenario() {
		return senario;
	}
	public void setSenario(String senario) {
		this.senario = senario;
	}


	@ManyToOne
	@JsonIgnore
	private  Project project;
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy="fiche")
	private List<Preuve> preuve;
	public List<Preuve> getPreuve() {
		return preuve;
	}
	public void setPreuve(List<Preuve> preuve) {
		this.preuve = preuve;
	}
	
	


}
