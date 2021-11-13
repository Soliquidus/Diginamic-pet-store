package fr.diginamic.petstore.dao;

import fr.diginamic.petstore.entity.Animal;
import fr.diginamic.petstore.entity.Cat;
import fr.diginamic.petstore.entity.Fish;
import fr.diginamic.petstore.entity.PetStore;
import fr.diginamic.petstore.utils.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * All Animal Entity database manipulations
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public class AnimalDaoImpl implements AnimalDao {
    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger("daoLogger");
    /**
     * The Em.
     */
    EntityManager em = HibernateUtil.getInstance();

    /**
     * Create a new animal in database
     * @param animal the Animal Entity
     */
    @Override
    public void createAnimal(Animal animal) {
        try {
            em.getTransaction().begin();
            em.persist(animal);
            em.getTransaction().commit();
            LOGGER.info(animal.getClass().getSimpleName() + " created ! (id : " + animal.getId() + ").");
        } catch (Exception e) {
            LOGGER.error("Error while creating " + animal.getClass().getSimpleName() + ".");
            e.printStackTrace();
        }
    }

    /**
     * Add an animal to a given store
     * @param storeId the PetStore ID
     * @param animalId the Animal ID
     */
    @Override
    public void addAnimalToStore(Long storeId, Long animalId) {
        Animal animal = em.find(Animal.class, animalId);
        PetStore store = em.find(PetStore.class, storeId);
        if (store != null && animal != null) {
            try {
                em.getTransaction().begin();
                store.addAnimal(animal);
                em.getTransaction().commit();
                LOGGER.info(animal.getClass().getSimpleName() + " added to store " + store.getName());
            } catch (Exception e) {
                LOGGER.error("Error while adding " + animal.getClass().getSimpleName() + " to store " + store.getName());
                e.printStackTrace();
            }
        } else {
            LOGGER.error("Store or animal entity is null.");
        }
    }

    /**
     * Update infos about an animal in database
     * @param animal the Animal Entity
     */
    @Override
    public void updateAnimal(Animal animal) {
        if(animal != null){
            try {
                em.getTransaction().begin();
                em.merge(animal);
                em.getTransaction().commit();
            } catch (Exception e){
                LOGGER.error("Error while updating " + animal.getClass().getName());
                e.printStackTrace();
            }
        } else {
            LOGGER.error("Animal entity is null.");
        }
    }

    /**
     * Get a cat infos by given ID
     * @param catId the Cat ID
     * @return the Cat object
     */
    @Override
    public Cat getCatById(Long catId) {
        Cat cat = em.find(Cat.class, catId);
        if(cat == null){
            LOGGER.error("No cat found with given ID.");
        }
        return cat;
    }

    /**
     * Get a fish infos by given ID
     * @param fishId the Fish ID
     * @return the Fish object
     */
    @Override
    public Fish getFishById(Long fishId) {
        Fish fish = em.find(Fish.class, fishId);
        if(fish == null){
            LOGGER.error("No fish found with given ID.");
        }
        return fish;
    }

    /**
     * Delete a given animal
     * @param animalId the animal ID
     */
    @Override
    public void deleteAnimal(Long animalId) {
        Animal animal = em.find(Animal.class, animalId);
        em.getTransaction().begin();
        em.remove(animal);
        em.getTransaction().commit();
    }

    /**
     * See all animals in database
     */
    @Override
    public void seeAllAnimals() {
        try {
            TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a", Animal.class);
            List<Animal> animals = query.getResultList();
            int i = 0;
            System.out.println("\n--------------------------------" +
                    "\nAll animals in all shops : ");
            for (Animal animal : animals) {
                PetStore store = animal.getPetStore();
                ++i;
                System.out.println(i + " - " + animal.getClass().getSimpleName() + ", birth : " + animal.getBirth() + ", store : " + store.getName());
            }
            System.out.println("--------------------------------");
            LOGGER.info("Animal list successfully read from database ");
        } catch (Exception e) {
            LOGGER.error("Database animal fetching error");
            e.printStackTrace();
        }
    }

    /**
     * See all animals by given specie
     * @param specie the animal's specie
     */
    @Override
    public void seeAllAnimalsBySpecie(String specie) {
        try {
            TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a", Animal.class);
            List<Animal> animals = query.getResultList();
            int i = 0;
            System.out.println("\n--------------------------------" +
                    "\nAll "+ specie + " animals in all shops : ");
            for (Animal animal : animals) {
                if(animal.getClass().getSimpleName().equalsIgnoreCase(specie)) {
                    PetStore store = animal.getPetStore();
                    ++i;
                    System.out.println(i + " - birth : " + animal.getBirth() + ", store : " + store.getName());
                }
            }
            System.out.println("--------------------------------");
            LOGGER.info("Animal list successfully read from database ");
        } catch (Exception e) {
            LOGGER.error("Database animal fetching error");
            e.printStackTrace();
        }
    }
}