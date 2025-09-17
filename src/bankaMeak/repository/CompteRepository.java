package bankaMeak.repository;

import bankaMeak.model.Compte;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompteRepository {
	private Map<String, Compte> comptes = new HashMap<>();
    private List<String> insertionOrder = new ArrayList<>();

	private int lastNumericCode = 0;
	
	public String generatedNextCode() {
		lastNumericCode++;
		String result = "CPT-" + String.format("%05d", lastNumericCode);

		return result;
		
	}
	
	public void ajouterCompte(Compte compte) {
        comptes.put(compte.getCode(), compte);
        insertionOrder.add(compte.getCode());    
	}
	
	public Compte chercherCompte(String code) {
		return comptes.get(code);
	}
	
	public Collection<Compte> getAllComptes() {
		return comptes.values();
	}
	
	public Compte getLastCreatedCompte() {
		if (insertionOrder.isEmpty()) return null;
		
		String lastCode = insertionOrder.get(insertionOrder.size() - 1);
		return comptes.get(lastCode);
	}
}
