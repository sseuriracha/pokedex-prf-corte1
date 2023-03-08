package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class PokemonDTO implements Serializable{
	
	private String name;
	private int height;
	private String category;
	private String weight;
	private ArrayList<String> abilities;
	
	public PokemonDTO(String name, int height, String category, String weight, ArrayList<String> abilities) {
		this.name = name;
		this.height = height;
		this.category = category;
		this.weight = weight;
		this.abilities = abilities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public ArrayList<String> getAbilities() {
		return abilities;
	}

	public void setAbilities(ArrayList<String> abilities) {
		this.abilities = abilities;
	}

	@Override
	public String toString() {
		return "PokemonDTO [name=" + name + ", height=" + height + ", category=" + category + ", weight=" + weight
				+ ", abilities=" + abilities + "]";
	}
	
	
	
	
	
}
