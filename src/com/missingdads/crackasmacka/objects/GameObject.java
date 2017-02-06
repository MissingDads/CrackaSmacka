package com.missingdads.crackasmacka.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class GameObject {

	private static final List<GameObject> OBJECTS = new CopyOnWriteArrayList<>();

	protected int x, y;
	protected UUID uniqueId;
	protected int velX, velY;

	public GameObject(int x, int y) {

		this.x = x;
		this.y = y;
		this.uniqueId = UUID.randomUUID();

		OBJECTS.add(this);
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public abstract Rectangle getBounds();

	public void remove() {
		OBJECTS.remove(this);
	}

	public void setX(int x) {

		this.x = x;
	}

	public void setY(int y) {

		this.y = y;
	}

	public int getX() {

		return x;
	}

	public int getY() {

		return y;
	}

	public UUID getUniqueId() {

		return uniqueId;
	}

	public void setVelX(int velX) {

		this.velX = velX;
	}

	public void setVelY(int velY) {

		this.velY = velY;
	}

	public int getVelX() {

		return velX;
	}

	public int getVelY() {

		return velY;
	}

	public static List<GameObject> getObjects() {
		return OBJECTS;
	}
}
