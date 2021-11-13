package fr.diginamic.petstore.dao;

import fr.diginamic.petstore.entity.ProdType;
import fr.diginamic.petstore.entity.Product;

/**
 * Class ProductDao
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public interface ProductDao {

    /**
     * Create product.
     *
     * @param product the product
     */
    void createProduct(Product product);
    void updateProduct(Product product);

    /**
     * Delete product.
     *
     * @param productId the product id
     */
    void deleteProduct(Long productId);

    /**
     * Gets product by id.
     *
     * @param productId the product id
     * @return the product by id
     */
    Product getProductById(Long productId);

    /**
     * Add to store.
     *
     * @param idStore   the id store
     * @param idProduct the id product
     */
    void addToStore(Long idStore, Long idProduct);

    /**
     * See all products.
     */
    void seeAllProducts();

    /**
     * See all products per type.
     *
     * @param prodType the prod type
     */
    void seeAllProductsByType(ProdType prodType);
}
