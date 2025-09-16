package bankaMeak.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Compte {
	private String userName;
	private int code;
	private double solde;
	private List<Operation> listeOperations = new ArrayList<>();
	
	public Compte (int code, String userName) {
		this.code = code;
		this.userName = userName;
		this.solde = 0;
	}

//	public Compte(int code2, String userName2) {
//		// TODO Auto-generated constructor stub
//	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getCode() {
		return code;
	}
	
	public double getSolde() {
		return solde;
	}
	
	protected void setSolde(double solde) {
		this.solde = solde;
	}
	
	public List<Operation> getListeOperations() {
		return listeOperations;
	}
	
	public void verser(Versement op) {
		if (op.getMontant() <= 0) {
			throw new IllegalArgumentException("Le montant doit etre positif");
		}
		solde += op.getMontant();
		listeOperations.add(op);
	}
	
	public abstract double calculerInteret();
	public abstract void retirer(Retrait op);
}
