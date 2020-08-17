package dev.collegues.repository;

import dev.collegues.entite.Collegue;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ColleguesRepository extends JpaRepository<Collegue, UUID>{

}
