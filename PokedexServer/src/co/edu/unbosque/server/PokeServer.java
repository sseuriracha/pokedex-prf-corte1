package co.edu.unbosque.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.model.persistence.PokemonDAO;
import co.edu.unbosque.model.persistence.PokemonFile;

public class PokeServer extends Thread {
	
	private ServerSocket server;
	private Socket client, mailbox;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private int port;
	private PokemonDAO pokedao;
	private PokemonFile pokefile;
	private String ip;
	
	public PokeServer(final int port) {
		// TODO Auto-generated constructor stub
		try {
			server = null;
			client = null;
			mailbox = null;
			out = null;
			in = null;
			this.port = port;
			pokefile = new PokemonFile();
			pokedao = new PokemonDAO(pokefile);
			ip = "localhost";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
