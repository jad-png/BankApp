package bankaMeak.command;

import bankaMeak.service.BankService;
import bankaMeak.ui.CreateCompteMenu;

public class CreateCompteCommand implements Command {
	private BankService bankService;
    public CreateCompteCommand(BankService bankService) { this.bankService = bankService; }
    
    
    public void execute() {
    	new CreateCompteMenu(bankService).execute();
    }
}
