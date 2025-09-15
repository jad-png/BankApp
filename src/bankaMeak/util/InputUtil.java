package bankaMeak.util;
import java.util.Scanner;

class InputUtil {
	private static Scanner sc = new Scanner(System.in);
	
	public static int readInt(String msg) {
		System.out.print(msg);
		while (!sc.hasNextInt()) {
			System.out.println("Entree invalide");
			sc.next();
		}
		return sc.nextInt();
	}
	
	public static double readDouble(String msg) {
		System.out.print(msg);
		while (!sc.hasNextDouble()) {
			System.out.println("Entree invalide");
			sc.next();
		}
		return sc.nextDouble();
	}
	
	public static String readString(String msg) {
		System.out.println(msg);
		return sc.next();
	}
}
