package bankaMeak.command;

import bankaMeak.service.BankService;
import bankaMeak.ui.RetraitMenu;

public class RetraitCommand implements Command {
	private BankService bankService;
    public RetraitCommand(BankService bankService) { this.bankService = bankService; }
    
   public void execute() {
	   new RetraitMenu(bankService).execute();
   }
}
