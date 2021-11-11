package fr.diginamic.petstore.manager;

import fr.diginamic.petstore.dao.DaoFactory;
import fr.diginamic.petstore.dao.ProductDao;
import fr.diginamic.petstore.entity.ProdType;
import fr.diginamic.petstore.entity.Product;
import fr.diginamic.petstore.exception.BusinessException;
import fr.diginamic.petstore.exception.ErrorCodesService;
import fr.diginamic.petstore.utils.ReadMessage;
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
    private final BusinessException businessException = new BusinessException();
    ReadMessage readMessage;
    private final ProductDao productDao;

    public ProductService(){
        this.productDao = DaoFactory.getProductDao();
    }

    public Product addProduct(String code, String label, ProdType type, Double price){
//        this.validateProduct(code, label, type, price, businessException);
        Product product;
            product = new Product();
            product.setCode(code);
            product.setLabel(label);
            product.setType(type);
            product.setPrice(price);
            productDao.createProduct(product);
            return product;
    }

    public void addToShop(Long idShop, Long idProduct) throws BusinessException {
        productDao.addToShop(idShop, idProduct);
    }

    private void validateProduct(String code, String label, ProdType type, Double price, BusinessException businessException){
        if(code == null || code.trim().length() > 50 || label == null || label.trim().length() > 50 || type == null ||
        price == null){
            readMessage.getErrorMessage(this.businessException.addError(ErrorCodesService.PRODUCT_CREATION_RULES));
        }
    }

}