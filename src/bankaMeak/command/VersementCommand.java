package bankaMeak.command;

import bankaMeak.exception.CompteNotFoundException;
import bankaMeak.service.BankService;
import bankaMeak.ui.VersementMenu;

public class VersementCommand implements Command {
	private BankService bankService;
    public VersementCommand(BankService bankService) { this.bankService = bankService; }

    public void execute() throws CompteNotFoundException {
    	new VersementMenu(bankService).execute();
    }
}
