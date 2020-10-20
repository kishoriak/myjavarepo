package com.demo.bean;

import java.util.List;

public class PlayerData {
	private List<Player> plist;

	public PlayerData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayerData(List<Player> plist) {
		super();
		this.plist = plist;
	}

	public List<Player> getPlist() {
		return plist;
	}

	public void setPlist(List<Player> plist) {
		this.plist = plist;
	}

	@Override
	public String toString() {
		return "PlayerData [plist=" + plist + "]";
	}
	
}
