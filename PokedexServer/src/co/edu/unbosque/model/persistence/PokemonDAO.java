package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Caja1;
import co.edu.unbosque.model.Caja2;
import co.edu.unbosque.model.Caja3;
import co.edu.unbosque.model.PokemonDTO;

public class PokemonDAO {

	private PokemonFile pokefile;
	private ArrayList<PokemonDTO> pokelist;

	public PokemonDAO(PokemonFile pokefile) {
		// TODO Auto-generated constructor stub
		this.pokefile = pokefile;
		pokelist = new ArrayList<PokemonDTO>();
	}

	public PokemonDTO buscar_pokemon(String mote) {
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

	public boolean lierar_pokemon(String mote) {

		try {
			PokemonDTO e = buscar_pokemon(mote);
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
public boolean agregar_pokemon (int opcion,PokemonDTO entrenador[], String name, String mote, int height, String category, String weight, String[] attacks, int level, String tomado) {
		
		if(buscar_pokemon(mote)== null) {
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

public boolean transferir_pokeon(int opcion, String mote1,String mote2,PokemonDTO entrenador[] ) {
	 
	for (int i = 0; i < entrenador.length; i++) {
		if(entrenador[i].getMote().equals(mote1)) {
			PokemonDTO e =buscar_pokemon(mote2);
			if(e!=null) {
				PokemonDTO nuevo1 = new PokemonDTO(e.getName(),e.getMote(),e.getHeight(),e.getCategory(),e.getWeight(),e.getAttacks(),e.getLevel(),true);
				lierar_pokemon(e.getMote());
				pokelist.add(nuevo1);
				pokefile.write(pokelist);

				if(opcion==1) { // la opcion 1 refiere a que se guarde el la caja 1
					PokemonDTO nuevo = new Caja1 (entrenador[i].getName(),entrenador[i].getMote(),entrenador[i].getHeight(),entrenador[i].getCategory(),entrenador[i].getWeight(),entrenador[i].getAttacks(),entrenador[i].getLevel(),false);
					lierar_pokemon(entrenador[i].getMote());
					pokelist.add(nuevo);
					pokefile.write(pokelist);
					return true;
				}else if(opcion==2) { // la opcion 2 refiere a que se guarde el la caja 2
					PokemonDTO nuevo = new Caja2 (entrenador[i].getName(),entrenador[i].getMote(),entrenador[i].getHeight(),entrenador[i].getCategory(),entrenador[i].getWeight(),entrenador[i].getAttacks(),entrenador[i].getLevel(),false);
					lierar_pokemon(entrenador[i].getMote());
					pokelist.add(nuevo);
					pokefile.write(pokelist);
					return true;
				}else if(opcion==3) { // la opcion 3 refiere a que se guarde el la caja 3
					PokemonDTO nuevo = new Caja3 (entrenador[i].getName(),entrenador[i].getMote(),entrenador[i].getHeight(),entrenador[i].getCategory(),entrenador[i].getWeight(),entrenador[i].getAttacks(),entrenador[i].getLevel(),false);
					lierar_pokemon(entrenador[i].getMote());
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
