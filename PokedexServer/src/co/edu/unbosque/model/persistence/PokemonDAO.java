package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Caja1;
import co.edu.unbosque.model.Caja2;
import co.edu.unbosque.model.Caja3;
import co.edu.unbosque.model.PokemonDTO;

/**
 * <h1>PokemonDAO</h1>
 * The PokemonDAO class is the Data Access Object containing all the methods required to manipulate the storage of each one of the Pokemons created as PokemonDTO objects.
 * @author juand
 *
 */

public class PokemonDAO {

	private PokemonFile pokefile;
	private ArrayList<PokemonDTO> pokelist;

	/**
	 * Constructor for the PokemonDAO class.
	 * @param pokefile PokemonFile object in charge of file handling
	 */
	
	public PokemonDAO(PokemonFile pokefile) {
		// TODO Auto-generated constructor stub
		this.pokefile = pokefile;
		pokelist = new ArrayList<PokemonDTO>();
	}
	
	/**
	 * Searches for a Pokemon inside the array of Pokemons, using the mote given by the trainer.
	 * @param mote Name given by the trainer. The method searches the ArrayList using this name.
	 * @return The PokemonDTO object that was found. If it is not found, an empty object will be returned. 
	 */

	public PokemonDTO searchPokemon(String mote) {
		PokemonDTO encontrado = null;
		if(!pokelist.isEmpty()) {
			for (int i = 0; i < pokelist.size(); i++) {
				if (pokelist.get(i).getMote().equals(mote)) {
					encontrado = pokelist.get(i);
					return encontrado;
				}
			}
		}
		return encontrado;
	}
	
	/**
	 * Deletes a Pokemon from the ArrayList, as well as from the file.
	 * @param mote Name given by the trainer. The method searches the ArrayList using this name.
	 * @return
	 */

	public boolean freePokemon(String mote) {

		try {
			PokemonDTO e = searchPokemon(mote);
			if(e!= null) {
				pokelist.remove(e);
				pokefile.getPokefile().delete();
				pokefile.getPokefile().createNewFile();
				pokefile.write(pokelist);
				return true;
			}else {
				return false;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}

	}
	
	/**
	 * Adds a Pokemon to the Array using the parameters to create a PokemonDTO object.
	 * @param opcion option where the trainer wants to store the Pokemon. They can choose one of three boxes with illimited space, or the trainer's "pocket", with space for 6 pokemons.
	 * @param entrenador array of Pokemons in the trainer's pocket.
	 * @param name Pokemon name
	 * @param mote Pokemon mote that the trainer gives to it
	 * @param height Pokemon height in centimeters
	 * @param category Pokemon category
	 * @param weight Pokemon weight in kilograms
	 * @param attacks Pokemon randomized attacks
	 * @param level Pokemon level
	 * @param tomado Determines if the Pokemon is already taken.
	 * @return a boolean value determining if the Pokemon was added.
	 */
	
	public boolean addPokemon (int opcion,PokemonDTO entrenador[], String name, String mote, int height, String category, String weight, String[] attacks, int level, String tomado) {
		
		if(searchPokemon(mote)== null) {
			if(opcion==1) {// la opcion 1 refiere a que se se guarde el el bolsillo
				if(entrenador.length!=6) {
					PokemonDTO nuevo = new PokemonDTO (name,mote,height,category,weight,attacks,level,true);
					pokelist.add(nuevo);
					pokefile.write(pokelist);
					return true;
				}else {
					return false;
				}
			}else if(opcion==2) { // la opcion 2 refiere a que se guarde el la caja 1
				PokemonDTO nuevo = new Caja1 (name,mote,height,category,weight,attacks,level,false);
				pokelist.add(nuevo);
				pokefile.write(pokelist);
				return true;
			}else if(opcion==3) { // la opcion 3 refiere a que se guarde el la caja 2
				PokemonDTO nuevo = new Caja2 (name,mote,height,category,weight,attacks,level,false);
				pokelist.add(nuevo);
				pokefile.write(pokelist);
				return true;
			}else if(opcion==4) { // la opcion 4 refiere a que se guarde el la caja 3
				PokemonDTO nuevo = new Caja3 (name,mote,height,category,weight,attacks,level,false);
				pokelist.add(nuevo);
				pokefile.write(pokelist);
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
	
	/**
	 * Transfers Pokemons between the trainer's pocket and the boxes in the server
	 * @param opcion
	 * @param mote1
	 * @param mote2
	 * @param entrenador
	 * @return
	 */

public boolean transferPokemon(int opcion, String mote1,String mote2,PokemonDTO entrenador[] ) {
	 
	for (int i = 0; i < entrenador.length; i++) {
		if(entrenador[i].getMote().equals(mote1)) {
			PokemonDTO e =searchPokemon(mote2);
			if(e!=null) {
				PokemonDTO nuevo1 = new PokemonDTO(e.getName(),e.getMote(),e.getHeight(),e.getCategory(),e.getWeight(),e.getAttacks(),e.getLevel(),true);
				freePokemon(e.getMote());
				pokelist.add(nuevo1);
				pokefile.write(pokelist);

				if(opcion==1) { // la opcion 1 refiere a que se guarde el la caja 1
					PokemonDTO nuevo = new Caja1 (entrenador[i].getName(),entrenador[i].getMote(),entrenador[i].getHeight(),entrenador[i].getCategory(),entrenador[i].getWeight(),entrenador[i].getAttacks(),entrenador[i].getLevel(),false);
					freePokemon(entrenador[i].getMote());
					pokelist.add(nuevo);
					pokefile.write(pokelist);
					return true;
				}else if(opcion==2) { // la opcion 2 refiere a que se guarde el la caja 2
					PokemonDTO nuevo = new Caja2 (entrenador[i].getName(),entrenador[i].getMote(),entrenador[i].getHeight(),entrenador[i].getCategory(),entrenador[i].getWeight(),entrenador[i].getAttacks(),entrenador[i].getLevel(),false);
					freePokemon(entrenador[i].getMote());
					pokelist.add(nuevo);
					pokefile.write(pokelist);
					return true;
				}else if(opcion==3) { // la opcion 3 refiere a que se guarde el la caja 3
					PokemonDTO nuevo = new Caja3 (entrenador[i].getName(),entrenador[i].getMote(),entrenador[i].getHeight(),entrenador[i].getCategory(),entrenador[i].getWeight(),entrenador[i].getAttacks(),entrenador[i].getLevel(),false);
					freePokemon(entrenador[i].getMote());
					pokelist.add(nuevo);
					pokefile.write(pokelist);
					return true;
				}
				
			}
			return false;
		}
		return false;
	}
	return false;
	
}

}
