/**
 * 
 */
package dev.collegues.entite;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**Représente un collègue
 * @author formation
 *
 */
@Entity
@Table(name = "collegue")
public class Collegue {
	
	/**identifiant
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/**matricule du collègue
	 * 
	 */
	@Column(name = "matricule")
	private String matricule;
	/**nom
	 * 
	 */
	@Column(name = "nom")
	private String nom; 
	/**prénom
	 * 
	 */
	@Column(name = "prenoms")
	private String prenoms;
	/**adresse mail
	 * 
	 */
	@Column(name = "email")
	private String email;
	/**date de naissance
	 * 
	 */
	@Column(name = "date_naissance")
	private LocalDate dataDeNaissance;
	/**lien url de la photo
	 * 
	 */
	@Column(name = "photo_url")
	private String photoUrl;
	
	/**Constructeur
	 * 
	 */
	public Collegue() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenoms
	 */
	public String getPrenoms() {
		return prenoms;
	}

	/**
	 * @param prenoms the prenoms to set
	 */
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the dataDeNaissance
	 */
	public LocalDate getDataDeNaissance() {
		return dataDeNaissance;
	}

	/**
	 * @param dataDeNaissance the dataDeNaissance to set
	 */
	public void setDataDeNaissance(LocalDate dataDeNaissance) {
		this.dataDeNaissance = dataDeNaissance;
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
