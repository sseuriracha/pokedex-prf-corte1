package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <h1>PokemonDTO</h1>
 * The PokemonDTO class is the Data Transfer Object that includes all the attributes of each one of the Pokemons, alongside its constructor with the required parameters to create a Pokemon, and getter methods to access the information of each Pokemon.
 * @author juand
 *
 */

public class PokemonDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String mote;
	private int height;
	private String category;
	private String weight;
	private String [] attacks;
	private int level;
	private boolean taken;
	
	/**
	 * Constructor method for the PokemonDTO class. Includes all the parameters to create the object.
	 * @param name Name of the Pokemon
	 * @param mote Mote of the Pokemon given by the Trainer
	 * @param height Height of the Pokemon
	 * @param category Pokemon category
	 * @param weight Pokemon weight
	 * @param attacks Array including all the attacks that the Pokemon is able to perform. This array <strong>must</strong> have a maximum size of four spaces.
	 * @param level Pokemon level
	 * @param taken Determines if the Pokemon is already taken by a trainer, or not
	 */
	
	public PokemonDTO(String name, String mote, int height, String category, String weight, String[] attacks,
			int level, boolean taken) {
		this.name = name;
		this.mote = mote;
		this.height = height;
		this.category = category;
		this.weight = weight;
		this.attacks = attacks;
		this.level = level;
		this.taken= taken;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMote() {
		return mote;
	}

	public void setMote(String mote) {
		this.mote = mote;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String[] getAttacks() {
		return attacks;
	}

	public void setAttacks(String[] attacks) {
		this.attacks = attacks;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	public boolean getTomado() {
		return taken;
	}

	public void setTomado(boolean b) {
		this.taken = b;
	}

	@Override
	public String toString() {
		return "PokemonDTO [name=" + name + ", mote=" + mote + ", height=" + height + ", category=" + category
				+ ", weight=" + weight + ", attacks=" + Arrays.toString(attacks) + ", level=" + level + ", tomado="
				+ taken + "]";
	}

	
	
	 
	
	
	

}
