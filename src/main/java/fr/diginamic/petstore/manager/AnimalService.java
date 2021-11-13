package fr.diginamic.petstore.manager;

import fr.diginamic.petstore.dao.AnimalDao;
import fr.diginamic.petstore.dao.DaoFactory;
import fr.diginamic.petstore.entity.Animal;
import fr.diginamic.petstore.entity.Cat;
import fr.diginamic.petstore.entity.Fish;
import fr.diginamic.petstore.entity.FishLivEnv;
import fr.diginamic.petstore.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;

/**
 * Class PetShopService
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public class AnimalService {
    /**
     * The Animal dao.
     */
    private final AnimalDao animalDao;

    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AnimalService.class);

    /**
     * Instantiates a new Animal service.
     */
    public AnimalService() {
        this.animalDao = DaoFactory.getAnimalDao();
    }

    //-- Functions --

    /**
     * Add cat animal.
     *
     * @param birth  the birth
     * @param color  the color
     * @param chipId the chip id
     * @return the animal
     */
    public Animal addCat(Date birth, String color, String chipId) {
        Cat cat = new Cat();
        cat.setBirth(birth);
        cat.setColor(color);
        cat.setChipId(chipId);
        animalDao.createAnimal(cat);
        LOGGER.info("Cat created.");
        return cat;
    }

    /**
     * Add fish animal.
     *
     * @param birth     the birth
     * @param color     the color
     * @param livingEnv the living env
     * @return the animal
     */
    public Animal addFish(Date birth, String color, FishLivEnv livingEnv) {
        Fish fish = new Fish();
        fish.setBirth(birth);
        fish.setColor(color);
        fish.setLivingEnv(livingEnv);
        animalDao.createAnimal(fish);
        LOGGER.info("Fish created");
        return fish;
    }

    /**
     * Update cat.
     *
     * @param catId  the cat id
     * @param birth  the birth
     * @param color  the color
     * @param chipId the chip id
     * @throws ServiceException the service exception
     */
    public void updateCat(Long catId, Date birth, String color, String chipId) throws ServiceException{
        this.validateCat(birth, color, chipId);
        Cat cat = animalDao.getCatById(catId);
        cat.setColor(color);
        cat.setBirth(birth);
        cat.setChipId(chipId);
        animalDao.updateAnimal(cat);
        LOGGER.info("Cat updated.");
    }

    /**
     * Update fish.
     *
     * @param fishId     the fish id
     * @param birth      the birth
     * @param color      the color
     * @param fishLivEnv the fish liv env
     * @throws ServiceException the service exception
     */
    public void updateFish(Long fishId, Date birth, String color, FishLivEnv fishLivEnv) throws ServiceException {
        this.validateFish(birth, color, fishLivEnv);
        Fish fish = animalDao.getFishById(fishId);
        fish.setColor(color);
        fish.setBirth(birth);
        fish.setLivingEnv(fishLivEnv);
        animalDao.updateAnimal(fish);
        LOGGER.info("Fish updated.");
    }

    /**
     * Delete animal.
     *
     * @param animalId the animal id
     */
    public void deleteAnimal(Long animalId){
        animalDao.deleteAnimal(animalId);
        LOGGER.info("Animal deleted.");
    }

    /**
     * See all animals.
     */
    public void seeAllAnimals(){
        animalDao.seeAllAnimals();
    }

    /**
     * See all animals per specie.
     *
     * @param specie the specie
     */
    public void seeAllAnimalsBySpecie(String specie){
        animalDao.seeAllAnimalsBySpecie(specie);
    }

    /**
     * Add to store.
     *
     * @param storeId  the store id
     * @param animalId the animal id
     */
    public void addToStore(Long storeId, Long animalId ){
        animalDao.addAnimalToStore(storeId, animalId );
    }
    
    //-- Validations --
    //TODO: 13/11/2021 --> will be useful in further updates when the client UI will be implemented, this will evolve in the future

    /**
     * Validate cat.
     *
     * @param birth  the birth
     * @param color  the color
     * @param chipId the chip id
     * @throws ServiceException the service exception
     */
    private void validateCat(Date birth, String color, String chipId) throws ServiceException {
        if (birth == null || color == null || color.trim().length() > 50 ||
                chipId == null || chipId.trim().length() > 50 ) {
            throw new ServiceException("Validation constraint not passed.");
        }
    }

    /**
     * Validate fish.
     *
     * @param birth      the birth
     * @param color      the color
     * @param fishLivEnv the fish liv env
     * @throws ServiceException the service exception
     */
    private void validateFish(Date birth, String color, FishLivEnv fishLivEnv) throws ServiceException {
        if (birth == null || color == null || color.trim().length() > 50 ||
                fishLivEnv == null ) {
            throw new ServiceException("Validation constraint not passed.");
        }
    }

}