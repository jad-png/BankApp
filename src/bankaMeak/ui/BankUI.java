package bankaMeak.ui;

import bankaMeak.service.BankService;
import bankaMeak.util.InputUtil;
import bankaMeak.exception.*;

import java.util.HashMap;
import java.util.Map;

import bankaMeak.command.*;

public class BankUI {
	private BankService bankSer;
	private Map<Integer, Command> menuCommands = new HashMap<>();

    public BankUI(BankService bankService) {
        this.bankSer = bankService;
        initializeCommands();
    }

    public void start() {
        try {
            int choice;
            do {
                showMenu();
                choice = InputUtil.readInt("Entrer votre choix: ");
                executeCommand(choice);
            } while (choice != 0);
        } catch (Exception e) {
            System.err.println("Erreur inattendue : " + e.getMessage());
            e.printStackTrace();
        } 
    }
    
    private void executeCommand(int choice) {
        Command command = menuCommand.get(choice);
        if (command != null) {
            try {
                command.execute();
            } catch (Exception e) {
                System.err.println("Erreur inattendue : " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Choix invalide !");
        }
    }

    private void showMenu() {
        System.out.println("\n===== MENU BANCAIRE =====");
        System.out.println("1. Créer un compte");
        System.out.println("2. Effectuer un versement");
        System.out.println("3. Effectuer un retrait");
        System.out.println("4. Effectuer un virement");
        System.out.println("5. Consulter solde");
        System.out.println("6. Consulter opérations");
        System.out.println("0. Quitter");
    }
    
    private void initializeCommands() {
        menuCommands.put(1, new CreateCompteCommand(bankSer));
        menuCommands.put(2, new VersementCommand(bankSer));
        menuCommands.put(3, new RetraitCommand(bankSer));
        menuCommands.put(4, new VirementCommand(bankSer));
        menuCommands.put(5, new SoldeCommand(bankSer));
        menuCommands.put(6, new OperationsCommand(bankSer));
        menuCommands.put(0, () -> System.out.println("Merci d'avoir utilisé notre système bancaire !"));
    }
}
