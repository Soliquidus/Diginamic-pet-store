package fr.diginamic.petstore.manager;

import fr.diginamic.petstore.entity.Address;
import fr.diginamic.petstore.utils.ReadMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class AddressService
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public class AddressService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressService.class);
    ReadMessage readMessage;

    public Address addAddress(String number, String street, String zipCode, String city) {
//        BusinessException businessException = new BusinessException();
        this.validateAddress(number, street, zipCode, city);
        Address address;
            address = new Address();
            address.setNumber(number);
            address.setStreet(street);
            address.setZipCode(zipCode);
            address.setCity(city);
        return address;
    }

    private void validateAddress(String number, String street, String zipCode, String city){
        if(number == null || number.trim().length() > 10 || street == null || street.trim().length() > 50 ||
                zipCode == null || zipCode.trim().length() > 10 || city == null || city.trim().length() > 50){
//            businessException.addError(ErrorCodesService.ADDRESS_CREATION_RULES);
        }
    }

}