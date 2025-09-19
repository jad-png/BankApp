package bankaMeak;

import bankaMeak.service.BankService;
import bankaMeak.repository.*;
import bankaMeak.ui.*;

public class Main {
	
	public static void main(String[] args) {
		CompteRepository repo = new InMemoryCompteRepository();
		BankService bankSer = new BankService(repo);
		
		new BankUI(bankSer).start();
	}
}
