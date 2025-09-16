package bankaMeak.model;

public class Retrait extends Operation {
	public String destination;

	public Retrait(double montant, String destination) {
		super(montant, "Retrait");
		this.destination = destination;
	}

	public String getDestination() {
		return destination;
	}
	@Override
	public String getDetails() {
		return null;
	}

}
