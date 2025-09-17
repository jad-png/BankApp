package bankaMeak.ui;

import bankaMeak.service.BankService;
import bankaMeak.util.InputUtil;
import bankaMeak.util.ValidationUtil;
import bankaMeak.model.SourceVersement;

public class VersementMenu {
    private BankService bankSer;

    public VersementMenu(BankService bankService) {
        this.bankSer = bankService;
    }

    public void execute() {
        try {
            String code = InputUtil.readString("Saisir votre code (format: CPT-12345): ");
            ValidationUtil.validateCode(code);

            double montant = InputUtil.readDouble("Saisir le montant à verser: ");
            ValidationUtil.validateAmount(montant);

            System.out.println("Choisir la source du versement:");
            System.out.println("1. Agence bancaire");
            System.out.println("2. Distributeur (ATM)");
            System.out.println("3. En ligne");
            System.out.println("4. Mobile");
            int choice = InputUtil.readInt("Votre choix: ");

            SourceVersement source = ValidationUtil.validateSource(choice);

            // TODO: Call service to handle deposit
            bankSer.versement(code, montant, source);

            System.out.println("Versement effectué avec succès depuis: " + source);

        } catch (IllegalArgumentException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }
}
