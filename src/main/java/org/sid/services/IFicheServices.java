package org.sid.services;

import java.util.ArrayList;
import java.util.List;

import org.sid.entities.Fiche;
import org.sid.entities.Preuve;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;




public interface IFicheServices {

	List<Fiche> retrieveAllFiches();

	Fiche addFiche(Fiche f,List<Preuve> preuves,MultipartFile[] multipartFile);

	void deleteFiche(Long id);

	Fiche updateFiche(Fiche f);

	Fiche retrieveFiche(Long id);
	

	ResponseEntity<?> addPreuve(Preuve p,MultipartFile multipartFile);
}
