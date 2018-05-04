package model;

public class Hero {

	private int posX;
	private int posY;
	private boolean dead;
	
	public Hero(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void moveRight() {
		this.posX += 15;
	}
	
	public void moveLeft() {
		this.posX -= 15;
	}
	
	public void moveUp() {
		this.posY -= 15;
	}
	
	public void moveDown() {
		this.posY += 15;
	}
	
	public void die() {
		dead = true;
	}
	
	public boolean isDead() {
		return dead;
	}
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}