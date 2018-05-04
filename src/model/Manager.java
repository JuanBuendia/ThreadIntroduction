package model;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Manager implements Runnable{

	private boolean stop;
	private int halfWidth;
	private int halfHeight;
	private Hero heroPlayer;
	private Thread myNPCThread;
	private ArrayList<Hero> enemyList;
	
	public Manager(int halfWidth, int halfHeight) {
		this.halfWidth = halfWidth;
		this.halfHeight = halfHeight;
		enemyList = new ArrayList<>();
		myNPCThread = new Thread(this);
	}
	
	public void moveOponnets() {
		for (Hero hero : enemyList) {
			if(heroPlayer.getPosX() > hero.getPosX()) {
				hero.moveRight();
			}else {
				hero.moveLeft();
			}
			if(heroPlayer.getPosY() > hero.getPosY()) {
				hero.moveDown();
			}else {
				hero.moveUp();
			}
		}
	}
	
	public void checkForDead() {
		Rectangle recPlayer = new Rectangle(heroPlayer.getPosX(), heroPlayer.getPosY(), 64, 64);
		for (Hero hero : enemyList) {
			Rectangle recEnemy = new Rectangle(hero.getPosX(), hero.getPosY(), 64, 64);
			if (recPlayer.intersects(recEnemy)) {
				stop = true;
				heroPlayer.die();
			}
			if(checkX() && checkY()) {
				heroPlayer.die();
			}
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
		for (Hero hero : enemyList) {
			if(hero.getPosX() <= (heroPlayer.getPosX() + 32) && hero.getPosX() >= (heroPlayer.getPosX() - 32)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkY() {
		for (Hero hero : enemyList) {
			if(hero.getPosY() <= (heroPlayer.getPosY() + 32) && hero.getPosY() >= (heroPlayer.getPosY() - 32)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isDead() {
		return heroPlayer.isDead();
	}
	
	public void initNewGame() {
		for (int i = 0; i < 20; i++) {
			System.out.println(i);
			Hero enemy = new Hero(((int) Math.random() * 100), i * 10 );
			enemyList.add(enemy);
		}
		heroPlayer = new Hero(halfWidth, halfHeight);
	}

	public Hero getStudent() {
		return heroPlayer; 
	}
	
	public ArrayList<Hero> getProsecutor() {
		return enemyList;
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