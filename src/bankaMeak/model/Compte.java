package bankaMeak.model;

import java.util.ArrayList;
import java.util.List;

public class Compte {
	private int code;
	private double solde;
	private List<Operation> listeOperations = new ArrayList<>();
	
	public Compte (int code) {
		this.code = code;
		this.solde = 0;
	}
}
