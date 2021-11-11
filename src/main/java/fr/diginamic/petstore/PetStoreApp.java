package fr.diginamic.petstore;

import fr.diginamic.petstore.entity.Address;
import fr.diginamic.petstore.entity.FishLivEnv;
import fr.diginamic.petstore.entity.PetStore;
import fr.diginamic.petstore.manager.AddressService;
import fr.diginamic.petstore.manager.AnimalService;
import fr.diginamic.petstore.manager.PetStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;


public class PetStoreApp {

	private static final Logger LOGGER = LoggerFactory.getLogger( PetStoreApp.class );

	
	public static void main(String[] args) throws Exception {
		PetStoreService petStoreService = new PetStoreService();
		AddressService addressService = new AddressService();
		AnimalService animalService = new AnimalService();

		//Dates
		Date date = new Date(120, 4, 19);
		Date date1 = new Date(121, 7, 25);
		Date date2 = new Date(120, 4, 12);

		//Addresses
		Address address = addressService.addAddress("1", "Place du test", "44100", "Nantes");
		Address address1 = addressService.addAddress("15", "Rue du test", "44220", "Couëron");
		Address address2 = addressService.addAddress("25", "Avenue du testeur fou", "85530", "Montaigu");

		//Pet stores
		PetStore store = petStoreService.addPetStore("Aux animaux de Tibo", "Tibo Pfeifer", address);
		PetStore store1 = petStoreService.addPetStore("Donne ta langue au chat", "Robert Patulacci", address1);
		PetStore store2 = petStoreService.addPetStore("Comme un poisson dans l'eau", "Keanu Reeves", address2);

		//Animals
		animalService.addCat(date, "Grey/White","IO02316848");
		animalService.addCat(date1, "Black","IO02316848");
		animalService.addFish(date2, "Saphire", FishLivEnv.FRESH_WATER);


	}
}
