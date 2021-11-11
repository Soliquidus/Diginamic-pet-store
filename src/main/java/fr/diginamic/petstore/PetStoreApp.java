package fr.diginamic.petstore;

import fr.diginamic.petstore.entity.*;
import fr.diginamic.petstore.manager.AddressService;
import fr.diginamic.petstore.manager.AnimalService;
import fr.diginamic.petstore.manager.PetStoreService;
import fr.diginamic.petstore.manager.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;


public class PetStoreApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(PetStoreApp.class);


    public static void main(String[] args) {
        //Service manager
        PetStoreService petStoreService = new PetStoreService();
        AddressService addressService = new AddressService();
        AnimalService animalService = new AnimalService();
        ProductService productService = new ProductService();

        //Dates
        Date date = new Date(120, 4, 19);
        Date date1 = new Date(121, 7, 25);
        Date date2 = new Date(120, 4, 12);
        Date date3 = new Date(121, 3, 17);
        Date date4 = new Date(120, 2, 14);
        Date date5 = new Date(121, 6, 2);
        Date date6 = new Date(119, 9, 29);
        Date date7 = new Date(120, 8, 16);

        //Addresses
        Address address = addressService.addAddress("1", "Place du test", "44100", "Nantes");
        Address address1 = addressService.addAddress("15", "Rue du test", "44220", "Couëron");
        Address address2 = addressService.addAddress("25", "Avenue du testeur fou", "85530", "Montaigu");

        //Pet stores
        PetStore animaux = petStoreService.addPetStore("Aux animaux de Tibo", "Tibo Pfeifer", address);
        PetStore langueAuChat = petStoreService.addPetStore("Donne ta langue au chat", "Robert Patulacci", address1);
        PetStore poissonDansEau = petStoreService.addPetStore("Comme un poisson dans l'eau", "Keanu Reeves", address2);

        //Animals
        Animal cat = animalService.addCat(date, "Grey/White", "IO02316848");
        Animal cat1 = animalService.addCat(date1, "Black", "IO0458654");
        Animal cat2 = animalService.addCat(date2, "Orange", "IO0564571");
        Animal cat3 = animalService.addCat(date3, "White", "IO0987564");
        Animal fish = animalService.addFish(date4, "Sapphire", FishLivEnv.FRESH_WATER);
        Animal fish1 = animalService.addFish(date5, "Cobalt", FishLivEnv.SEA_WATER);
        Animal fish2 = animalService.addFish(date6, "Grey", FishLivEnv.FRESH_WATER);
        Animal fish3 = animalService.addFish(date7, "Blue Pan", FishLivEnv.SEA_WATER);


        //Products
        Product brosse = productService.addProduct("AC", "Brosse à puce", ProdType.ACCESSORY, 19.99);
        Product antiPuce = productService.addProduct("PR", "Produit anti-puce", ProdType.CLEANING, 14.99);
        Product balle = productService.addProduct("JO", "Balle de jeu", ProdType.ACCESSORY, 13.50);
        Product laisse = productService.addProduct("AC", "Laisse pour chat", ProdType.ACCESSORY, 9.99);
        Product croquettes = productService.addProduct("NO", "Croquettes pour chat", ProdType.FOOD, 23.75);
        Product nourriturePoisson = productService.addProduct("NO", "Nourriture pour poisson", ProdType.FOOD, 16.50);
        Product nettoyageAquarium = productService.addProduct("NE", "Nettoyant pour Aquarium", ProdType.CLEANING, 16.75);


        //Add animals to shops
//        animalService.addToStore(animaux.getId(), cat.getId());
//        animalService.addToStore(animaux.getId(), cat1.getId());
//        animalService.addToStore(animaux.getId(), fish.getId());
//        animalService.addToStore(animaux.getId(), fish1.getId());
//        animalService.addToStore(langueAuChat.getId(), cat2.getId());
//        animalService.addToStore(langueAuChat.getId(), cat3.getId());
//        animalService.addToStore(poissonDansEau.getId(), fish2.getId());
//        animalService.addToStore(poissonDansEau.getId(), fish3.getId());

        //Add products to shops
//        productService.addToStore(animaux.getId(), brosse.getId());
//        productService.addToStore(animaux.getId(), antiPuce.getId());
//        productService.addToStore(animaux.getId(), balle.getId());
//        productService.addToStore(animaux.getId(), laisse.getId());
//        productService.addToStore(animaux.getId(), croquettes.getId());
//        productService.addToStore(animaux.getId(), nourriturePoisson.getId());
//        productService.addToStore(animaux.getId(), nettoyageAquarium.getId());
//        productService.addToStore(langueAuChat.getId(), brosse.getId());
//        productService.addToStore(langueAuChat.getId(), antiPuce.getId());
//        productService.addToStore(langueAuChat.getId(), balle.getId());
//        productService.addToStore(langueAuChat.getId(), laisse.getId());
//        productService.addToStore(langueAuChat.getId(), croquettes.getId());
//        productService.addToStore(poissonDansEau.getId(), nourriturePoisson.getId());
//        productService.addToStore(poissonDansEau.getId(), nettoyageAquarium.getId());
    }
}
