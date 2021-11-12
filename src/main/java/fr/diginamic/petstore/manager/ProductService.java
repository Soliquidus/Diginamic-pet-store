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
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    private final ProductDao productDao;

    public ProductService() {
        this.productDao = DaoFactory.getProductDao();
    }

    public Product addProduct(String code, String label, ProdType type, Double price) throws ServiceException {
        this.validateProduct(code, label, type, price);
        Product product;
        product = new Product();
        product.setCode(code);
        product.setLabel(label);
        product.setType(type);
        product.setPrice(price);
        productDao.createProduct(product);
        return product;
    }

    public void seeAllProducts() {
        productDao.seeAllProducts();
    }

    public void seeAllProductsPerType(ProdType prodType) {
        productDao.seeAllProductsPerType(prodType);
    }

    public void addToStore(Long idShop, Long idProduct) {
        productDao.addToStore(idShop, idProduct);
    }

    private void validateProduct(String code, String label, ProdType type, Double price) throws ServiceException {
        if (code == null || code.trim().length() > 50 || label == null || label.trim().length() > 50 || type == null ||
                price == null) {
            throw new ServiceException("Validation constraint not passed.");
        }
    }
}