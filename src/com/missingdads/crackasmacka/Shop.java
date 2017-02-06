package com.missingdads.crackasmacka;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Shop extends Canvas {

	private static final long serialVersionUID = -7960846789524068075L;
	private JFrame shop;

	public Shop(Core game) {

		this.shop = new JFrame("Shop");

		shop.setPreferredSize(new Dimension(Core.WIDTH, Core.HEIGHT));
		shop.setMaximumSize(new Dimension(Core.WIDTH, Core.HEIGHT));
		shop.setMinimumSize(new Dimension(Core.WIDTH, Core.HEIGHT));

		shop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		shop.setResizable(false);
		shop.setLocationRelativeTo(null);
		shop.add(game);
	

	}

	public void tick() {
		if (Core.ShopOpen) {
			if (!shop.isVisible()) {
				//shop.setVisible(true);
				//Core.game.getWindow().getFrame().setVisible(false);
			}
		} else {
			if (shop.isVisible()) {
				//shop.setVisible(false);
				//Core.game.getWindow().getFrame().setVisible(true);
			}
		}
	}

	public void render(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Core.WIDTH, Core.HEIGHT);
	}

}
