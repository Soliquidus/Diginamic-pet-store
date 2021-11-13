package fr.diginamic.petstore.dao;

/**
 * Regroups all the Entity DAOs
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public abstract class DaoFactory {

    /**
     * Gets pet store dao.
     *
     * @return the pet store dao
     */
    public static PetStoreDao getPetStoreDao() {
        return new PetStoreDaoImpl();
    }


    /**
     * Gets product dao.
     *
     * @return the product dao
     */
    public static ProductDao getProductDao() {
        return new ProductDaoImpl();
    }

    /**
     * Gets animal dao.
     *
     * @return the animal dao
     */
    public static AnimalDao getAnimalDao() {
        return new AnimalDaoImpl();
    }
}