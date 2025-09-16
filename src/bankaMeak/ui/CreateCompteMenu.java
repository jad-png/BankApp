package bankaMeak.ui;
	
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
			
			String code = InputUtil.readString("Entrer votre code (format e.g: CPT-12345): ");
			ValidationUtil.isValidCode(code);
			
			String userName = InputUtil.readString("Entrer votre nom d'utilisateu: ");
			// TODO: add a validation method to validate the input
			
			int type = InputUtil.readInt("Type de compte (1 = Courant, 2 = Epargne): ");
			
			switch (type) {
			case 1:
				// TODO: write the logic for creating an ActualAccount, with reading first deposit(decouvert) 
				// and validating the input, then calling bankService to acces the creerCompteCourent method and pass it the parametre 
				break;
			case 2: 
				// TODO: write logic for SavingAccount, with defining a condition for interests user want then update 
				// it to be calculated based on the amount user inserted innit
				break;
            default:
                System.out.println("Type de compte invalide");
			}
			
		} catch (Exception e) {
			System.out.println("Erreur lors de la creation du compte: " + e.getMessage());
		}
	}
}
