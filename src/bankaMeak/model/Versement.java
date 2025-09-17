package bankaMeak.model;

public class Versement extends Operation {
	public SourceVersement source;

	public Versement(double montant, SourceVersement source) {
		super(montant, "Versement");
		this.source = source;
	}

	public SourceVersement getSource() {
		return source;
	}
	
	
}