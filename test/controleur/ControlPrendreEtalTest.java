package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}
	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal, "Le constructeur ne renvoie pas null");
	}
	
	@Test
	void testResteEtals(){
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.resteEtals());
		int newNbEtal = (village.donnerNbEtal())-5;
		assertFalse(controlPrendreEtal.resteEtals());
	}
	
	@Test
	void testPrendreEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		Gaulois obelix = new Gaulois("Gaulois", 15);
		village.ajouterHabitant(obelix);
		assertTrue(controlPrendreEtal.resteEtals());
	}
	
	@Test
	void testverifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite= new ControlVerifierIdentite(village);
		Gaulois asterix = new Gaulois("Asterix", 10);
		village.ajouterHabitant(asterix);
		assertTrue(controlVerifierIdentite.verifierIdentite("Asterix"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Cesar"));
	}
	
}
