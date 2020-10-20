package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.demo.bean.Team;

public class TeamDaoImpl implements TeamDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public Team getTeamId(String TeamName) {
		List<Team> teamList=jdbcTemplate.query("select * from team where teamname=?", new Object[] {TeamName} , new RowMapper<Team>() {
			
			public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
				Team team=new Team();
				team.setTeamId(rs.getInt(1));
				team.setTeamName(rs.getString(2));
				return team;
			}
		});
		return teamList.get(0);
	}

}
