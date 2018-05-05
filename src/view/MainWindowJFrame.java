package view;

import model.Hero;
import controller.Event;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import controller.Controller;

public class MainWindowJFrame extends JFrame{

	private Canvas canvas;
	private static final long serialVersionUID = 1L;
	private static final String LOGO = "/img/logo.png";
	private static final String TITLE = "Team Fortress 2";

	public MainWindowJFrame(Controller controller) {
		setTitle(TITLE);
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