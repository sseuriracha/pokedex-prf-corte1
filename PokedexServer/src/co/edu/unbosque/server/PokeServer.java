package co.edu.unbosque.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.model.persistence.PokemonDAO;
import co.edu.unbosque.model.persistence.PokemonFile;

/**
 * The PokeServer class is in charge of setting up the server that communicates with the clients using sockets.
 * @author juand
 *
 */

public class PokeServer extends Thread {
	
	private ServerSocket server;
	private Socket client, mailbox;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private int port;
	private PokemonDAO pokedao;
	private PokemonFile pokefile;
	private String ip;
	
	/**
	 * Creates the server, and connects with a network port.
	 * @param port The port where the server is going to connect.
	 */
	
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
	
	public void run() {
		try {
			server = new ServerSocket(port);
			System.out.println("Server created... waiting for client");
			client = server.accept();
			System.out.println("Client connected");
			out = new ObjectOutputStream(client.getOutputStream());
			in = new ObjectInputStream(client.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
