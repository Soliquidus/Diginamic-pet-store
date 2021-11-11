package fr.diginamic.petstore.dao;

import fr.diginamic.petstore.entity.Animal;

public interface AnimalDao {
    public void createAnimal(Animal animal);
    public void addAnimalToStore(Long animalId, Long storeId);
}
