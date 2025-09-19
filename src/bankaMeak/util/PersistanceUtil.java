package bankaMeak.util;

import bankaMeak.model.Compte;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class PersistanceUtil {
	public static void saveData(List<Compte> comptes, String filename) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(comptes);
		}
	}
	
	public static List<Compte> loadData(String filename) throws IOException {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Compte>) ois.readObject();
		}
	}
}
