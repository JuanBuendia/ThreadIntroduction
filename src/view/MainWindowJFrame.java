package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import controller.Controller;
import controller.Event;
import model.Hero;

public class MainWindowJFrame extends JFrame{

	private Canvas canvas;
	private static final long serialVersionUID = 1L;
	private static final String LOGO = "/img/logo.png";
	

	public MainWindowJFrame(Controller controller) {
		setTitle("Student Loans");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource(LOGO)).getImage());
		
		canvas = new Canvas(controller);
		canvas.addKeyListener(controller);
		add(canvas, BorderLayout.CENTER);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(controller);
		btnStart.setActionCommand(Event.START.toString());
		add(btnStart, BorderLayout.PAGE_END);
		
		setVisible(true);
	}
	
	public void setPanelFocus() {
		canvas.requestFocus();
	}
	
	public void refreshObjects(Hero student, ArrayList<Hero> enemies) {
		canvas.refreshObjects(student, enemies);
	}
	
	public int getW() {
		return canvas.getW();
	}
	
	public int getH() {
		return canvas.getH();
	}
}