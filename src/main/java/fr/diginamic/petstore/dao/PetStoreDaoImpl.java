package fr.diginamic.petstore.dao;

import fr.diginamic.petstore.entity.*;
import fr.diginamic.petstore.utils.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * All PetStore Entity database manipulations
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public class PetStoreDaoImpl implements PetStoreDao {
    /**
     * The Em.
     */
    EntityManager em = HibernateUtil.getInstance();
    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger("daoLogger");

    /**
     * Create a new PetStore in database
     * @param petStore the pet store
     */
    @Override
    public void createPetStore(PetStore petStore) {
        try {
            em.getTransaction().begin();
            em.persist(petStore);
            em.getTransaction().commit();
            LOGGER.info(petStore.getClass().getSimpleName() + " created ! (id : " + petStore.getId() + ").");
        } catch (Exception e) {
            LOGGER.error("Error while creating " + petStore.getClass().getSimpleName() + ".");
            e.printStackTrace();
        }
    }

    /**
     * Update an existing PetStore
     * @param store the store
     */
    @Override
    public void updatePetStore(PetStore store) {
            if(store != null){
                em.getTransaction().begin();
                em.merge(store);
                em.getTransaction().commit();
                LOGGER.info(store.getName() + " updated.");
            } else {
                LOGGER.error("No store match for given ID.");
            }
        }

    /**
     * Delete an existing PetStore
      * @param storeId the store id
     */
    @Override
    public void deletePetStore(Long storeId) {
        try {
            PetStore store = em.find(PetStore.class, storeId);
            if(store != null){
                String name = store.getName();
                em.getTransaction().begin();
                em.remove(store);
                em.getTransaction().commit();
                LOGGER.info("\"" + name + "\"" + " deleted.");
            } else {
                LOGGER.error("No store match for given ID.");
            }
        } catch (Exception e){
            LOGGER.error("Global error while store suppression.");
            e.printStackTrace();
        }
    }

    /**
     * Get a store by given ID
     * @param storeId the store id
     * @return the store object
     */
    @Override
    public PetStore getStoreById(Long storeId) {
        PetStore store = em.find(PetStore.class, storeId);
        if(store == null){
            LOGGER.error("No store found with given ID.");
        }
        return store;
    }

    /**
     * See all animals in one store
     * @param storeId the store id
     */
    @Override
    public void seeAnimals(Long storeId) {
        try {
            TypedQuery<PetStore> query = em.createQuery("SELECT p from PetStore p WHERE p.id='" + storeId + "'", PetStore.class);
            PetStore store = query.getResultList().get(0);
            if (store != null) {
                int i = 0;
                System.out.println("\n--------------------------------" +
                        "\nAnimals from store \"" + store.getName() + "\" : ");
                for (Animal animal : store.getAnimals()) {
                    ++i;
                    System.out.println(i + " - " + animal.getClass().getSimpleName() + ", Birth : " + animal.getBirth() + ", color : " + animal.getColor());
                }
                System.out.println("--------------------------------");
                LOGGER.info("Animal list successfully read from shop " + store.getName());
            } else {
                LOGGER.error("No store with this id.");
            }
        } catch (Exception e) {
            LOGGER.error("General error when trying to get Entity");
            e.printStackTrace();
        }
    }

    /**
     * See all animals by a given specie in a given store
     * @param storeId the store id
     * @param specie  the specie
     */
    @Override
    public void seeAnimalsBySpecie(Long storeId, String specie) {
        try {
            TypedQuery<PetStore> query = em.createQuery("SELECT p from PetStore p WHERE p.id='" + storeId + "'", PetStore.class);
            PetStore store = query.getResultList().get(0);
            if (store != null) {
                int i = 0;
                System.out.println("\n--------------------------------" +
                        "\n" + specie.toUpperCase() + " from store \"" + store.getName() + "\" : ");
                for (Animal animal : store.getAnimals()) {
                    if (animal.getClass().getSimpleName().equalsIgnoreCase(specie)) {
                        ++i;
                        System.out.println(i + " - " + animal.getClass().getSimpleName() + ", Birth : " + animal.getBirth() + ", color : " + animal.getColor());
                    }
                }
                System.out.println("--------------------------------");
                LOGGER.info("Animal list successfully read from shop " + store.getName());
            } else {
                LOGGER.error("No store with this id.");
            }
        } catch (Exception e) {
            LOGGER.error("General error when trying to get Entity");
            e.printStackTrace();
        }
    }

    /**
     * See all products in a given store
     * @param storeId the store id
     */
    @Override
    public void seeProducts(Long storeId) {
        try {
            TypedQuery<PetStore> query = em.createQuery("SELECT p from PetStore p WHERE p.id='" + storeId + "'", PetStore.class);
            PetStore store = query.getResultList().get(0);
            if (store != null) {
                int i = 0;
                System.out.println("\n--------------------------------" +
                        "\nProducts from store \"" + store.getName() + "\" : ");
                for (Product product : store.getProducts()) {
                    ++i;
                    System.out.println(i + " - " + product.getLabel() + ", Type : " + product.getType() + ", price : " + product.getPrice() + ", code : " + product.getCode());
                }
                System.out.println("--------------------------------");
                LOGGER.info("Product list successfully read from shop " + store.getName());
            } else {
                LOGGER.error("No store with this id.");
            }
        } catch (Exception e) {
            LOGGER.error("General error when trying to get Entity");
            e.printStackTrace();
        }
    }

    /**
     * See all products by a given type in a given store
     * @param storeId  the store id
     * @param prodType the prod type
     */
    @Override
    public void seeProductsPerType(Long storeId, ProdType prodType) {
        try {
            TypedQuery<PetStore> query = em.createQuery("SELECT p from PetStore p WHERE p.id='" + storeId + "'", PetStore.class);
            PetStore store = query.getResultList().get(0);
            if (store != null) {
                int i = 0;
                System.out.println("\n--------------------------------" +
                      "\n" + prodType + " from store \"" + store.getName() + "\" : ");
                for (Product product : store.getProducts()) {
                    if(product.getType() == prodType) {
                        ++i;
                        System.out.println(i + " - " + product.getLabel() + ", Type : " + product.getType() + ", price : " + product.getPrice() + ", code : " + product.getCode());
                    }
                }
                System.out.println("--------------------------------");
                LOGGER.info("Product list successfully read from shop " + store.getName());
            } else {
                LOGGER.error("No store with this id.");
            }
        } catch (Exception e) {
            LOGGER.error("General error when trying to get Entity");
            e.printStackTrace();
        }
    }
}