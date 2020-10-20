package com.demo.bean;

public class Player {
	
	private int pId;
	private String pName;
	
	//Defualt Constructor
	public Player() {
		super();
	}

	//Paramaterized Constructor
	public Player(int pId, String pName, int teamId) {
		super();
		this.pId = pId;
		this.pName = pName;
	}

	//Setter Getter Methods
	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	//toString method
	@Override
	public String toString() {
		return "Player [pId=" + pId + ", pName=" + pName + "]";
	}
	
	
}
