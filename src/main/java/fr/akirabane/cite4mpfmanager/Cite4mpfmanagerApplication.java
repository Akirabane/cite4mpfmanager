package fr.akirabane.cite4mpfmanager;

import fr.akirabane.cite4mpfmanager.Implementations.CIDHibernateImpl;
import fr.akirabane.cite4mpfmanager.interfaces.CID;
import fr.akirabane.cite4mpfmanager.model.Units;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class Cite4mpfmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cite4mpfmanagerApplication.class, args);

		try {
			// Création d'un CID
			CIDHibernateImpl cid = new CIDHibernateImpl(10000);

			// Création d'une unité
			Units unit = new Units(1L, "OfC", "JUDGE", cid);

			// Affichage du matricule
			System.out.println("Matricule : " + unit.getMatricule());
			System.out.println(unit);
		} catch (IllegalArgumentException e) {
			System.err.println("Erreur : " + e.getMessage());
		}
	}

}
