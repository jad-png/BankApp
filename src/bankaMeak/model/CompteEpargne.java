package bankaMeak.model;

public class CompteEpargne extends Compte {
	private double tauxInteret;

	public CompteEpargne(int code, String userName, double tauxInteret) {
		super(code, userName);
		this.tauxInteret = tauxInteret;
	}


	@Override
	public double calculerInteret() {
		// TODO calculate account's interest based on it's balance.
		// Following this operation solde * tauxInteret
		double total = 0.0;
		
		for (Operation op : getListeOperations()) {
			total += op.getMontant() * tauxInteret;
		}
		
		return total;
	}

	@Override
	public void retirer(Retrait op) {
		if (op.getMontant() <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif !");
        }
        if (getSolde() < op.getMontant()) {
            throw new IllegalArgumentException("Retrait refusé : solde insuffisant.");
        }
        setSolde(getSolde() - op.getMontant());
        getListeOperations().add(op);
	}
}
