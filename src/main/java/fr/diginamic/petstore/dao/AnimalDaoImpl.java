package fr.diginamic.petstore.dao;

import fr.diginamic.petstore.entity.Animal;
import fr.diginamic.petstore.utils.HibernateUtil;

import javax.persistence.EntityManager;

/**
 * Class PetShopDao
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public class AnimalDaoImpl implements AnimalDao {

    @Override
    public void createAnimal(Animal animal) {
        EntityManager em = HibernateUtil.getInstance();
        try{
            em.getTransaction().begin();
            em.persist(animal);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}