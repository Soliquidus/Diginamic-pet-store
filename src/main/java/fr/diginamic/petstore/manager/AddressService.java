package fr.diginamic.petstore.manager;

import fr.diginamic.petstore.entity.Address;
import fr.diginamic.petstore.exception.ServiceException;

/**
 * Class AddressService
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public class AddressService {

    public Address addAddress(String number, String street, String zipCode, String city) throws ServiceException {
        this.validateAddress(number, street, zipCode, city);
        Address address;
            address = new Address();
            address.setNumber(number);
            address.setStreet(street);
            address.setZipCode(zipCode);
            address.setCity(city);
        return address;
    }

    private void validateAddress(String number, String street, String zipCode, String city) throws ServiceException {
        if(number == null || number.trim().length() > 10 || street == null || street.trim().length() > 50 ||
                zipCode == null || zipCode.trim().length() > 10 || city == null || city.trim().length() > 50){
            throw new ServiceException("Validation constraint not passed.");
        }
    }

}