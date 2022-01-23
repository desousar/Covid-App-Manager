package models;

import java.sql.Date;

public class Patient {
	
	private int id;
	private String firstname;
	private String lastname;	
	private Date datebirth;
	private String namevaccine;
	private int nbrdose;
	
	public Patient(int id, String firstname, String lastname, Date datebirth, String namevaccine, int nbrdose) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.datebirth = datebirth;
		this.namevaccine = namevaccine;
		this.nbrdose = nbrdose;
	}
	
	public Patient(String firstname, String lastname, Date datebirth, String namevaccine, int nbrdose) {
	
		this.firstname = firstname;
		this.lastname = lastname;
		this.datebirth = datebirth;
		this.namevaccine = namevaccine;
		this.nbrdose = nbrdose;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", datebirth="
				+ datebirth + ", namevaccine=" + namevaccine + ", nbrdose=" + nbrdose + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDatebirth() {
		return datebirth;
	}

	public void setDatebirth(Date datebirth) {
		this.datebirth = datebirth;
	}

	public String getnamevaccine() {
		return namevaccine;
	}

	public void setnamevaccine(String namevaccine) {
		this.namevaccine = namevaccine;
	}

	public int getNbrdose() {
		return nbrdose;
	}

	public void setNbrdose(int nbrdose) {
		this.nbrdose = nbrdose;
	}
	
}
