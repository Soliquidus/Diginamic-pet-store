package fr.diginamic.petstore.dao;

import fr.diginamic.petstore.entity.PetStore;
import fr.diginamic.petstore.entity.ProdType;
import fr.diginamic.petstore.entity.Product;
import fr.diginamic.petstore.utils.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

/**
 * Class PetShopDao
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09 /11/2021
 */
public class ProductDaoImpl implements ProductDao {
    private static final Logger LOGGER = LoggerFactory.getLogger("daoLogger");
    EntityManager em = HibernateUtil.getInstance();

    @Override
    public void createProduct(Product product) {
        try {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
            LOGGER.info(product.getClass().getSimpleName() + " created ! (id : " + product.getId() + ").");
        } catch (Exception e) {
            LOGGER.error("Error while creating " + product.getClass().getSimpleName() + ".");
            e.printStackTrace();
        }
    }

    @Override
    public void addToStore(Long idShop, Long idProduct) {
        PetStore petStore = em.find(PetStore.class, idShop);
        Product product = em.find(Product.class, idProduct);
        if (petStore != null && product != null) {
            try {
                em.getTransaction().begin();
                Set<Product> products = petStore.getProducts();
                products.add(product);
                em.getTransaction().commit();
            } catch (Exception e) {
                LOGGER.error("Error while adding " + product.getClass().getSimpleName() + " to store " + petStore.getName());
                e.printStackTrace();
            }
        } else {
            LOGGER.error("Store or product entity is null.");
        }
    }

    @Override
    public void seeAllProducts() {
        try {
            TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
            List<Product> products = query.getResultList();
            int i = 0;
            System.out.println("\n--------------------------------" +
                    "\nAll products in all shops : ");
            for (Product product : products) {
                ++i;
                Set<PetStore> stores = product.getPetStores();
                System.out.print("\n" + i + " - " + product.getLabel() + ", type : " + product.getType() + ", price : "
                        + product.getPrice() + ", stores available : ");
                for (PetStore store : stores) {
                    System.out.print("\"" + store.getName() + "\"" + ", ");
                }
                System.out.println();
            }
            System.out.println("--------------------------------");
            LOGGER.info("Product list successfully read from database ");
        } catch (Exception e) {
            LOGGER.error("Database product fetching error");
            e.printStackTrace();
        }
    }

    @Override
    public void seeAllProductsPerType(ProdType prodType) {
        try {
            TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
            List<Product> products = query.getResultList();
            int i = 0;
            System.out.println("\n--------------------------------" +
                    "\nAll " + prodType + " products in all shops : ");
            for (Product product : products) {
                if (product.getType() == prodType) {
                    ++i;
                    Set<PetStore> stores = product.getPetStores();
                    System.out.print("\n" + i + " - " + product.getLabel() + ", price : " +
                            product.getPrice() + ", stores available : ");
                    for (PetStore store : stores) {
                        System.out.print("\"" + store.getName() + "\"" + ", ");
                    }
                    System.out.println();
                }
            }
            System.out.println("--------------------------------");
            LOGGER.info("Product list successfully read from database ");
        } catch (Exception e) {
            LOGGER.error("Database product fetching error");
            e.printStackTrace();
        }
    }
}