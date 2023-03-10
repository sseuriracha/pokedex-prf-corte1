package co.edu.unbosque.controller;

import co.edu.unbosque.server.PokeServer;

public class Controller {
	
	private PokeServer server;
	
	public Controller() {
		// TODO Auto-generated constructor stub
		server = new PokeServer(5555);
		server.start();
	}

}
