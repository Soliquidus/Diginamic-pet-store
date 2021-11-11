package fr.diginamic.petstore.dao;

/**
 * Class DaoFactory
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public abstract class DaoFactory {

    public static PetStoreDao getPetStoreDao() {
        return new PetStoreDaoImpl();
    }

    public static ProductDao getProductDao() {
        return new ProductDaoImpl();
    }

    public static AnimalDao getAnimalDao() {
        return new AnimalDaoImpl();
    }
}