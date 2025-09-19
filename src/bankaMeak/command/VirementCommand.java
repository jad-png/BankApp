package bankaMeak.command;

import bankaMeak.service.BankService;
import bankaMeak.ui.VirementMenu;

public class VirementCommand implements Command {
	private BankService bankService;
    public VirementCommand(BankService bankService) { this.bankService = bankService; }

    public void execute() {
    	new VirementMenu(bankService).execute();
    }
}
