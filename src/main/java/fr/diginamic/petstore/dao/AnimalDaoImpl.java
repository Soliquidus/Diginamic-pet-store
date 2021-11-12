package fr.diginamic.petstore.dao;

import fr.diginamic.petstore.entity.Animal;
import fr.diginamic.petstore.entity.PetStore;
import fr.diginamic.petstore.utils.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Class PetShopDao
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public class AnimalDaoImpl implements AnimalDao {
    private static final Logger LOGGER = LoggerFactory.getLogger("daoLogger");
    EntityManager em = HibernateUtil.getInstance();

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

    @Override
    public void seeAllAnimalsPerSpecie(String specie) {
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