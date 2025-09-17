package bankaMeak.ui;
	
import bankaMeak.model.Compte;
import bankaMeak.service.*;
import bankaMeak.util.InputUtil;
import bankaMeak.util.ValidationUtil;

public class CreateCompteMenu {
	private BankService bankService;
	
	public CreateCompteMenu(BankService bankService) {
		this.bankService = bankService;
	}
	
	public void execute() {
		try {
			
			
			String userName = InputUtil.readString("Entrer votre nom d'utilisateu: ");
			
			int type = InputUtil.readInt("Type de compte (1 = Courant, 2 = Epargne): ");
			
			Compte createdCompte = null;
			
			switch (type) {
			case 1:
				bankService.creerCompteCourant(userName);
				
                createdCompte = bankService.getLastCreatedCompte();
                createdCompte.displayDetailsTable();
                
                System.out.println("Compte courant cree avec succes");
				// TODO: write the logic for creating an ActualAccount, with reading first deposit(decouvert) 
				// and validating the input, then calling bankService to acces the creerCompteCourent method and pass it the parametre 
				break;
			case 2: 
				double tauxInteret = InputUtil.readDouble("Entrer le taux d'interet qui vous interessant (le maximum taux available est 5%): ");
				// -- TODO: make a conditio that limit insterest written by user --
				if (tauxInteret <= 0 || tauxInteret >= 1) {
                    throw new IllegalArgumentException("Le taux doit être compris entre 0 et 1 (ex: 0.03 = 3%)");
				}
				
				bankService.creerCompteEpargne(userName, tauxInteret);

				createdCompte = bankService.getLastCreatedCompte();
				createdCompte.displayDetailsTable();
                System.out.println("Compte Epergne cree avec succes");
				// TODO: write logic for SavingAccount, with defining a condition for interests user want then update 
				// it to be calculated based on the amount user inserted innit
				break;
            default:
                System.out.println("Type de compte invalide");
			}
			
		} catch (Exception e) {
			System.out.println("Erreur lors de la creation du compte: " + e.getMessage());
		    e.printStackTrace(); // shows exactly where the null came from

		}
	}
}
