package fr.diginamic.petstore.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Petshop entity
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09 /11/2021s
 */
@Table(name = "Pet_Store")
@Entity
public class PetStore {

	/**
	 * The Id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	/**
	 * The Name.
	 */
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	/**
	 * The Manager name.
	 */
	@Column(name = "manager_name", nullable = false, length = 75)
	private String managerName;

	/**
	 * The Animals.
	 */
	@OneToMany(mappedBy = "petStore", cascade = CascadeType.REMOVE)
	private Set<Animal> animals = new HashSet<>();

	/**
	 * The Products.
	 */
	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "Shop_Products",
			joinColumns = @JoinColumn(name = "store_id", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "ID"))
	private Set<Product> products = new HashSet<>();


	/**
	 * The Address.
	 */
	@Embedded
	private Address address;

	/**
	 * Instantiates a new Pet store for Hibernate.
	 */
	public PetStore() {
	}

	/**
	 * Instantiates a new Pet store.
	 *
	 * @param name        the name
	 * @param managerName the manager name
	 * @param address     the address
	 */
	public PetStore(String name, String managerName, Address address) {
		this.name = name;
		this.managerName = managerName;
		this.address = address;
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
	 * Gets name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets manager name.
	 *
	 * @return the managerName
	 */
	public String getManagerName() {
		return managerName;
	}

	/**
	 * Sets manager name.
	 *
	 * @param managerName the managerName to set
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	/**
	 * Gets address.
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets address.
	 *
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Gets animals.
	 *
	 * @return the animals
	 */
	public Set<Animal> getAnimals() {
		return animals;
	}

	/**
	 * Sets animals.
	 *
	 * @param animals the animals to set
	 */
	public void setAnimals(Set<Animal> animals) {
		this.animals = animals;
	}

	/**
	 * Gets products.
	 *
	 * @return the products
	 */
	public Set<Product> getProducts() {
		return products;
	}

	/**
	 * Sets products.
	 *
	 * @param products the products to set
	 */
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	/**
	 * Add animal.
	 *
	 * @param animal the animal
	 */
	public void addAnimal(Animal animal)
	{
		animal.setPetStore(this);
	}

	/**
	 * Remove animal.
	 *
	 * @param animal the animal
	 */
	public void removeAnimal(Animal animal) {
		animal.setPetStore(null);
	}

	/**
	 * Add product.
	 *
	 * @param product the product
	 */
	public void addProduct(Product product) {
		product.getPetStores().add(this);
	}

	/**
	 * Remove product.
	 *
	 * @param product the product
	 */
	public void removeProduct(Product product) {
		product.getPetStores().remove(this);
	}
}
