package dev.collegues.service;

import java.util.List;
import java.util.Optional;

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

}
