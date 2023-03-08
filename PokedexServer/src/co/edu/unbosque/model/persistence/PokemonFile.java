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
		this.pokefile = new File ("src/pokedex.dat");
		if (!this.pokefile.exists()) {
			try {
				pokefile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void write (final ArrayList<PokemonDTO> lst) {
		try {
			this.out = new ObjectOutputStream(new FileOutputStream(this.pokefile));
			out.writeObject(lst);
			out.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex2) {
			ex2.printStackTrace();
		}
	}
	
	public ArrayList<PokemonDTO> read() {
		ArrayList<PokemonDTO> output = new ArrayList<PokemonDTO>();
		if (this.pokefile.length() != 0L) {
			try {
				in = new ObjectInputStream(new FileInputStream(pokefile));
				output = (ArrayList<PokemonDTO>) in.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			} catch (ClassNotFoundException e3) {
				e3.printStackTrace();
			}
		}
		return output;
	}

}
