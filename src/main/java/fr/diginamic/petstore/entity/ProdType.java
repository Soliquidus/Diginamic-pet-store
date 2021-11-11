package fr.diginamic.petstore.entity;

/**
 * Enumeration to determine what type of product it is about.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09 /11/2021
 */
public enum ProdType {
	/**
	 * Food prod type.
	 */
	FOOD("Nourriture"),
	/**
	 * Accessory prod type.
	 */
	ACCESSORY("Accessoire"),
	/**
	 * Cleaning prod type.
	 */
	CLEANING("Nettoyage");

	/**
	 * The Type name.
	 */
	private String typeName;

	/**
	 * Instantiates a new Prod type.
	 *
	 * @param nom the nom
	 */
	private ProdType(String nom) {
		this.typeName = nom;
	}

	/**
	 * Gets nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return typeName;
	}

	/**
	 * Sets nom.
	 *
	 * @param nom the nom
	 */
	public void setNom(String nom) {
		this.typeName = nom;
	}

	/**
	 * Gets instance.
	 *
	 * @param typeName the type name
	 * @return the instance
	 */
	public static ProdType getInstance(String typeName) {
		for (ProdType prodType : ProdType.values()) {
			if (prodType.getNom().equals(typeName)) {
				return prodType;
			}
		}
		return null;
	}

}
