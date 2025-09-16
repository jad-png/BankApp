package bankaMeak.util;

public class ValidationUtil {
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
}
