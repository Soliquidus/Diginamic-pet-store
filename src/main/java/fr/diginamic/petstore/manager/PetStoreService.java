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
 * @date 09 /11/2021
 */
public class PetStoreService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PetStoreService.class);
    private final PetStoreDao petStoreDao;

    public PetStoreService() {
        this.petStoreDao = DaoFactory.getPetStoreDao();
    }

    public PetStore addPetStore(String name, String managerName, Address address) throws ServiceException {
        this.validatePetShop(name, managerName, address);
        PetStore petStore;
        petStore = new PetStore();
        petStore.setName(name);
        petStore.setManagerName(managerName);
        petStore.setAddress(address);
        petStoreDao.createPetStore(petStore);
        return petStore;
    }

    public void seeAnimals(Long storeId) {
        petStoreDao.seeAnimals(storeId);
    }

    public void seeAnimalsPerSpecie(Long storeId, String specie) {
        petStoreDao.seeAnimalsPerSpecie(storeId, specie);
    }

    public void seeProducts(Long storeId) {
        petStoreDao.seeProducts(storeId);
    }

    public void seeProductsPerType(Long storeId, ProdType prodType) {
        petStoreDao.seeProductsPerType(storeId, prodType);
    }

    private void validatePetShop(String name, String managerName, Address address) throws ServiceException {
        if (name == null || name.trim().length() > 50 || managerName == null || managerName.trim().length() > 50 || address == null) {
            throw new ServiceException("Validation constraint not passed.");
        }
    }

}