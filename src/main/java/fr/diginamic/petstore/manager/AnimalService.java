package fr.diginamic.petstore.manager;

import fr.diginamic.petstore.dao.AnimalDao;
import fr.diginamic.petstore.dao.DaoFactory;
import fr.diginamic.petstore.entity.Animal;
import fr.diginamic.petstore.entity.Cat;
import fr.diginamic.petstore.entity.Fish;
import fr.diginamic.petstore.entity.FishLivEnv;

import java.sql.Date;

/**
 * Class PetShopService
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09 /11/2021
 */
public class AnimalService {
    private final AnimalDao animalDao;

    public AnimalService() {
        this.animalDao = DaoFactory.getAnimalDao();
    }

    public Animal addCat(Date birth, String color, String chipId) {
//        if (businessException.hasNoErrors()) {
        Cat cat = new Cat();
        cat.setBirth(birth);
        cat.setColor(color);
        cat.setChipId(chipId);
        animalDao.createAnimal(cat);
        return cat;
    }

    public Animal addFish(Date birth, String color, FishLivEnv livingEnv) {
//        if (businessException.hasNoErrors()) {
        Fish fish = new Fish();
        fish.setBirth(birth);
        fish.setColor(color);
        fish.setLivingEnv(livingEnv);
        animalDao.createAnimal(fish);
        return fish;
    }

    public void seeAllAnimals(){
        animalDao.seeAllAnimals();
    }
    public void seeAllAnimalsPerSpecie(String specie){
        animalDao.seeAllAnimalsPerSpecie(specie);
    }

    public void addToStore(Long storeId, Long animalId ){
        animalDao.addAnimalToStore(storeId, animalId );
    }

}