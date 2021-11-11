package fr.diginamic.petstore.utils;

import java.util.ResourceBundle;

/**
 * Cette classe permet de lire le contenu du fichier messages_erreur.properties
 * @author Administrator
 *
 */
public abstract class ReadMessage {
	private static final ResourceBundle rb = ResourceBundle.getBundle("fr/diginamic/petshop/utils/error_messages.properties");


	public String getErrorMessage(int code)
	{
		String message;
		try
		{
			if(rb!=null)
			{
				message = rb.getString(String.valueOf(code));
//				System.err.println(message);
			}
			else
			{
				message="Reading error";
//				System.err.println(message);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			message="Unknown error";
//			System.err.println(message);
		}
		return message;
	}
}