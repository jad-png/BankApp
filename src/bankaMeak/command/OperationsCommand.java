package bankaMeak.command;

import bankaMeak.service.BankService;
import bankaMeak.ui.ConsulterOperationsMenu;

public class OperationsCommand implements Command {
	private BankService bankService;
    public OperationsCommand(BankService bankService) { this.bankService = bankService; }
    
    public void execute() {
    	new ConsulterOperationsMenu(bankService).execute();
    }
}
