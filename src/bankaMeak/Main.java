package bankaMeak;

import java.util.Scanner;

import bankaMeak.service.BankService;
import bankaMeak.util.*;
import bankaMeak.ui.*;

public class Main {
	
	public static void main(String[] args) {
		BankService bankSer = new BankService();
		
		try {
			int choice; 
			do {
				   System.out.println("\n===== MENU BANCAIRE =====");
				   System.out.println("1. Créer un compte");
	               System.out.println("2. Effectuer un versement");
	               System.out.println("3. Effectuer un retrait");
	               System.out.println("4. Effectuer un virement");
	               System.out.println("5. Consulter solde");
	               System.out.println("6. Consulter opérations");
	               System.out.println("0. Quitter");
	                
	               choice = InputUtil.readInt("Entrer votre choix: ");
	               
	               switch (choice) {
	               		case 1: 
	               			new CreateCompteMenu(bankSer).execute();
	            	   		break;
	               		case 2: 
	               			new VersementMenu(bankSer).execute();
	            	   		break;
	               		case 3: 
	               			 new RetraitMenu(bankSer).execute();
	            	   		break;
	               		case 4: 
	               			 new VirementMenu(bankSer).execute();
	            	   		break;
	               		case 5:
	               			// ConsulterSoldeMenu	               			
	               			break;
	               		case 6:
	               			// ConsulterOperationsMenu
	               			break;
	               		case 0:
	                        System.out.println("Merci d'avoir utilisé notre système bancaire !");
	               			break;
	               		default: 
	               			System.out.println("Choix invalide !");
	               }
			} while (choice != 0)
		} catch (Exception e) {
			System.err.println("Une erreur est servenue :" + e.getMessage());
			e.printStackTrace();
		}
	}
}
