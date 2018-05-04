package view;

import model.Hero;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Canvas extends JPanel{

	private Hero student;
	private Hero prosecutor;
	private static final long serialVersionUID = 1L;
	private static final Color BACKGROUND = Color.decode("#A5D6A7");
	private ImageIcon LOAN = new ImageIcon(getClass().getResource("/img/loan.png"));
	private ImageIcon STUDENT = new ImageIcon(getClass().getResource("/img/student.png"));

	public Canvas(KeyListener controller) {
		setBackground(BACKGROUND);
	}
	
	public void refreshObjects(Hero student, Hero prosecutor) {
		this.student = student;
		this.prosecutor = prosecutor;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (student != null && prosecutor != null) {
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
		g.setColor(Color.BLACK);
		g.drawImage(LOAN.getImage(), prosecutor.getPosX(), prosecutor.getPosY(), this);
		g.setColor(BACKGROUND);
		g.drawRect(prosecutor.getPosX(), prosecutor.getPosY(), 70, 70);
	}

	public int getW() {
		return getWidth()/2;
	}
	
	public int getH() {
		return getHeight()/2;
	}
}