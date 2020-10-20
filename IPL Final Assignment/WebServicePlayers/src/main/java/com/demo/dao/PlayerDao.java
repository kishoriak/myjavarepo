package com.demo.dao;

import java.util.List;

import com.demo.bean.PlayerData;


public interface PlayerDao {

	PlayerData getPlayersByTeams(int id);

}
