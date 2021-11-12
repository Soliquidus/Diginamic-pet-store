package fr.diginamic.petstore.exception;

/**
 * Class ServiceExceptions
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 12/11/2021
 */
public class ServiceException extends Exception{

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 8674654687687684513L;

    /**
     * Instantiates a new Service exception.
     *
     * @param message the exception message
     */
    public ServiceException(String message) {
        super(message);
    }
}