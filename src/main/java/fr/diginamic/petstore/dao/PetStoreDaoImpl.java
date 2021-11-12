package fr.diginamic.petstore.dao;

import fr.diginamic.petstore.entity.Animal;
import fr.diginamic.petstore.entity.PetStore;
import fr.diginamic.petstore.entity.ProdType;
import fr.diginamic.petstore.entity.Product;
import fr.diginamic.petstore.utils.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Class PetShopDao
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public class PetStoreDaoImpl implements PetStoreDao {
    EntityManager em = HibernateUtil.getInstance();
    private static final Logger LOGGER = LoggerFactory.getLogger("daoLogger");

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

    @Override
    public void seeAnimalsPerSpecie(Long storeId, String specie) {
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