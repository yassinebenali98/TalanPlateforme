package org.sid.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.sid.entities.Fiche;
import org.sid.entities.Preuve;
import org.sid.repositories.ProjectRepository;
import org.sid.services.IFicheServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*", maxAge = 3600,allowedHeaders="*")
@RestController
public class FicheController {
	@Autowired
	IFicheServices ficheServices;
	@Autowired
	ProjectRepository projectRepo;
	
	
	public static final String DIRECTORY = "file://C:\\Users\\enna0\\Documents\\workspace-sts-3.8.4.RELEASE\\Talan\\src\\main\\resources\\static\\image";
	public static final String IMG_DIRECTORY = "file://C:\\Users\\enna0\\Documents\\workspace-sts-3.8.4.RELEASE\\Talan\\src\\main\\resources\\static\\image";

	
	@GetMapping("/fiches")
	@ResponseBody
	public List<Fiche> getFiches(){
		return ficheServices.retrieveAllFiches();
	}
	
	@GetMapping("/fiches/{id}")
	@ResponseBody
	public List<Fiche> getFichesProject(@PathVariable("id") Long id){
		System.out.println(id);

		List<Fiche> fiches = ficheServices.retrieveAllFiches();
		List<Fiche> ff= new ArrayList<>();
		for (Fiche fiche : fiches) {
			System.out.println("inside loop");

			if(!(fiche.getProject().getId()==null)){
				if(fiche.getProject().getId()==id){
				ff.add(fiche);
				System.out.println("inside IF");
				}
				
			}
			
		}
		return ff;
	}
	
	
	@GetMapping("/fiche/{id}")
	@ResponseBody
	public Fiche getFicheById(@PathVariable("id") Long id) throws IOException{
		Fiche fiche = ficheServices.retrieveFiche(id);
		List<Preuve> preuves= new ArrayList<>();
		for(Preuve p:fiche.getPreuve() ){
			File resource = new ClassPathResource("image/"+p.getFile()).getFile();
			String text = new String(Files.readAllBytes(resource.toPath()));
			p.setFile(text);
			preuves.add(p);
		}
		fiche.setPreuve(preuves);
		return fiche;
	}
	

	
	
	
	
	
	@PostMapping(
			path= "/addFiche"      
					 
			)
	@ResponseBody
	public Fiche addFiche(@RequestParam String r,
			@RequestParam("file") MultipartFile[] multipartFile,
			@RequestParam Long proj
			) throws JsonMappingException, JsonProcessingException {
		Fiche f= new ObjectMapper().readValue(r, Fiche.class);
		f.setProject(projectRepo.findById(proj).orElse(null));
		return ficheServices.addFiche(f,f.getPreuve(),multipartFile);
	}
	
	
	@DeleteMapping("/deleteFiche/{Fiche-id}")
	@ResponseBody
	public void removeFiche(@PathVariable("Fiche-id") Long id) {
		ficheServices.deleteFiche(id);
	}


	@PutMapping("/updateFiche")
	@ResponseBody
	public Fiche modifyFiche(@RequestBody Fiche r) {
	return ficheServices.updateFiche(r);
	}
	
	
	
	
	

}
