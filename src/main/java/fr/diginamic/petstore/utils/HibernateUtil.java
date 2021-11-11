package fr.diginamic.petstore.utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateUtil {

    /** The em. */
    private static EntityManager em;

    /** The persistance. */
    private static String PERSISTANCE;

    {
        PERSISTANCE = "petStore";
    }

    /**
     * Instantiates a new connection DB.
     */
    private HibernateUtil() {
        em = Persistence.createEntityManagerFactory(PERSISTANCE).createEntityManager();
    }

    /**
     * Gets the single instance of ConnectionDB.
     *
     * @return single instance of ConnectionDB
     */
    public static EntityManager getInstance() {
        if (em == null || !em.isOpen())
            new HibernateUtil();
        return em;
    }
}
