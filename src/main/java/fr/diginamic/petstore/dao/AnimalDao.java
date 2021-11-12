package fr.diginamic.petstore.dao;

import fr.diginamic.petstore.entity.Animal;

public interface AnimalDao {
    void createAnimal(Animal animal);
    void addAnimalToStore(Long storeId ,Long animalId);
    void seeAllAnimals();
    void seeAllAnimalsPerSpecie(String specie);
}
