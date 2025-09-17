package bankaMeak.ui;

import bankaMeak.service.*;
import bankaMeak.util.InputUtil;
import bankaMeak.util.ValidationUtil;

public class ConsulterSoldeMenu {
	private BankService bankSer;
	
	public ConsulterSoldeMenu(BankService bankSer) {
		this.bankSer = bankSer;
	}
	
	public void execute() {
		try {
			String code = InputUtil.readString("Saisir le code de vote compte : ");
			ValidationUtil.validateCode(code);
			
			bankSer.consulterSolde(code);
			System.out.println("test");
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
}
