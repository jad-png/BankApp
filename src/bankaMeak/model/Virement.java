package bankaMeak.model;

//import bankaMeak.model.Operation;

public class Virement extends Operation {

	private String compteSource;
	private String compteDestination;
	
	public Virement(double montant, String compteSrc, String compteDest) {
		super(montant, "Virement");
		this.compteSource = compteSrc;
		this.compteDestination = compteDest;
	}
	
	public String getCompteSource() {
		return compteSource;
	}
	
	public String getCompteDestination() {
		return compteDestination;
	}
}
