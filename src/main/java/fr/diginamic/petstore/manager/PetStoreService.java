package fr.diginamic.petstore.manager;

import fr.diginamic.petstore.dao.DaoFactory;
import fr.diginamic.petstore.dao.PetStoreDao;
import fr.diginamic.petstore.entity.Address;
import fr.diginamic.petstore.entity.PetStore;
import fr.diginamic.petstore.utils.ReadMessage;
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
    ReadMessage readMessage;
    private final PetStoreDao petStoreDao;

    public PetStoreService() {
        this.petStoreDao = DaoFactory.getPetStoreDao();
    }

    public PetStore addPetStore(String name, String managerName, Address address) {
//        BusinessException businessException = new BusinessException();
        this.validatePetShop(name, managerName, address);
        PetStore petStore;
//        if (businessException.hasNoErrors()) {
            petStore = new PetStore();
            petStore.setName(name);
            petStore.setManagerName(managerName);
            petStore.setAddress(address);
            petStoreDao.createPetStore(petStore);
//        } else {
//            List<Integer> ErrorMessages = businessException.getErrorCodesList();
//            for (Integer errorCode : ErrorMessages) {
//                LOGGER.error(readMessage.getErrorMessage(errorCode));
//            }
//            throw businessException;
//        }
        return petStore;
    }

    private void validatePetShop(String name, String managerName, Address address) {
        if (name == null || name.trim().length() > 50 || managerName == null || managerName.trim().length() > 50 || address == null) {
//            businessException.addError(ErrorCodesService.PET_SHOP_CREATION_RULES);
        }
    }

}