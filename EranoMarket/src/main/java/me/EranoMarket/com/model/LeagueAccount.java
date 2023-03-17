package me.EranoMarket.com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class LeagueAccount {

	@Id
	private int id;
	
	private String lastseasonrank;
	
	private String duorank;
	
	private int level;
	
	@Enumerated(EnumType.STRING)
	private Server server;
	
	private int blue_essence;
	
	private int riotpoint;
	
	private User user;
	
	private double honorLevel;
	
}
