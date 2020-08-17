package dev.collegues.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreerCollegueDto {
	
	@NotBlank
	@NotNull
	@Size(min = 2)
	@JsonProperty("nom")
	private String nom;
	@NotBlank
	@NotNull
	@Size(min = 2)
	@JsonProperty("prenoms")
    private String prenoms;
	@NotBlank
	@NotNull
	@JsonProperty("email")
	private String email;

	@NotNull
	@JsonProperty("dateDeNaissance")
	private LocalDate dateDeNaissance;
	@JsonProperty("photoUrl")
	private String photoUrl;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

}
