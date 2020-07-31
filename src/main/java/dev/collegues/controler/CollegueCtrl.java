package dev.collegues.controler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegues.entite.Collegue;
import dev.collegues.service.CollegueService;

@RestController
//@RequestMapping("collegues")
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
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("erreur de paramètres");
		}
		
		Optional<Collegue> opt = collegueService.findByName(nom);
		if(opt.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pas de Collegue à ce nom");
		}
		return ResponseEntity.status(HttpStatus.OK).body(opt);
	}

}
