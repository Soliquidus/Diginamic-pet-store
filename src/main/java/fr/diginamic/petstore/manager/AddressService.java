package fr.diginamic.petstore.manager;

import fr.diginamic.petstore.entity.Address;
import fr.diginamic.petstore.exception.ServiceException;
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

    /**
     * Add address address.
     *
     * @param number  the number
     * @param street  the street
     * @param zipCode the zip code
     * @param city    the city
     * @return the address
     * @throws ServiceException the service exception
     */
    public Address addAddress(String number, String street, String zipCode, String city) throws ServiceException {
        this.validateAddress(number, street, zipCode, city);
        Address address;
        address = new Address();
        address.setNumber(number);
        address.setStreet(street);
        address.setZipCode(zipCode);
        address.setCity(city);
        LOGGER.info("Address created");
        return address;
    }

    /**
     * Validate address.
     *
     * @param number  the number
     * @param street  the street
     * @param zipCode the zip code
     * @param city    the city
     * @throws ServiceException the service exception
     */
    private void validateAddress(String number, String street, String zipCode, String city) throws ServiceException {
        if (number == null || number.trim().length() > 10 || street == null || street.trim().length() > 50 ||
                zipCode == null || zipCode.trim().length() > 10 || city == null || city.trim().length() > 50) {
            throw new ServiceException("Validation constraint not passed.");
        }
    }

}