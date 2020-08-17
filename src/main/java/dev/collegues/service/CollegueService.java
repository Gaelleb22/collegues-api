package dev.collegues.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.collegues.entite.Collegue;
import dev.collegues.repository.ColleguesRepository;

@Service
public class CollegueService {
	
	private ColleguesRepository collegueRepository;
	
	public CollegueService(ColleguesRepository collegueRepository) {
		super();
		this.collegueRepository = collegueRepository;
	}

	public List<Collegue> findAll(){
		return collegueRepository.findAll();
	}
	
	public Optional<Collegue> findByUuid(UUID uuid){
		return collegueRepository.findById(uuid);
	}
	
	@Transactional
	public Collegue creer(String nom, String prenoms, String email, LocalDate dateDeNaissance, String photoUrl) {
		Collegue collegue = new Collegue();
		collegue.setNom(nom);
		collegue.setPrenoms(prenoms);
		collegue.setEmail(email);
		collegue.setDateDeNaissance(dateDeNaissance);
		collegue.setPhotoUrl(photoUrl);
		
		Collegue collegueSauvegarde = this.collegueRepository.save(collegue);
		
		return collegueSauvegarde;
	}

}
