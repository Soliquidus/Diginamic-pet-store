package fr.diginamic.petstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Cat Entity
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09 /11/2021
 */
@Entity
public class Cat extends Animal {

    /**
     * The Chip id.
     */
    @Column(name = "chip_id", length = 50)
    private String chipId;

    /**
     * Instantiates a new Cat for Hibernate.
     */
    public Cat() {
        super();
    }

    public Cat(String chipId) {
        this.chipId = chipId;
    }

    /**
     * Gets chip id.
     *
     * @return the chipId
     */
    public String getChipId() {
        return chipId;
    }

    /**
     * Sets chip id.
     *
     * @param chipId the chipId to set
     */
    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("\n --> Cat [chipId=");
        builder.append(chipId);
        builder.append("]");
        return builder.toString();
    }


}
