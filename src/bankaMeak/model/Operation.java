package bankaMeak.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public abstract class Operation {
	private UUID id;
	private LocalDate date;
	private double montant;
	private String type;
	
	public Operation(double montant, String type) {
		this.id = UUID.randomUUID();
		this.date = LocalDate.now();
		this.montant = montant;
		this.setType(type);
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
    public abstract String getDetails();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
