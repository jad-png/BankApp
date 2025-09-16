package bankaMeak.model;

import java.time.LocalDate;

public class Retrait extends Operation {

	public Retrait(LocalDate date, double montant) {
		super(date, montant);
		// TODO Auto-generated constructor stub
	}

	public String destination;
	
	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
