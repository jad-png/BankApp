package bankaMeak.model;

public class CompteCourant extends Compte {
	private double decouvert = 600;
	
	public CompteCourant(int code, String userName) {
		super(code, userName);
	}
	

	public double getDecouvert() {
		return decouvert;
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
