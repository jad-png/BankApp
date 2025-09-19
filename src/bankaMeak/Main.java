package bankaMeak;

import java.util.Scanner;


import bankaMeak.service.BankService;
import bankaMeak.repository.CompteRepository;
import bankaMeak.util.*;
import bankaMeak.ui.*;

public class Main {
	
	public static void main(String[] args) {
		CompteRepository repo = new CompteRepository();
		BankService bankSer = new BankService(repo);
		
		new BankUI(bankSer).start();
	}
}
