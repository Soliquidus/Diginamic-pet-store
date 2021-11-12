package fr.diginamic.petstore.dao;

import fr.diginamic.petstore.entity.ProdType;
import fr.diginamic.petstore.entity.Product;

public interface ProductDao {
    void createProduct(Product product);
    void addToStore(Long idShop, Long idProduct);
    void seeAllProducts();
    void seeAllProductsPerType(ProdType prodType);
}
