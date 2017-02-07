package com.missingdads.crackasmacka.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import com.missingdads.crackasmacka.Core;

public abstract class GameObject {

	private static final List<GameObject> OBJECTS = new CopyOnWriteArrayList<>();
	public static final PriorityQueue<GameObject> REVERT_QUEUE = new PriorityQueue<>(100, new Comparator<GameObject>() {
		@Override
		public int compare(GameObject o1, GameObject o2) {
			return (int) (o1.duration - o2.duration);
		}
	});

	protected int x, y;
	protected UUID uniqueId;
	protected int velX, velY;
	private long startTime;
	private long duration;
	private boolean inRevertQueue;

	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		this.uniqueId = UUID.randomUUID();
		this.startTime = System.currentTimeMillis();

		OBJECTS.add(this);
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public abstract Rectangle getBounds();

	public void remove() {
		if (this instanceof Cracker) {
			new Cracker(new Random().nextInt(Core.WIDTH), new Random().nextInt(Core.HEIGHT));
		}
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

	public long getStartTime() {
		return startTime;
	}

	public void setDuration(long duration) {
		if (inRevertQueue) {
			REVERT_QUEUE.remove(this);
		}
		this.inRevertQueue = true;
		this.duration = duration + System.currentTimeMillis();
		REVERT_QUEUE.add(this);
	}

	public static void checkReversions() {
		long currentTime = System.currentTimeMillis();
		while (!REVERT_QUEUE.isEmpty()) {
			GameObject object = REVERT_QUEUE.peek();
			if (currentTime > object.duration) {
				REVERT_QUEUE.poll();
				object.remove();
			} else {
				break;
			}
		}
	}

	public static List<GameObject> getObjects() {
		return OBJECTS;
	}
}
