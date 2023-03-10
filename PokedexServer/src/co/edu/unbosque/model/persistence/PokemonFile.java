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

/**
 * The PokemonFile class contains all the methods relevant to file handling, including creation, deletion and re-writing of the file.
 * @author juand
 *
 */

public class PokemonFile {
	
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private File pokefile;
	
	/**
	 * Constructor that creates the File object representing the file in disk.
	 */
	
	public PokemonFile() {
		// TODO Auto-generated constructor stub
		this.pokefile = new File("src/pokemons.txt");
	}
	
	/**
	 * Writes an ArrayList of Pokemons inside the file
	 * @param pokelist list of pokemons to be written.
	 */
	
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
	
	/**
	 * Reads objects from the file.
	 * @return ArrayList with Pokemons that was written inside the file.
	 */
	
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

	public ObjectInputStream getIn() {
		return in;
	}

	public void setIn(ObjectInputStream in) {
		this.in = in;
	}

	public ObjectOutputStream getOut() {
		return out;
	}

	public void setOut(ObjectOutputStream out) {
		this.out = out;
	}

	public File getPokefile() {
		return pokefile;
	}

	public void setPokefile(File pokefile) {
		this.pokefile = pokefile;
	}
	

}
