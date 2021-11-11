package fr.diginamic.petstore.entity;

/**
 * Enumeration to see if a fish is from sea or fresh water
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09 /11/2021
 */
public enum FishLivEnv {
    /**
     * The Fresh water.
     */
    FRESH_WATER("Eau douce"),
    /**
     * The Sea water.
     */
    SEA_WATER("Eau de mer");

    /**
     * The Fish liv env.
     */
    private String fishLivEnv;

    /**
     * Instantiates a new Fish liv env.
     *
     * @param nom the nom
     */
    private FishLivEnv(String nom) {
        this.fishLivEnv = nom;
    }

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return fishLivEnv;
    }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
        this.fishLivEnv = nom;
    }

    /**
     * Gets instance.
     *
     * @param fishLivEnv the fish liv env
     * @return the instance
     */
    public static FishLivEnv getInstance(String fishLivEnv) {
        for (FishLivEnv livEnv : FishLivEnv.values()) {
            if (livEnv.getNom().equals(fishLivEnv)) {
                return livEnv;
            }
        }
        return null;
    }

}
