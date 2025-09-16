package bankaMeak.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Compte {
	private String userName;
	private int code;
	private double solde;
//	private List<Operation> listeOperations = new ArrayList<>();
	
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
	public abstract void retirer(Operation op);
	public abstract void AffichierDetails();

	
}
