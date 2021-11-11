package fr.diginamic.petstore.dao;

import fr.diginamic.petstore.entity.Animal;
import fr.diginamic.petstore.entity.PetStore;
import fr.diginamic.petstore.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.Set;

/**
 * Class PetShopDao
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public class AnimalDaoImpl implements AnimalDao {
    EntityManager em = HibernateUtil.getInstance();

    @Override
    public void createAnimal(Animal animal) {
        try{
            em.getTransaction().begin();
            em.persist(animal);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAnimalToStore(Long animalId, Long storeId) {
        Animal animal = em.find(Animal.class, animalId);
        PetStore store = em.find(PetStore.class, storeId);
//        if(store != null && animal != null){
            try {
                em.getTransaction().begin();
                Set<Animal> animals = store.getAnimals();
                animals.add(animal);
                em.getTransaction().commit();
            } catch (Exception e){
                e.printStackTrace();
            }
//        }
    }
}