package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.demo.bean.Team;
import com.demo.dao.TeamDao;

@Service
public class TeamServiceImpl implements TeamService{
	
	@Autowired
	TeamDao teamDao;

	public Team getTeamId(String teamName) {
		return teamDao.getTeamId(teamName);
	}

}
