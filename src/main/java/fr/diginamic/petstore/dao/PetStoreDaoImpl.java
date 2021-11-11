package fr.diginamic.petstore.dao;

import fr.diginamic.petstore.entity.PetStore;
import fr.diginamic.petstore.utils.HibernateUtil;

import javax.persistence.EntityManager;

/**
 * Class PetShopDao
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public class PetStoreDaoImpl implements PetStoreDao {

    @Override
    public void createPetStore(PetStore petStore) {
//        BusinessException businessException = new BusinessException();
        EntityManager em = HibernateUtil.getInstance();
        try{
            em.getTransaction().begin();
            em.persist(petStore);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        catch (Exception e) {
//            e.printStackTrace();
//            if (petStore == null) {
//                businessException.addError(ErrorCodesDao.INSERT_PET_SHOP_NULL);
//                throw businessException;
//            }
//            businessException.addError(ErrorCodesDao.INSERT_PET_SHOP_FAIL);
//            throw businessException;
//        }
    }
}