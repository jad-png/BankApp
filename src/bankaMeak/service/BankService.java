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
	
	public Compte chercherCompte(String code) {
	    return compteRepo.chercherCompte(code);
	}
	
	// acc creation String code, String userName, double decouvert
	public Compte creerCompteCourant(String userName) {
		String code = compteRepo.generatedNextCode();
//
//		System.out.println(code);

		Compte compte = new CompteCourant(code, userName);
		
		compteRepo.ajouterCompte(compte);
		
		return compte;
		
//		System.out.println("5");

	}
	
	public Compte creerCompteEpargne(String userName, double tauxInteret) {
		String code = compteRepo.generatedNextCode();

		Compte compte = new CompteEpargne(code, userName, tauxInteret);
		compteRepo.ajouterCompte(compte);
		
		return compte;
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
		public void versement(String code, double montant, SourceVersement source) {
			Compte compte = compteRepo.chercherCompte(code);
			
			if (compte == null) {
				throw new IllegalArgumentException("Compte introuvable: " + code);
			}
			
			compte.verser(new Versement(montant, source));
			
		}
		
	// Transfer
	public void virement(String codeSource, String codeDest, double montant) {
		Compte source = compteRepo.chercherCompte(codeSource);
		Compte destinaire = compteRepo.chercherCompte(codeDest);
		
		if (source == null || destinaire == null) {
			throw new IllegalArgumentException("compte source ou destinaire introuvable");
		}
		
		source.retirer(new Retrait(montant, "Virement vers " + codeDest));
		destinaire.verser(new Virement(montant, codeSource, codeDest));
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
	
	public Compte getLastCreatedCompte() {
		return compteRepo.getLastCreatedCompte();
	}
}
