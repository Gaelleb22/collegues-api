package dev.collegues.dto;

import java.util.UUID;

public class CollegueDto extends CreerCollegueDto{
	
	private UUID matricule;

    public UUID getMatricule() {
		return matricule;
	}

	public void setMatricule(UUID uuid) {
		this.matricule = uuid;
	}

}
