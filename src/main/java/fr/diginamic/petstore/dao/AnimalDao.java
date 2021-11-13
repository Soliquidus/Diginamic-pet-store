package fr.diginamic.petstore.dao;

import fr.diginamic.petstore.entity.Animal;
import fr.diginamic.petstore.entity.Cat;
import fr.diginamic.petstore.entity.Fish;

/**
 * The DAO for Animal Entity
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public interface AnimalDao {
    /**
     * Create animal.
     *
     * @param animal the animal
     */
    void createAnimal(Animal animal);

    /**
     * Add animal to store.
     *
     * @param storeId  the store id
     * @param animalId the animal id
     */
    void addAnimalToStore(Long storeId ,Long animalId);

    /**
     * Update animal.
     *
     * @param animal the animal
     */
    void updateAnimal(Animal animal);

    /**
     * Gets cat by id.
     *
     * @param catId the cat id
     * @return the cat by id
     */
    Cat getCatById(Long catId);

    /**
     * Gets fish by id.
     *
     * @param fishId the fish id
     * @return the fish by id
     */
    Fish getFishById(Long fishId);

    /**
     * Delete animal.
     *
     * @param animalId the animal id
     */
    void deleteAnimal(Long animalId);

    /**
     * See all animals.
     */
    void seeAllAnimals();

    /**
     * See all animals by specie.
     *
     * @param specie the specie
     */
    void seeAllAnimalsBySpecie(String specie);
}
