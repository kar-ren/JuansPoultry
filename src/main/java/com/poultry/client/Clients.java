package com.poultry.client;

public class Clients {
	private String client;
	private int needs = 20;
	private boolean haveDebt = false;
	
	public Clients(String client, int needs, boolean bool) {
		super();
		this.client = client;
		this.needs = needs;
		this.haveDebt = bool;
	}
	public Clients() {
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public int getNeeds() {
		return needs;
	}
	public void setNeeds(int needs) {
		this.needs = needs;
	}
	public boolean isHaveDebt() {
		return haveDebt;
	}
	public void setHaveDebt(boolean haveDebt) {
		this.haveDebt = haveDebt;
	}
	
}
