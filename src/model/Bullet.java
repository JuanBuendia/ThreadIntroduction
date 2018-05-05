package model;

public class Bullet {

	private int posX;
	private int posY;
	private int width;
	private int heigth;

	public Bullet(int posX, int posY, int width, int heigth) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.heigth = heigth;
	}

	public void moveUp() {
		this.posY -= 5;
	}
	
	public void moveDown() {
		this.posY += 5;
	}
	
	public void moveRigth() {
		this.posX += 5;
	}
	
	public void moveLeft() {
		this.posX -= 5;
	}
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeigth() {
		return heigth;
	}
}