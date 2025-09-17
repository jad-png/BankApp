package bankaMeak.ui;

import bankaMeak.service.BankService;
import bankaMeak.util.InputUtil;
import bankaMeak.util.ValidationUtil;

public class VersementMenu {
	private BankService bankSer;
	
	public VersementMenu(BankService bankService) {
		this.bankSer = bankService;
	}
	
	public void execute() {
		try {
			String codeSource = InputUtil.readString("Entrer votre code (format e.g: CPT-12345): ");
			ValidationUtil.isValidCode(codeSource);

			String codeDest = InputUtil.readString("Entrer le code du compte destinaire: ");
			ValidationUtil.isValidCode(codeDest);
			
			Double amount = InputUtil.readDouble("Entrer le montant que vous voudrez verser: ");
			ValidationUtil.isValidAmount(amount);
			
			bankSer.virement(codeSource, codeDest, amount);
			
			System.out.println("Versement effectue avec success");
		} catch (Exception e) {
			System.out.println("Erreur et servenue au niveau du versement : " + e.getMessage());
		}
		
	}
}

