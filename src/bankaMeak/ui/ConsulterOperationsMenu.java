package bankaMeak.ui;

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
				String code = InputUtil.readString("Saisir le code de vote compte : ");
				ValidationUtil.validateCode(code);
				
				bankSer.listerOperations(code);
				System.out.println("test");
			} catch (Exception e) {
				System.out.println("Erreur : " + e.getMessage());
			}
		}
}
