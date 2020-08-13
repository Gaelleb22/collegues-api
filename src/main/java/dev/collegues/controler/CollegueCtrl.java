package dev.collegues.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegues.entite.Collegue;
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
	
	@GetMapping(path="/{matricule}")
	public ResponseEntity<?> findCollegueByMatricule (@PathVariable String matricule){
		List<Collegue> collegues = collegueService.findAll();
		List<Collegue> trouve = new ArrayList<>();
		for(Collegue col : collegues) {
			if(col.getMatricule().contentEquals(matricule)) {
				trouve.add(col);
			}
		}
		if(trouve.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pas de Collegue avec ce matricule");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(trouve);
	}
	

}
