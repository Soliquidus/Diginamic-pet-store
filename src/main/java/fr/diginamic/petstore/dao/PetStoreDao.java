package fr.diginamic.petstore.dao;

import fr.diginamic.petstore.entity.PetStore;
import fr.diginamic.petstore.entity.ProdType;

/**
 * The DAO for PetStore Entity
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public interface PetStoreDao {
    /**
     * Create pet store.
     *
     * @param petStore the pet store
     */
    void createPetStore(PetStore petStore);

    /**
     * Update pet store.
     *
     * @param store the store
     */
    void updatePetStore(PetStore store);

    /**
     * Delete pet store.
     *
     * @param storeId the store id
     */
    void deletePetStore(Long storeId);

    /**
     * Gets store by id.
     *
     * @param storeId the store id
     * @return the store by id
     */
    PetStore getStoreById(Long storeId);

    /**
     * See animals.
     *
     * @param storeId the store id
     */
    void seeAnimals(Long storeId);

    /**
     * See animals by specie.
     *
     * @param storeId the store id
     * @param specie  the specie
     */
    void seeAnimalsBySpecie(Long storeId, String specie);

    /**
     * See products.
     *
     * @param storeId the store id
     */
    void seeProducts(Long storeId);

    /**
     * See products per type.
     *
     * @param storeId  the store id
     * @param prodType the prod type
     */
    void seeProductsPerType(Long storeId, ProdType prodType);
}
