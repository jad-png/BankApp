package bankaMeak.model;

public class Versement extends Operation {
	public String source;

	public Versement(double montant, String source) {
		super(montant, "Versement");
		this.source = source;
	}

	public String getSource() {
		return source;
	}
}