package dev.collegues.controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegues.dto.CollegueDto;
import dev.collegues.dto.CreerCollegueDto;
import dev.collegues.entite.Collegue;
import dev.collegues.entite.Photo;
import dev.collegues.service.CollegueService;

@CrossOrigin(origins = "*")
@RestController
public class CollegueCtrl {
	
	@Autowired
	private CollegueService collegueService;
	
	@RequestMapping(path = "listecollegues", method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(collegueService.findAll());
	}
	
	@RequestMapping(path = "collegues", method = RequestMethod.GET)
	public ResponseEntity<?> findCollegueByNom(@RequestParam("nom") String nom){
		
		if(nom.length() <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Veuillez entrer un nom");
		}
		
		List<Collegue> collegues = collegueService.findAll();
		List<Collegue> trouve = new ArrayList<>();
		for(Collegue col : collegues) {
			if(col.getNom().contentEquals(nom)) {
				trouve.add(col);
			}
		}
		if(trouve.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pas de Collegue à ce nom");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(trouve);
	}
	
	@GetMapping(path="collegues/{uuidString}")
	public ResponseEntity<?> findCollegueByMatricule (@PathVariable String uuidString){
		
		UUID matricule = null;
		try{
			matricule = UUID.fromString(uuidString);
		} catch(IllegalArgumentException e) {
			new IllegalArgumentException (e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Uuid invalide");
		}
		
		Optional<Collegue> opt = collegueService.findByUuid(matricule);
		List<Collegue> trouve = new ArrayList<>();
		if(opt.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pas de Collegue avec ce matricule");
		}
		trouve.add(opt.get());
		
		return ResponseEntity.status(HttpStatus.OK).body(trouve);
	}
	
	@GetMapping(path="collegues/photos")
	public ResponseEntity<?> findPhotos(){
		List<Collegue> collegues = collegueService.findAll();
		List<Photo> photos = new ArrayList<>();
		for(Collegue col : collegues) {
			Photo photo = new Photo(col.getMatricule(), col.getPhotoUrl());
			photos.add(photo);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(photos);
	}
	
	@PostMapping
	public CollegueDto creerCollegue(@RequestBody @Valid CreerCollegueDto collegue) {
		Collegue collegueCreer = collegueService.creer(collegue.getNom(), collegue.getPrenoms(), 
				collegue.getEmail(), collegue.getDateDeNaissance(), collegue.getPhotoUrl());
		
		CollegueDto collegueDto = new CollegueDto();
		collegueDto.setNom(collegueCreer.getNom());
		collegueDto.setPrenoms(collegueCreer.getPrenoms());
		collegueDto.setEmail(collegueCreer.getEmail());
		collegueDto.setDateDeNaissance(collegueCreer.getDateDeNaissance());
		collegueDto.setPhotoUrl(collegueCreer.getPhotoUrl());
		collegueDto.setMatricule(collegueCreer.getMatricule());
		
		return collegueDto;
	}
	

}
