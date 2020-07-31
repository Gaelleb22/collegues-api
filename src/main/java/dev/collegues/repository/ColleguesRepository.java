package dev.collegues.repository;

import dev.collegues.entite.Collegue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColleguesRepository extends JpaRepository<Collegue, Integer>{

}
