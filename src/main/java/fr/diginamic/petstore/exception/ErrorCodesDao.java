package fr.diginamic.petstore.exception;

/**
 * Class ErrorCodesDao
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public abstract class ErrorCodesDao {
    //PetShop errors
    public static final Integer INSERT_PET_SHOP_NULL=10000; //PetShop can't be null
    public static final Integer INSERT_PET_SHOP_FAIL=10001; //General error during insertion
    //Address errors
    public static final Integer INSERT_ADDRESS_NULL = 10020;//Address can't be null
    public static final Integer INSERT_ADDRESS_FAIL = 10021;//General error during insertion
    //Product errors
    public static final Integer INSERT_PRODUCT_NULL = 10030;//
}