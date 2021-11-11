package fr.diginamic.petstore.exception;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 * Cette classe permet de recenser l'ensemble des erreurs (par leur code) pouvant survenir lors d'un traitement
 * quel que soit la couche à l'origine.
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1165486741156489632L;
	private final List<Integer> errorCodesList;
	
	public BusinessException() {
		super();
		this.errorCodesList=new ArrayList<>();
	}
	
	/**
	 *
     * @param code Code de l'erreur.
     * Doit avoir un message associé dans un fichier properties.
	 */
	public int addError(int code)
	{
		if(!this.errorCodesList.contains(code))
		{
			this.errorCodesList.add(code);
		}
        return code;
    }
	
	public boolean hasNoErrors()
	{
		return this.errorCodesList.size() <= 0;
	}
	
	public List<Integer> getErrorCodesList()
	{
		return this.errorCodesList;
	}

}