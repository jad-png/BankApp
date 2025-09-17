package bankaMeak.ui;

import bankaMeak.model.Compte;
import bankaMeak.service.BankService;
import bankaMeak.util.InputUtil;
import bankaMeak.util.ValidationUtil;

public class ConsulterOperationsMenu {
	private BankService bankSer;
		
		public ConsulterOperationsMenu(BankService bankSer) {
			this.bankSer = bankSer;
		}
		
		public void execute() {
		    try {
		        String code = InputUtil.readString("Saisir le code de votre compte (CPT-12345): ");
		        ValidationUtil.validateCode(code);
		        
		        Compte compte = bankSer.chercherCompte(code);
		        if (compte != null) {
		            compte.displayOperations();
		        } else {
		            System.out.println("Compte introuvable !");
		        }
		    } catch (Exception e) {
		        System.out.println("Erreur : " + e.getMessage());
		    }
		}
}
