package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.PokemonDTO;

public class PokemonDAO {
	
	private PokemonFile pokefile;
	private ArrayList<PokemonDTO> pokelist;
	
	public PokemonDAO(PokemonFile pokefile) {
		// TODO Auto-generated constructor stub
		this.pokefile = pokefile;
		pokelist = new ArrayList<PokemonDTO>();
	}

}
