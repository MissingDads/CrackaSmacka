package com.missingdads.crackasmacka.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.missingdads.crackasmacka.Core;

public class Cracker extends GameObject {

	private static int totalCrackers;

	public Cracker(int x, int y) {
		super(x, y);
		totalCrackers++;

		this.setVelY((int) (Math.sqrt(totalCrackers)));
	}

	public void tick() {
		this.setY(getY() + getVelY());

		if (getY() > Core.HEIGHT) {
			remove();
			new Cracker(new Random().nextInt(Core.WIDTH), 0);
		}
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