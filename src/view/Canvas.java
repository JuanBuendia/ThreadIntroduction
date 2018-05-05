package view;

import model.Hero;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.event.KeyListener;

public class Canvas extends JPanel{

	private Hero student;
	private ArrayList<Hero> enemies;
	private static final long serialVersionUID = 1L;
	private static final Color BACKGROUND = Color.decode("#A5D6A7");
	private ImageIcon LOAN = new ImageIcon(getClass().getResource("/img/spycrab.gif"));
	private ImageIcon STUDENT = new ImageIcon(getClass().getResource("/img/screaming-eagle.gif"));

	public Canvas(KeyListener controller) {
		setBackground(BACKGROUND);
	}
	
	public void refreshObjects(Hero student, ArrayList<Hero> enemies) {
		this.student = student;
		this.enemies = enemies;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (student != null && enemies != null) {
			showStudent(g);
			showProsecutor(g);
		}
		repaint();
	}
	
	public void showStudent(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawImage(STUDENT.getImage(), student.getPosX(), student.getPosY(), this);
		g.setColor(BACKGROUND);
		g.drawRect(student.getPosX(), student.getPosY(), 70, 70);
	}
	
	public void showProsecutor(Graphics g) {
		for (Hero hero : enemies) {
			g.setColor(Color.BLACK);
			g.drawImage(LOAN.getImage(), hero.getPosX(), hero.getPosY(), this);
			g.setColor(BACKGROUND);
			g.drawRect(hero.getPosX(), hero.getPosY(), 70, 70);
		}
	}

	public int getW() {
		return getWidth()/2;
	}
	
	public int getH() {
		return getHeight()/2;
	}
}