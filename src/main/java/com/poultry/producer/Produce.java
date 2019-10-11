package com.poultry.producer;

import java.util.Random;

import com.poultry.main.Delivery;

public class Produce extends Thread implements Runnable {
	Random random = new Random();
	final int maxi = 120;
	final int mini = 80;
	public static int eggs;
	int days = 0;
	Delivery del = new Delivery();
	
	public void run() {
		del.delivery();
		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\n\n\nDay " + ++days + "\n");
			eggs = random.nextInt((maxi - mini) + 1) + mini;
			System.out.println("Produce eggs : " + eggs);
	        del.deliverClients(eggs);
		}
	}
}
