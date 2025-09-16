package bankaMeak.model;

import java.util.Date;
import java.util.UUID;

public abstract class Operation {
	private UUID id;
	private Date date;
	private double montant;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
}
