package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import co.edu.unbosque.model.PokemonDTO;

public class PokemonFile {
	
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private File pokefile;
	
	public PokemonFile() {
		// TODO Auto-generated constructor stub
		this.pokefile = new File("src/pokemons.txt");
	}
	
	public void write(final ArrayList<PokemonDTO> pokelist) {
		try {
			this.out = new ObjectOutputStream(new FileOutputStream(this.pokefile));
			out.writeObject(pokelist);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<PokemonDTO> read() {
		ArrayList<PokemonDTO> pokelist = new ArrayList<>();
		if (pokefile.length() != 0L) {
			try {
				in = new ObjectInputStream(new FileInputStream(pokefile));
				pokelist = (ArrayList<PokemonDTO>) in.readObject();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} return pokelist;
	}

}
