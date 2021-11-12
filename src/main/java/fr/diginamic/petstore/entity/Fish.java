package fr.diginamic.petstore.entity;

import javax.persistence.*;

/**
 * Fish Entity
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
@Entity
public class Fish extends Animal {

	/**
	 * The Living env.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "environnement")
	private FishLivEnv livingEnv;

	/**
	 * Instantiates a new Fish for Hibernate.
	 */
	public Fish() {
		super();
	}

	public Fish(FishLivEnv livingEnv) {
		this.livingEnv = livingEnv;
	}

	/**
	 * Gets living env.
	 *
	 * @return the livingEnv
	 */
	public FishLivEnv getLivingEnv() {
		return livingEnv;
	}

	/**
	 * Sets living env.
	 *
	 * @param livingEnv the livingEnv to set
	 */
	public void setLivingEnv(FishLivEnv livingEnv) {
		this.livingEnv = livingEnv;
	}
}
