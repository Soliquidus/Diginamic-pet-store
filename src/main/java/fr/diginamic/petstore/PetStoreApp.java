package fr.diginamic.petstore;

import fr.diginamic.petstore.entity.*;
import fr.diginamic.petstore.exception.ServiceException;
import fr.diginamic.petstore.manager.AddressService;
import fr.diginamic.petstore.manager.AnimalService;
import fr.diginamic.petstore.manager.PetStoreService;
import fr.diginamic.petstore.manager.ProductService;
import fr.diginamic.petstore.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.sql.Date;

public class PetStoreApp {

    public static void main(String[] args) throws ServiceException {

        //Entity Manager
        EntityManager em = HibernateUtil.getInstance();

        //Service manager
        AddressService addressService = new AddressService();
        PetStoreService petStoreService = new PetStoreService();
        AnimalService animalService = new AnimalService();
        ProductService productService = new ProductService();

        // ---- Read functions ----

        //-- PetStore --

        //See all animals from one store
        petStoreService.seeAnimals(1L);
        //See all animals of one specie from one store
        petStoreService.seeAnimalsPerSpecie(1L, "cat");
        //See all products from one store
        petStoreService.seeProducts(1L);
        //See all products per type from one store
        petStoreService.seeProductsPerType(1L, ProdType.ACCESSORY);

        //-- Animals --

        //See all animals in database
        animalService.seeAllAnimals();
        //See all animals pers specie in database
        animalService.seeAllAnimalsBySpecie("cat");

        // -- Products --

        //See all products in database
        productService.seeAllProducts();
        //See all products per type in database
        productService.seeAllProductsByType(ProdType.CLEANING);

        // ---- Insert functions ----
        Address address = addressService.addAddress("24", "Avenue du grand Testeur", "66666", "Test-en-Retz");
        PetStore store = petStoreService.addPetStore("Test Store", "Testeur fou", address);
        Date date1 = new Date(119, 7, 22);
        Animal fish = animalService.addFish(date1, "Rainbow", FishLivEnv.FRESH_WATER);
        Product product = productService.addProduct("AC", "Arbre à chat", ProdType.ACCESSORY, 29.99);

        // ---- Add functions ----
        productService.addToStore(store.getId(), product.getId());
        animalService.addToStore(store.getId(), fish.getId());

        // ---- Update functions ----
        Date date2 = new Date(120, 4, 12);
        animalService.updateCat(3L, date2, "Ginger", "IO38541");
        petStoreService.updatePetStore(3L, "The Matrix of Animals", "12", "Testing Street", "CA4981", "Test City", "Keanu Reeves");
        productService.updateProduct(4L, "AC", "Laisse pour chat non étranglante", ProdType.ACCESSORY,12.75);

        // ---- Delete functions ----
//        animalService.deleteAnimal(fish.getId());
//        productService.deleteProduct(product.getId());
//        petStoreService.deletePetStore(store.getId());

        em.close();
    }
}
