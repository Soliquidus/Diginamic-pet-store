package fr.diginamic.petstore.dao;

import fr.diginamic.petstore.entity.Product;

public interface ProductDao {
    public void createProduct(Product product);
    public void addToShop(Long idShop, Long idProduct);
}
