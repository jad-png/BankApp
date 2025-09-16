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
}
