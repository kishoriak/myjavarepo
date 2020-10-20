package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.bean.PlayerData;

import com.demo.service.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	PlayerService playerService;
	
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping(value="/players/{id}")
	public PlayerData getPlayersByTeams(@PathVariable("id") int id) {
		return playerService.getPlayersByTeams(id);
	}
}
