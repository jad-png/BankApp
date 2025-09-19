package bankaMeak.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Compte implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String code;
	private double solde;
	private List<Operation> listeOperations = new ArrayList<>();
	
	public Compte (String numericCode, String userName) {
		this.code = numericCode;
		this.userName = userName;
		this.solde = 0;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getCode() {
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
	// TOFIX
	public void verser(Operation op) {
		if (op.getMontant() <= 0) {
			throw new IllegalArgumentException("Le montant doit etre positif");
		}
		solde += op.getMontant();
		listeOperations.add(op);
	}
	
	public abstract double calculerInteret();
	
	public abstract void retirer(Retrait op);
	
	// TODO: add a method to display account details.
	public void displayDetailsTable() {
	    System.out.println("========================================");
		    
	    System.out.printf("| %-12s | %s%n", "Compte", getCode());
	    System.out.printf("| %-12s | %s%n", "Titulaire", getUserName());
	    if (this instanceof CompteCourant) {
	        System.out.printf("| %-12s | Compte Courant%n", "Type");
	        System.out.printf("| %-12s | %.2f DH%n", "Découvert", ((CompteCourant)this).getDecouvert());
	    } else if (this instanceof CompteEpargne) {
	    	System.out.printf("| %-12s | Compte Épargne%n", "Type");
	    	System.out.printf("| %-12s | %.2f %% %n", "Taux Intérêt", ((CompteEpargne)this).getTauxInteret() * 100);
	    }
	    System.out.printf("| %-12s | %.2f DH%n", "Solde", getSolde());
	    System.out.println("========================================");
	}

	
	public void displayOperations() {
	    if (listeOperations.isEmpty()) {
	        System.out.println("Aucune opération effectuée.");
	        return;
	    }

	    System.out.println("------ Historique des opérations ------");
	    System.out.printf("%-15s %-12s %-10s %-20s%n", "Date", "Type", "Montant", "Source/Destination");
	    
	    for (Operation op : listeOperations) {
	        String extraInfo = "";
	        if (op instanceof Versement) {
	            extraInfo = ((Versement) op).getSource().toString();
	        } else if (op instanceof Retrait) {
	            extraInfo = ((Retrait) op).getDestination();
	        } else if (op instanceof Virement) {
	            extraInfo = "De: " + ((Virement) op).getCompteSource() + " → À: " + ((Virement) op).getCompteDestination();
	        }
	        System.out.printf("%-15s %-12s %-10.2f %-20s%n", op.getDate(), op.getType(), op.getMontant(), extraInfo);
	    }
	    System.out.println("---------------------------------------");
	}

}
