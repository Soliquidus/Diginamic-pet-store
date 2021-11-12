package fr.diginamic.petstore.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Product entity
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09 /11/2021
 */
@Table(name = "Product")
@Entity
public class Product {

	/**
	 * The Id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	/**
	 * The Code.
	 */
	@Column(name = "code", nullable = false, length = 5)
	private String code;
	/**
	 * The Label.
	 */
	@Column(name = "label", nullable = false, length = 50)
	private String label;
	/**
	 * The Price.
	 */
	@Column(name = "price", nullable = false)
	private double price;

	/**
	 * The Type.
	 */
	@Enumerated(EnumType.STRING)
	private ProdType type;

	/**
	 * The Pet stores.
	 */
	@ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
	private Set<PetStore> petStores = new HashSet<>();

	/**
	 * Instantiates a new Product.
	 */
	public Product() {
	}

	/**
	 * Instantiates a new Product.
	 *
	 * @param code  the code
	 * @param label the label
	 * @param price the price
	 * @param type  the type
	 */
	public Product(String code, String label, double price, ProdType type) {
		this.code = code;
		this.label = label;
		this.price = price;
		this.type = type;
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
	 * Gets code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets code.
	 *
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets label.
	 *
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Gets price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets price.
	 *
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets type.
	 *
	 * @return the type
	 */
	public ProdType getType() {
		return type;
	}

	/**
	 * Sets type.
	 *
	 * @param type the type to set
	 */
	public void setType(ProdType type) {
		this.type = type;
	}

	/**
	 * Gets pet stores.
	 *
	 * @return the petStores
	 */
	public Set<PetStore> getPetStores() {
		return petStores;
	}

	/**
	 * Sets pet stores.
	 *
	 * @param petStores the petStores to set
	 */
	public void setPetStores(Set<PetStore> petStores) {
		this.petStores = petStores;
	}

	/**
	 * Add pet store.
	 *
	 * @param petStore the pet store
	 */
	public void addPetStore(PetStore petStore) {
		petStore.getProducts().add(this);
	}

	/**
	 * Remove pet store.
	 *
	 * @param petStore the pet store
	 */
	public void removePetStore(PetStore petStore) {
		petStore.getProducts().remove(this);
	}
}
