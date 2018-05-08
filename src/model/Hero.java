package model;

public class Hero {

	private int posX;
	private int posY;
	private boolean dead;
	
	public Hero(int posX, int posY) {
		dead = false;
		this.posX = posX;
		this.posY = posY;
	}
	
	public void moveRight() {
		if(posX < 1280) {
			posX += 25;
		}
	}
	
	public void moveLeft() {
		if(posX > 650) {
			posX -= 25;
		}
	}
	
	public void moveUp() {
		if(posY > 10) {
			this.posY -= 15;
		}
	}
	
	public void moveDown() {
		if(posY < 620) {
			this.posY += 15;
		}
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