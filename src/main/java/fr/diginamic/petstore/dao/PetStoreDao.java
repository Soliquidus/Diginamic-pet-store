package fr.diginamic.petstore.dao;

import fr.diginamic.petstore.entity.PetStore;
import fr.diginamic.petstore.entity.ProdType;

public interface PetStoreDao {
    void createPetStore(PetStore petStore);
    void seeAnimals(Long storeId);
    void seeAnimalsPerSpecie(Long storeId, String specie);
    void seeProducts(Long storeId);
    void seeProductsPerType(Long storeId, ProdType prodType);
}
