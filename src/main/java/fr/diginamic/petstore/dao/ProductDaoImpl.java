package fr.diginamic.petstore.dao;

import fr.diginamic.petstore.entity.PetStore;
import fr.diginamic.petstore.entity.Product;
import fr.diginamic.petstore.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.Set;

/**
 * Class PetShopDao
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09 /11/2021
 */
public class ProductDaoImpl implements ProductDao {
    EntityManager em = HibernateUtil.getInstance();

    @Override
    public void createProduct(Product product) {
        try {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addToShop(Long idShop, Long idProduct) {
        PetStore petStore = em.find(PetStore.class, idShop);
        Product product = em.find(Product.class, idProduct);
        if (petStore != null && product != null) {
            try {
                em.getTransaction().begin();
                Set<Product> products = petStore.getProducts();
                products.add(product);
                em.getTransaction().commit();
                em.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}