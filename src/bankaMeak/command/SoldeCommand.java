package bankaMeak.command;

import bankaMeak.exception.CompteNotFoundException;
import bankaMeak.exception.SoldeInsuffisantException;
import bankaMeak.service.BankService;
import bankaMeak.ui.ConsulterSoldeMenu;

public class SoldeCommand implements Command {
	private BankService bankService;
    public SoldeCommand(BankService bankService) { this.bankService = bankService; }
    
    public void execute() throws SoldeInsuffisantException {
    	new ConsulterSoldeMenu(bankService).execute();
    }
}
