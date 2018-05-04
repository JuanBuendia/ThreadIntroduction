package model;

import java.awt.Rectangle;

public class Manager implements Runnable{

	private boolean stop;
	private int halfWidth;
	private int halfHeight;
	private Hero heroPlayer;
	private Thread myNPCThread;
	private Hero systemProsecutor;
	
	public Manager(int halfWidth, int halfHeight) {
		this.halfWidth = halfWidth;
		this.halfHeight = halfHeight;
		myNPCThread = new Thread(this);
	}
	
	public void moveOponnets() {
		if(heroPlayer.getPosX() > systemProsecutor.getPosX()) {
			systemProsecutor.moveRight();
		}else {
			systemProsecutor.moveLeft();
		}
		if(heroPlayer.getPosY() > systemProsecutor.getPosY()) {
			systemProsecutor.moveDown();
		}else {
			systemProsecutor.moveUp();
		}
	}
	
	public void checkForDead() {
		Rectangle recPlayer = new Rectangle(heroPlayer.getPosX(), heroPlayer.getPosY(), 64, 64);
		Rectangle recEnemy = new Rectangle(systemProsecutor.getPosX(), systemProsecutor.getPosY(), 64, 64);
		if (recPlayer.intersects(recEnemy)) {
			stop = true;
			heroPlayer.die();
		}
		if(checkX() && checkY()) {
			heroPlayer.die();
		}
	}
	
	public void moveRight() {
		heroPlayer.moveRight();
	}
	
	public void moveLeft() {
		heroPlayer.moveLeft();
	}
	
	public void moveUp() {
		heroPlayer.moveUp();
	}
	
	public void moveDown() {
		heroPlayer.moveDown();
	}
	
	private boolean checkX() {
		if(systemProsecutor.getPosX() <= (heroPlayer.getPosX() + 32) && systemProsecutor.getPosX() >= (heroPlayer.getPosX() - 32)) {
			return true;
		}
		return false;
	}
	
	private boolean checkY() {
		if(systemProsecutor.getPosY() <= (heroPlayer.getPosY() + 32) && systemProsecutor.getPosY() >= (heroPlayer.getPosY() - 32)) {
			return true;
		}
		return false;
	}
	
	public boolean isDead() {
		return heroPlayer.isDead();
	}
	
	public void initNewGame() {
		systemProsecutor = new Hero(200, 200);
		heroPlayer = new Hero(halfWidth, halfHeight);
	}

	public Hero getStudent() {
		return heroPlayer;
	}
	
	public Hero getProsecutor() {
		return systemProsecutor;
	}
	
	public void start() {
		myNPCThread.start();
	}
	
	public synchronized void stop() {
		stop = true;
		notify();
	}

	@Override
	public void run() {
		while(!isDead()) {
			moveOponnets();
			synchronized (this) {
				if (stop) {
					break;
				}
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}