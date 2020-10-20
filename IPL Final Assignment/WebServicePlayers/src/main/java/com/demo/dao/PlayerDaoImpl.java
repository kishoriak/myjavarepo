package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.bean.Player;
import com.demo.bean.PlayerData;


@Repository
public class PlayerDaoImpl implements PlayerDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public PlayerData getPlayersByTeams(int id) {
		List<Player> plist = jdbcTemplate.query("select * from product1 where catid=?", new Object[] {id}, new RowMapper<Player>() {

			public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
				Player player  = new Player();
				player.setpId(rs.getInt(1));
				player.setpName(rs.getString(2));
				return player;
			}
			
		});
		PlayerData playerData = new PlayerData(plist);
		return playerData;
	}

	
}
