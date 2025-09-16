package bankaMeak;

import java.util.Scanner;

import bankaMeak.service.BankService;
import bankaMeak.util.*;

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
	            	   		break;
	               		case 2: 
	            	   		break;
	               		case 3: 
	            	   		break;
	               		case 4: 
	            	   		break;
	               		case 5:
	               			break;
	               		case 6: 
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
