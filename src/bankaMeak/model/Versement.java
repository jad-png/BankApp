package bankaMeak.model;

import java.time.LocalDate;

public class Versement extends Operation {
	public String source;

	public Versement(double montant, String source) {
		super(montant, "Versement");
		this.source = source;
	}

	public String getSource() {
		return source;
	}
	@Override
	public String getDetails() {
		
		return null;
	}

}

// nsewel younes ela ai f terminal 