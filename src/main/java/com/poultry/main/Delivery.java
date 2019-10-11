package com.poultry.main;

import java.util.LinkedList;
import java.util.Queue;

import com.poultry.client.Clients;

public class Delivery {
	Clients[] clients = new Clients[5];
	Queue<Clients> priority = new LinkedList<Clients>();
	final int egg = 20;
	static int sobra = 0;

	public void delivery() {
		for (int i = 0; i < clients.length; i++) {
			clients[i] = new Clients("client" + i, 20, false);
		}
	}

	public void deliverClients(int eggs) {
		eggs += sobra;
		System.out.println("Current Eggs: " + eggs);
		while (true) {
			if (priority.isEmpty()) {
				for (int i = 0; i < clients.length; i++) {
					if (clients[i].isHaveDebt() == true) {
						clients[i].setHaveDebt(false);
					} else {
						if (eggs > 19) {
							System.out.println("\n" + clients[i].getClient() + "\tRecieved: " + clients[i].getNeeds()
									+ "\tNeeds: " + 0);
							clients[i].setNeeds(egg);
							eggs -= egg;
						} else if (eggs < 20 && eggs != -1) {
							clients[i].setNeeds(eggs);
							System.out.println("\n" + clients[i].getClient() + "\tRecieved: " + clients[i].getNeeds()
									+ "\tNeeds: " + (20 - eggs));
							System.out.println("\n"+clients[i].getClient()+" is priority tomorrow.");
							clients[i].setHaveDebt(true);
							clients[i].setNeeds((20 - eggs) + egg);
							priority.add(clients[i]);
							eggs = 0;
						} else {
							System.out.println("\n" + clients[i].getClient() + "\tRecieved: " + clients[i].getNeeds()
									+ "\tNeeds: " + egg);
							clients[i].setHaveDebt(true);
							priority.add(clients[i]);
							eggs = 0;
						}
					}
				}
				break;
			} else {
				while (priority.size() != 0) {
					Clients cli = new Clients();
					cli = priority.peek();
					eggs -= cli.getNeeds();
					System.out.println("\n" + cli.getClient() + "\tReceived: " + cli.getNeeds() + "\tNeeds: " + 0);
					priority.remove();
				}
			}
		}

		checkEggs(eggs);
	}

	public void checkEggs(int eggs) {
		if (eggs > 0) {
			sobra = eggs;
			System.out.print("Sobra:" + sobra);
		} else {
			sobra = 0;
		}
	}
}
