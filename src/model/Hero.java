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
	
	public void checkBorderX() {
		if(posX > 1360) {
			posX -= 25;
		}else if(posX < 0) {
			posX += 25;
		}
	}
	
	public void checkBorderY() {
		if(posY > 720) {
			posY -= 25;
		}else if(posY < 0) {
			posY += 25;
		}
	}
	
	public void moveRight() {
		checkBorderX();
		this.posX += 15;
	}
	
	public void moveLeft() {
		checkBorderX();
		this.posX -= 15;
	}
	
	public void moveUp() {
		checkBorderY();
		this.posY -= 15;
	}
	
	public void moveDown() {
		checkBorderY();
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