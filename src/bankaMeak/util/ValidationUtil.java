package bankaMeak.util;

import java.util.Arrays;
import java.util.List;

import bankaMeak.model.SourceVersement;

public class ValidationUtil {
	
    private static final List<String> ALLOWED_DESTINATIONS = Arrays.asList("ATM", "AGENCE", "ONLINE");

	// TODO: Here in this class i need to add a method that checks the code format, positive amounts, ids, and password verification
	public static boolean isValidCode(String code) {
		if (code == null) return false;
		return code.matches("^CPT-\\d{5}$");
	}
	
	public static boolean isValidAmount(double montant) {
		return montant > 0;
	}
	
	public static void validateCode(String code) {
		if (!isValidCode(code)) {
			throw new IllegalArgumentException("Code invlide. Format attendu: CPT-00001");
		}
	}
	
	public static void validateAmount(double montant) {
		if (!isValidAmount(montant)) {
			throw new IllegalArgumentException("Montant invalide, il doit etre positif");
		}
	}
	
	public static boolean isValidName(String name) {
		if(name == null) return false;
		return name.matches("[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]");
	}
	
	public static void validateName(String name) {
		if (!isValidName(name)) {
			throw new IllegalArgumentException("Nom d'utilisateur invalide.");
		}
	}
	
	public static void validateDestination(String destination) {
        if (destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("La destination ne peut pas etre vide");
        }
        String upperDest = destination.toUpperCase();
        if (!ALLOWED_DESTINATIONS.contains(upperDest)) {
            throw new IllegalArgumentException("Destination invalide. Options valides : " + ALLOWED_DESTINATIONS);
        }
    }
	
	public static SourceVersement validateSource(int choice) {
        switch (choice) {
            case 1: return SourceVersement.AGENCY;
            case 2: return SourceVersement.ATM;
            case 3: return SourceVersement.ONLINE;
            case 4: return SourceVersement.MOBILE;
            default: throw new IllegalArgumentException("Source invalide !");
        }
    }
}
