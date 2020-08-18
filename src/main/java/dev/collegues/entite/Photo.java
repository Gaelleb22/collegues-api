package dev.collegues.entite;

import java.util.UUID;

public class Photo {
	
	private UUID matricule;
	private String photoUrl;
	
	public Photo(UUID matricule, String photoUrl) {
		this.matricule = matricule;
		this.photoUrl = photoUrl;
	}
	/**
	 * @return the matricule
	 */
	public UUID getMatricule() {
		return matricule;
	}
	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(UUID matricule) {
		this.matricule = matricule;
	}
	/**
	 * @return the photoUrl
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}
	/**
	 * @param photoUrl the photoUrl to set
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

}
