package fr.diginamic.petstore.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Address entity embedded in the PetStore entity.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
@Embeddable
public class Address {

    /**
     * The Id.
     */
    @Column(insertable = false, updatable = false)
    private long id;
    /**
     * The Number.
     */
    @Column(name = "number", nullable = false, length = 10)
    private String number;
    /**
     * The Street.
     */
    @Column(name = "street", nullable = false, length = 50)
    private String street;
    /**
     * The Zip code.
     */
    @Column(name = "zip_code", nullable = false, length = 10)
    private String zipCode;
    /**
     * The City.
     */
    @Column(name = "city", nullable = false, length = 50)
    private String city;

    /**
     * Instantiates a new Address for Hibernate.
     */
    public Address() {
    }

    /**
     * Instantiates a new Address.
     *
     * @param number  the number
     * @param street  the street
     * @param zipCode the zip code
     * @param city    the city
     */
    public Address(String number, String street, String zipCode, String city) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets number.
     *
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets number.
     *
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Gets street.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets street.
     *
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets zip code.
     *
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets zip code.
     *
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Adress [id=");
        builder.append(id);
        builder.append(", number=");
        builder.append(number);
        builder.append(", street=");
        builder.append(street);
        builder.append(", zipCode=");
        builder.append(zipCode);
        builder.append(", city=");
        builder.append(city);
        builder.append("]");
        return builder.toString();
    }


}
