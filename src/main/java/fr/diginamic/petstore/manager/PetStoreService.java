package fr.diginamic.petstore.manager;

import fr.diginamic.petstore.dao.DaoFactory;
import fr.diginamic.petstore.dao.PetStoreDao;
import fr.diginamic.petstore.entity.Address;
import fr.diginamic.petstore.entity.PetStore;
import fr.diginamic.petstore.entity.ProdType;
import fr.diginamic.petstore.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class PetShopService
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public class PetStoreService {
    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PetStoreService.class);
    /**
     * The Pet store dao.
     */
    private final PetStoreDao petStoreDao;

    /**
     * Instantiates a new Pet store service.
     */
    public PetStoreService() {
        this.petStoreDao = DaoFactory.getPetStoreDao();
    }

    // -- Functions --

    /**
     * Add pet store pet store.
     *
     * @param name        the name
     * @param managerName the manager name
     * @param address     the address
     * @return the pet store
     * @throws ServiceException the service exception
     */
    public PetStore addPetStore(String name, String managerName, Address address) throws ServiceException {
        this.validatePetShop(name, managerName, address);
        PetStore petStore;
        petStore = new PetStore();
        petStore.setName(name);
        petStore.setManagerName(managerName);
        petStore.setAddress(address);
        petStoreDao.createPetStore(petStore);
        LOGGER.info("Store created.");
        return petStore;
    }

    /**
     * Update pet store.
     *
     * @param storeId      the store id
     * @param name         the store name
     * @param streetNumber the store street number
     * @param street       the store street
     * @param zipCode      the store zip code
     * @param city         the store city
     * @param managerName  the store manager name
     */
    public void updatePetStore(Long storeId, String name, String streetNumber, String street,
                               String zipCode, String city, String managerName) throws ServiceException {
        this.validatePetShopUpdate(name, streetNumber, street, zipCode, city, managerName);

        PetStore store = petStoreDao.getStoreById(storeId);
        Address address = new Address();
        address.setNumber(streetNumber);
        address.setStreet(street);
        address.setZipCode(zipCode);
        address.setCity(city);

        store.setName(name);
        store.setAddress(address);
        store.setManagerName(managerName);
        petStoreDao.updatePetStore(store);
        LOGGER.info("Store updated.");
    }

    /**
     * Delete pet store.
     *
     * @param storeId the store id
     */
    public void deletePetStore(Long storeId) {
        petStoreDao.deletePetStore(storeId);
        LOGGER.info("Store deleted.");
    }

    /**
     * See animals.
     *
     * @param storeId the store id
     */
    public void seeAnimals(Long storeId) {
        petStoreDao.seeAnimals(storeId);
    }

    /**
     * See animals by specie.
     *
     * @param storeId the store id
     * @param specie  the specie
     */
    public void seeAnimalsPerSpecie(Long storeId, String specie) {
        petStoreDao.seeAnimalsBySpecie(storeId, specie);
    }

    /**
     * See products.
     *
     * @param storeId the store id
     */
    public void seeProducts(Long storeId) {
        petStoreDao.seeProducts(storeId);
    }

    /**
     * See products per type.
     *
     * @param storeId  the store id
     * @param prodType the prod type
     */
    public void seeProductsPerType(Long storeId, ProdType prodType) {
        petStoreDao.seeProductsPerType(storeId, prodType);
    }

    // -- Validations --
    //TODO: 13/11/2021 --> will be useful in further updates when the client UI will be implemented, this will evolve in the future

    /**
     * Validate pet shop.
     *
     * @param name        the name
     * @param managerName the manager name
     * @param address     the address
     * @throws ServiceException the service exception
     */
    private void validatePetShop(String name, String managerName, Address address) throws ServiceException {
        if (name == null || name.trim().length() > 50 || managerName == null || managerName.trim().length() > 50 || address == null) {
            throw new ServiceException("Validation constraint not passed.");
        }
    }

    private void validatePetShopUpdate(String name, String streetNumber, String street,
                                       String zipCode, String city, String managerName) throws ServiceException {
        if (name == null || name.trim().length() > 50 || streetNumber == null || streetNumber.trim().length() > 10 ||
                street == null || street.trim().length() > 50 || managerName == null || managerName.trim().length() > 50 ||
                zipCode == null || zipCode.trim().length() > 10 || city == null || city.trim().length() > 50) {
            throw new ServiceException("Validation constraint not passed.");
        }
    }
}