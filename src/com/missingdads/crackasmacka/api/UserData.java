package com.missingdads.crackasmacka.api;

public class UserData {

	private int smacks;
	private int points;
	private int lives;

	public UserData() {
		this.smacks = Integer.MAX_VALUE;
		this.points = Integer.MAX_VALUE;
		this.lives = Integer.MAX_VALUE;
	}

	public int getSmacks() {
		return smacks;
	}

	public int getPoints() {
		return points;
	}

	public int getLives() {
		return lives;
	}

}