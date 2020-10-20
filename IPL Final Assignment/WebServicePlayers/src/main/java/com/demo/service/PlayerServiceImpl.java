package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.PlayerData;
import com.demo.dao.PlayerDao;
import com.demo.dao.PlayerDaoImpl;

@Service
public class PlayerServiceImpl implements PlayerService{
	
	@Autowired
	PlayerDao playerDao;

	public PlayerData getPlayersByTeams(int id) {
		return playerDao.getPlayersByTeams(id);
	}
	

}
