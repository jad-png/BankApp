package bankaMeak.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Compte {
	private int code;
	private double solde;
	private List<Operation> listeOperations = new ArrayList<>();
	
	public Compte (int code) {
		this.code = code;
		this.solde = 0;
	}
	
	public int getCOde() {
		return code;
	}
	
	public double getSolde() {
		return solde;
	}
	
	protected void setSolde(double solde) {
		this.solde = solde;
	}
	
	public abstract void calculerInteret(double solde);
	public abstract void retirer(double montant);
	public abstract void AffichierDetails();
}
