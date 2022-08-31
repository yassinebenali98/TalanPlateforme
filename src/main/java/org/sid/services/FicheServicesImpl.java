package org.sid.services;


import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;

import org.sid.entities.Fiche;
import org.sid.entities.Preuve;
import org.sid.repositories.FicheRepository;
import org.sid.repositories.PreuveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FicheServicesImpl implements IFicheServices{

	@Autowired
	FicheRepository ficheRepo;
	@Autowired
	PreuveRepository preuveRepo;
	
	
	public static final String DIRECTORY = "C:\\Users\\enna0\\Documents\\workspace-sts-3.8.4.RELEASE\\Talan\\src\\main\\resources\\static\\image";
	public static final String IMG_DIRECTORY = "C:\\Users\\enna0\\Documents\\workspace-sts-3.8.4.RELEASE\\Talan\\src\\main\\resources\\static\\image";
	
	List<String> fileExtentions = new ArrayList<>(Arrays.asList("pdf", "ppt", "pptx","jpg", "jpeg", "png"));
	
	
	@Override
	public List<Fiche> retrieveAllFiches() {
		List<Fiche> fiches= (List<Fiche>) ficheRepo.findAll();
		return fiches;
	} 

	@Override
	public Fiche addFiche(Fiche f, List<Preuve> preuves,MultipartFile[] multipartFile) {
		Fiche ff= ficheRepo.saveAndFlush(f);
		List<MultipartFile> files= Arrays.asList(multipartFile);
		int i=0;
		for (Preuve preuve : preuves) {
			
				Preuve pp= preuveRepo.save(preuve); 
				pp.setFiche(ff);
				addPreuveFiches(pp,files.get(i));
				i++;
		}
		return 	f;
	}

	@Override
	public void deleteFiche(Long id) {
		ficheRepo.deleteById(id);
	}

	@Override
	public Fiche updateFiche(Fiche f) {
		return ficheRepo.save(f);
	}

	@Override
	public Fiche retrieveFiche(Long id) {
		return ficheRepo.findById(id).orElse(null) ;
	}

	public ResponseEntity<?> addPreuveFiches(Preuve preuve,MultipartFile multipartFile) {
		System.out.println("HELLOOO");

		
			String fileName = UUID.randomUUID().toString() + multipartFile.getOriginalFilename();
			String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
			
			preuve.setFile(fileName);
			Preuve p = preuveRepo.save(preuve);
			
				Path fileStorage = get(DIRECTORY, fileName).toAbsolutePath().normalize();
				try {
	            copy(multipartFile.getInputStream(),fileStorage);
	            
				/*multipartFile.transferTo(new File(DIRECTORY + fileName));
				image.transferTo(new File(DIRECTORY + imageName));*/

			} catch (Exception e) {
				System.out.println("ERR");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
			}

			
			return ResponseEntity.ok().body(p);
			
		
		
	}

	@Override
	public ResponseEntity<?> addPreuve(Preuve p, MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	}
	
	


