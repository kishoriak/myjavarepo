package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bean.Team;
import com.demo.service.TeamService;

@RestController
public class TeamController {
	@Autowired
	TeamService teamService;
	
	@GetMapping(value="/team/{teamName}")
	public Team getTeamId(@PathVariable("teamName") String teamName) {
		return teamService.getTeamId(teamName);
	}
}
