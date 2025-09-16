package bankaMeak.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public abstract class Operation {
	private UUID id;
	private LocalDate date;
	private double montant;
	
	public Operation(LocalDate date, double montant) {
		this.id = UUID.randomUUID();
		this.date = date;
		this.montant = montant;
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
}
