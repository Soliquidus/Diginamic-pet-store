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
 * All Product Entity database manipulations
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public class ProductDaoImpl implements ProductDao {
    private static final Logger LOGGER = LoggerFactory.getLogger("daoLogger");
    EntityManager em = HibernateUtil.getInstance();

    /**
     * Create a new product in database
     * @param product the product
     */
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

    /**
     * Update an existing product in database
     * @param product the product
     */
    @Override
    public void updateProduct(Product product) {
        if(product != null){
            em.getTransaction().begin();
            em.merge(product);
            em.getTransaction().commit();
            LOGGER.info(product.getLabel() + " updated.");
        } else {
            LOGGER.error("No product match for given ID.");
        }
    }

    /**
     * Delete a product by its ID
     * @param productId the product id
     */
    @Override
    public void deleteProduct(Long productId) {
        try {
            Product product = em.find(Product.class, productId);
            if(product != null){
                String name = product.getLabel();
                em.getTransaction().begin();
                em.remove(product);
                em.getTransaction().commit();
                LOGGER.info("\"" + name + "\"" + " deleted.");
            } else {
                LOGGER.error("No product match for given ID.");
            }
        } catch (Exception e){
            LOGGER.error("Global error while product suppression.");
            e.printStackTrace();
        }
    }

    /**
     * Get a product by its given ID
     * @param productId the product id
     * @return the product object
     */
    @Override
    public Product getProductById(Long productId) {
        Product product = em.find(Product.class, productId);
        if(product == null){
            LOGGER.error("No product found with given ID.");
        }
        return product;
    }

    /**
     * Add a product to a shop by their given IDs
     * @param idShop    the id shop
     * @param idProduct the id product
     */
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

    /**
     * See all products in database
     */
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

    /**
     * See all products by their given type.
     * @param prodType the prod type
     */
    @Override
    public void seeAllProductsByType(ProdType prodType) {
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