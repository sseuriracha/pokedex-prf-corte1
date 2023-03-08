package co.edu.unbosque.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PokemonClient extends Thread {
	
	private Socket client;
	private Socket mailbox;
	private ServerSocket server;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private int port;
	private String ip;
	
	public PokemonClient(int port, String address) {
		// TODO Auto-generated constructor stub
		try {
			this.client = null;
			this.mailbox = null;
			this.out = null;
			this.in = null;
			this.port = port; 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void send (String addition) {
		try {
			client = new Socket(ip, port);
			out = new ObjectOutputStream(client.getOutputStream());
			out.writeObject(addition);
			client.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String read (String toread) {
		String line = "";
		try {
			mailbox = new Socket(ip, port+1);
			out = new ObjectOutputStream(mailbox.getOutputStream());
			out.writeObject(toread);
			
			server = new ServerSocket(port + 100);
			in = new ObjectInputStream(mailbox.getInputStream());
			client = server.accept();
			line = (String) in.readObject();
			
			mailbox.close();
			client.close();
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;
	}

}
