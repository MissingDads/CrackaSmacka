package com.missingdads.crackasmacka.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Cracker extends GameObject {

	// private static int totalCrackers;

	public Cracker(int x, int y) {
		super(x, y);
		// totalCrackers++;

		this.setDuration(2000);
	}

	public void tick() {
	}

	public void render(Graphics g) {

		// g.setColor(new Color(random.nextInt(255), random.nextInt(255),
		// random.nextInt(255)));
		g.setColor(Color.YELLOW);
		g.drawOval(x, y, 50, 50);
		g.fillOval(x, y, 50, 50);
	}

	public Rectangle getBounds() {

		return null;
	}

}