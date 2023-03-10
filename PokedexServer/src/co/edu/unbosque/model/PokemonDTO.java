package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

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
	
	public PokemonDTO(String name, String mote, int height, String category, String weight, String[] attacks,
			int level) {
		this.name = name;
		this.mote = mote;
		this.height = height;
		this.category = category;
		this.weight = weight;
		this.attacks = attacks;
		this.level = level;
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

	@Override
	public String toString() {
		return "PokemonDTO [name=" + name + ", mote=" + mote + ", height=" + height + ", category=" + category
				+ ", weight=" + weight + ", attacks=" + Arrays.toString(attacks) + ", level=" + level + "]";
	}
	
	 
	
	
	

}
