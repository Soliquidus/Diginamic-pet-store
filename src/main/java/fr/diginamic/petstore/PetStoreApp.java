package fr.diginamic.petstore;

import fr.diginamic.petstore.entity.ProdType;
import fr.diginamic.petstore.manager.AnimalService;
import fr.diginamic.petstore.manager.PetStoreService;
import fr.diginamic.petstore.manager.ProductService;

public class PetStoreApp {

    public static void main(String[] args) {
        //Service manager
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
        animalService.seeAllAnimalsPerSpecie("cat");

        // -- Products --

        //See all products in database
        productService.seeAllProducts();
        //See all products per type in database
        productService.seeAllProductsPerType(ProdType.CLEANING);

        // ---- Insert functions ----
        
        
        // ---- Update functions ----
        /// TODO: 12/11/2021  

        // ---- Delete functions ----
        /// TODO: 12/11/2021
    }
}
