package com.missingdads.crackasmacka;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import com.missingdads.crackasmacka.api.UserData;
import com.missingdads.crackasmacka.listeners.KeyInput;
import com.missingdads.crackasmacka.objects.Cracker;
import com.missingdads.crackasmacka.objects.GameObject;

public class Core extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 720;
	public static final int HEIGHT = WIDTH / 12 * 9;

	private Thread thread;
	private boolean running = false;

	public static Core game;
	private Window window;
	private Shop shop;
	private UserData userData;

	public static boolean ShopOpen = false;

	public Core() {
		this.addKeyListener(new KeyInput());

		this.window = new Window(WIDTH, HEIGHT, "Game", this);
		this.userData = new UserData();

		int x = new Random().nextInt(WIDTH);
		int y = 0;
		new Cracker(x, y);

	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {

			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {

				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {

				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		for (GameObject object : GameObject.getObjects()) {
			object.tick();
			System.out.println(ShopOpen);
		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {

			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		for (GameObject object : GameObject.getObjects()) {
			object.render(g);
		}

		g.dispose();
		bs.show();
	}

	public static void main(String args[]) {
		new Core();
	}

	public Window getWindow() {
		return window;
	}
	
	public Shop getShop() {
		return shop;
	}
	
	public UserData getUserData() {
		return userData;
	}
}
