package fr.diginamic.petstore.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Animal Entity
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
@Table(name = "Animal")
@Entity
@DiscriminatorColumn(name = "Specie")
public abstract class Animal {

	/**
	 * The Id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	/**
	 * The Birth.
	 */
	@Column(name = "birth")
	private Date birth;
	/**
	 * The Color.
	 */
	@Column(name = "color", length = 50)
	private String color;

	/**
	 * The Pet store.
	 */
	@ManyToOne
	@JoinColumn(name = "store_id")
	private PetStore petStore;

	/**
	 * Instantiates a new Animal for Hibernate.
	 */
	public Animal() {
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
	 * Gets birth.
	 *
	 * @return the birth
	 */
	public Date getBirth() {
		return birth;
	}

	/**
	 * Sets birth.
	 *
	 * @param birth the birth to set
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}


	/**
	 * Gets color.
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
	}


	/**
	 * Sets color.
	 *
	 * @param color the color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Gets pet store.
	 *
	 * @return the petStore
	 */
	public PetStore getPetStore() {
		return petStore;
	}

	/**
	 * Sets pet store.
	 *
	 * @param petStore the petStore to set
	 */
	public void setPetStore(PetStore petStore) {
		if (this.petStore != null) 
			this.petStore.getAnimals().remove(this);
		this.petStore = petStore;
		if (this.petStore != null) 
			this.petStore.getAnimals().add(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Animal [id=");
		builder.append(id);
		builder.append(", birth=");
		builder.append(birth);
		builder.append(", color=");
		builder.append(color);
		builder.append("]");
		return builder.toString();
	}


}
