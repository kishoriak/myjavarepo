package com.demo.bean;

import java.util.List;

public class TeamData {
	private List<Team> tlist;

	public TeamData() {
		super();
	}

	public TeamData(List<Team> tlist) {
		super();
		this.tlist = tlist;
	}

	public List<Team> getTlist() {
		return tlist;
	}

	public void setTlist(List<Team> tlist) {
		this.tlist = tlist;
	}

	@Override
	public String toString() {
		return "TeamData [tlist=" + tlist + "]";
	}
	
	
	
}
