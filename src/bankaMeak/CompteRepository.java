package bankaMeak;

import bankaMeak.model.Compte;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CompteRepository {
	private Map<String, Compte> comptes = new HashMap<>();
	
	public void ajouterCompte(Compte compte) {
		
		comptes.put(compte.getCode(), compte);
	}
	
	public Compte chercherCompte(String code) {
		return comptes.get(code);
	}
	
	public Collection<Compte> getAllComptes() {
		return comptes.values();
	}
}
