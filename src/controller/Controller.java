package controller;

import model.Manager;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import view.MainWindowJFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements KeyListener{

	private int gameTime;
	private Timer generalTimer;
	private Manager gameManager;
	private MainWindowJFrame mainWindow;
	
	public Controller() {
		gameTime = 0;
		mainWindow = new MainWindowJFrame(this);
		gameManager = new Manager(650, 350);
		start();
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		switch(Event.valueOf(e.getActionCommand())) {
//		case START:
//			start();
//			break;
//		default:
//			break;
//		}
//	}
	
	private void start() {
		gameTime = 0;
		gameManager.start();
		gameManager.initNewGame();
		generalTimer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameTime++;
				checkForDead();
				gameManager.moveOponnets();
				mainWindow.refreshObjects(gameManager.getStudent(), gameManager.getProsecutor());
			}
		});
		generalTimer.start();
	}
	
	private void checkForDead() {
		if(gameManager.isDead()) {
			generalTimer.stop();
			JOptionPane.showInputDialog("OK");
			System.out.println(gameTime);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(gameTime);
			if (KeyEvent.VK_UP == e.getKeyCode()) {
				moveUp();
			}else if(KeyEvent.VK_DOWN == e.getKeyCode()){
				moveDown();
			}else if(KeyEvent.VK_RIGHT == e.getKeyCode()){
				moveRight();
			}else if(KeyEvent.VK_LEFT == e.getKeyCode()){
				moveLeft();
			}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(gameTime);
			if (KeyEvent.VK_UP == e.getKeyCode()) {
				moveUp();
			}else if(KeyEvent.VK_DOWN == e.getKeyCode()){
				moveDown();
			}else if(KeyEvent.VK_RIGHT == e.getKeyCode()){
				moveRight();
			}else if(KeyEvent.VK_LEFT == e.getKeyCode()){
				moveLeft();
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {
			if (KeyEvent.VK_UP == e.getKeyCode()) {
				moveUp();
			}else if(KeyEvent.VK_DOWN == e.getKeyCode()){
				moveDown();
			}else if(KeyEvent.VK_RIGHT == e.getKeyCode()){
				moveRight();
			}else if(KeyEvent.VK_LEFT == e.getKeyCode()){
				moveLeft();
			}
	}
	
	private void moveLeft() {
		gameManager.moveLeft();
	}

	private void moveRight() {
		gameManager.moveRight();
	}

	private void moveDown() {
		gameManager.moveDown();
	}

	private void moveUp() {
		gameManager.moveUp();
	}
}