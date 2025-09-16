package bankaMeak.service;

import java.util.List;

import bankaMeak.repository.CompteRepository;
import bankaMeak.model.*;

public class BankService {
	// TODO: this class needs these following methods: 
	// creerCompte()
	// versement(string code, double montant, string source)
	// retrait (string code, double montant, string destination)
	// virement(string codeSource, string codeDest ??, double montant)
	// consulterSolde(string code)
	// listerOperations(string code)
	// --Use HashMap for fast account search in the repository layer
	
	private CompteRepository compteRepo;
	
	public BankService(CompteRepository repo) {
		this.compteRepo = repo;
	}
	
	// acc creation String code, String userName, double decouvert
	public void creerCompteCourant(String code, String userName, double decouvert) {
		Compte compte = new CompteCourant(code, userName, decouvert);
		compteRepo.ajouterCompte(compte);
	}
	
	public void creerCompteEpargne(String code,String userName, double tauxInteret) {
		Compte compte = new CompteEpargne(code, userName, tauxInteret);
		compteRepo.ajouterCompte(compte);
	}
	
	// Withdraw
	public void retrait(String code, double montant, String destination) {
		Compte compte = compteRepo.chercherCompte(code);
		
		if (compte == null) {
			throw new IllegalArgumentException("Comte introuvable: " + code);
		}
		
		compte.retirer(new Retrait(montant, destination));
	}
	
	// Deposit
	public void versement(String code, String montant, double source) {
		Compte compte = compteRepo.chercherCompte(code);
		
		if (compte == null) {
			throw new IllegalArgumentException("Compte introuvable: " + code);
		}
		
		compte.verser(new Versement(source, montant));
		
	}
	
	// Transfer
	public void virement(String codeSource, String codeDest, double montant) {
		Compte source = compteRepo.chercherCompte(codeSource);
		Compte destinaire = compteRepo.chercherCompte(codeDest);
		
		if (source == null || destinaire == null) {
			throw new IllegalArgumentException("compte source ou destinaire introuvable");
		}
		
		source.retirer(new Retrait(montant, "Virement vers " + codeDest));
		destinaire.verser(new Versement(montant, "Virement recu de " + codeSource));
	}
	
	// balance
	public double consulterSolde(String code) {
		Compte compte = compteRepo.chercherCompte(code);
		
		if (compte == null) {
			throw new IllegalArgumentException("Compte introuvable :" + code);
		}
		return compte.getSolde();
	}
	
	// Operations List
	public List<Operation> listerOperations(String code) {
		Compte compte = compteRepo.chercherCompte(code);
		
		if(compte == null) {
			throw new IllegalArgumentException("Compte introuvable :" + code);
		}
		
		return compte.getListeOperations();
	}
	
}
