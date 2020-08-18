package dev.collegues.entite;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "note")
public class Notes {
	
	@Id
	private UUID uuid;
	
	@Column (name = "date_saisie")
	private LocalDate dateSaisie;
	@Column (name = "note")
	private String note;
	
	@ManyToOne
	@JoinColumn (name = "collegue_uuid")
	private Collegue collegue;
	
	public Notes() {
		this.uuid = UUID.randomUUID();
	}
	
	/**
	 * @return the uuid
	 */
	public UUID getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	
	/**
	 * @return the collegue
	 */
	public Collegue getCollegue() {
		return collegue;
	}

	/**
	 * @param collegue the collegue to set
	 */
	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
	}

	/**
	 * @return the dateSaisie
	 */
	public LocalDate getDateSaisie() {
		return dateSaisie;
	}
	/**
	 * @param dateSaisie the dateSaisie to set
	 */
	public void setDateSaisie(LocalDate dateSaisie) {
		this.dateSaisie = dateSaisie;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the text to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

}
