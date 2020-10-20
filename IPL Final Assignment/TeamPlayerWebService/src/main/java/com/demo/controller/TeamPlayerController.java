package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.demo.bean.PlayerData;

import com.demo.bean.Team;

@RestController
public class TeamPlayerController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(value="/teamplayert/{id}")
	public String findByName(@PathVariable("id") int id) {
		PlayerData playerData = restTemplate.exchange("http://player-service/players/1",
				HttpMethod.GET, null, new ParameterizedTypeReference<PlayerData>() {}, id).getBody();
		return "Response" + playerData;
	}
	
	@GetMapping(value="/team/{name}")
	public String getTeamByName(@PathVariable("name") String name) {
		Team team = restTemplate.exchange("http://team-service/team/team1", HttpMethod.GET, 
				null, new ParameterizedTypeReference<Team>() {}, name).getBody();
		return "Response : " + team;
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
