package bankaMeak.service;

import bankaMeak.repository.CompteRepository;

public class BankService {
	// TODO: this class needs these following methods: 
	// creerCompte()
	// versement(string code, double montant, string source)
	// retrait (string code, double montant, string destination)
	// virement(string codeSource, string codeDest ??, double montant)
	// consulterSolde(string code)
	// listerOperations(string code)
	// --Use HashMap for fast account search
	private CompteRepository compteRepo;
	
	public BankService(CompteRepository repo) {
		this.compteRepo = repo;
	}
	
	// acc creation String code, String userName, double decouvert
}
