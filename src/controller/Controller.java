package controller;

import model.Manager;
import javax.swing.Timer;
import view.MainWindowJFrame;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements KeyListener, ActionListener{

	private int gameTime;
	private Timer generalTimer;
	private Manager gameManager;
	private MainWindowJFrame mainWindow;
	
	public Controller() {
		gameTime = 0;
		mainWindow = new MainWindowJFrame(this);
		gameManager = new Manager(650, 350);
	}
	
	private void start() {
		gameTime = 0;
		gameManager.start();
		gameManager.initNewGame();
		mainWindow.setPanelFocus();
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(Event.valueOf(e.getActionCommand())) {
		case START:
			start();
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
			moveTo(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
			moveTo(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
			moveTo(e);
	}

	private void moveTo(KeyEvent e) {
		if (KeyEvent.VK_UP == e.getKeyCode()) {
			gameManager.moveUp();
		}else if(KeyEvent.VK_DOWN == e.getKeyCode()){
			gameManager.moveDown();
		}else if(KeyEvent.VK_RIGHT == e.getKeyCode()){
			gameManager.moveRight();
		}else if(KeyEvent.VK_LEFT == e.getKeyCode()){
			gameManager.moveLeft();
		}else if(KeyEvent.VK_F == e.getKeyCode()) {
			
		}
	}
	
	private void checkForDead() {
		if(gameManager.isDead()) {
			generalTimer.stop();
			JOptionPane.showInputDialog("OK");
			System.out.println(gameTime);
		}
	}
}