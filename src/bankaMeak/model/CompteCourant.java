package bankaMeak.model;

public class CompteCourant extends Compte {
	private double decouvert;
	
	public CompteCourant(int code, String userName, double decouvert) {
		super(code, userName);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	@Override
	public void deposer(double montant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void retirer(double montant) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void affichierDetails() {
		
	}

}
