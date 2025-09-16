package bankaMeak.model;

public class CompteCourant extends Compte {
	private double decouvert;
	
	public CompteCourant(String code, String userName, double decouvert) {
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
	public double calculerInteret() {
		// compte courant n'a pas d'interets		
		return 0;
	}

	@Override
	public void retirer(Retrait op) {
		if (op.getMontant() <= 0) {
            throw new IllegalArgumentException("Le montant doit etre positif");
		}
		
		if (getSolde() - op.getMontant() < -decouvert) {
			throw new IllegalArgumentException("Retrait refuse: depassement du decouvert autorise");
		}
		
		setSolde(getSolde() - op.getMontant());
		getListeOperations().add(op);
	}
}
