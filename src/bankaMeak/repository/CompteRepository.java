package bankaMeak.repository;

import bankaMeak.model.Compte;

import bankaMeak.exception.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CompteRepository {
	String generatedNextCode();
    void ajouterCompte(Compte compte);
    Compte chercherCompte(String code) throws CompteNotFoundException;
    Collection<Compte> getAllComptes();
    Compte getLastCreatedCompte();
}
