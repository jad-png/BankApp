package bankaMeak.ui;

import bankaMeak.service.*;
import bankaMeak.util.InputUtil;
import bankaMeak.util.ValidationUtil;

public class RetraitMenu {
	BankService bankSer;
	
	public RetraitMenu(BankService bankService) {
		this.bankSer = bankService;
	}
	
	public void execute() {
		try {
			String code = InputUtil.readString("Entrer le code ud compte (format: CPT-12345): ");
			ValidationUtil.validateCode(code);
			
			double montant = InputUtil.readDouble("ENtrer le montant qu vous voudrer retrait: ");
			ValidationUtil.validateAmount(montant);
			
			String destination = InputUtil.readString("Saisir la destination du retrait: ");
			ValidationUtil.validateDestination(destination);
			
			bankSer.retrait(code, montant, destination);
			
			System.out.println("Retrait effectue avec succes depuis : " + destination);
		} catch (Exception e) {
			System.out.println("Errur est servenue : " + e.getMessage());
		}
	}
}
