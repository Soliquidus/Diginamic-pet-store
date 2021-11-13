package fr.diginamic.petstore.manager;

import fr.diginamic.petstore.dao.DaoFactory;
import fr.diginamic.petstore.dao.ProductDao;
import fr.diginamic.petstore.entity.ProdType;
import fr.diginamic.petstore.entity.Product;
import fr.diginamic.petstore.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class PetShopService
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public class ProductService {
    /**
     * The Product dao.
     */
    private final ProductDao productDao;

    /**
     * The constant Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    /**
     * Instantiates a new Product service.
     */
    public ProductService() {
        this.productDao = DaoFactory.getProductDao();
    }

    // -- Functions --

    /**
     * Add product product.
     *
     * @param code  the code
     * @param label the label
     * @param type  the type
     * @param price the price
     * @return the product
     * @throws ServiceException the service exception
     */
    public Product addProduct(String code, String label, ProdType type, Double price) throws ServiceException {
        this.validateProduct(code, label, type, price);
        Product product;
        product = new Product();
        product.setCode(code);
        product.setLabel(label);
        product.setType(type);
        product.setPrice(price);
        productDao.createProduct(product);
        LOGGER.info("Product created.");
        return product;
    }

    /**
     * Update product.
     *
     * @param productId the product id
     * @param code      the code
     * @param label     the label
     * @param type      the type
     * @param price     the price
     */
    public void updateProduct(Long productId, String code, String label, ProdType type, Double price) throws ServiceException {
        Product product = productDao.getProductById(productId);
        this.validateProduct(code, label, type, price);
        product.setCode(code);
        product.setLabel(label);
        product.setType(type);
        product.setPrice(price);
        productDao.updateProduct(product);
        LOGGER.info("Product updated.");
    }

    /**
     * Delete product.
     *
     * @param productId the product id
     */
    public void deleteProduct(Long productId){
        productDao.deleteProduct(productId);
        LOGGER.info("Product deleted.");
    }


    /**
     * See all products.
     */
    public void seeAllProducts() {
        productDao.seeAllProducts();
    }

    /**
     * See all products per type.
     *
     * @param prodType the prod type
     */
    public void seeAllProductsByType(ProdType prodType) {
        productDao.seeAllProductsByType(prodType);
    }

    /**
     * Add to store.
     *
     * @param idStore    the id store
     * @param idProduct the id product
     */
    public void addToStore(Long idStore, Long idProduct) {
        productDao.addToStore(idStore, idProduct);
    }

    // -- Validations --
    //TODO: 13/11/2021 --> will be useful in further updates when the client UI will be implemented, this will evolve in the future

    /**
     * Validate product.
     *
     * @param code  the code
     * @param label the label
     * @param type  the type
     * @param price the price
     * @throws ServiceException the service exception
     */
    private void validateProduct(String code, String label, ProdType type, Double price) throws ServiceException {
        if (code == null || code.trim().length() > 50 || label == null || label.trim().length() > 50 || type == null ||
                price == null) {
            throw new ServiceException("Validation constraint not passed.");
        }
    }
}