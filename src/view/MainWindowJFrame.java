package view;

import model.Hero;
import java.awt.Color;
import java.awt.Font;
import controller.Event;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import controller.Controller;
import java.awt.BorderLayout;

public class MainWindowJFrame extends JFrame{

	private Canvas canvas;
	private static final String BTN_START = "Start";
	private static final long serialVersionUID = 1L;
	private static final Color FOREGROUND = Color.WHITE;
	private static final String TITLE = "Team Fortress 2";
	private Font font= new Font("Agency FB", Font.BOLD, 24);
	private static final Color BACKGROUND = Color.decode("#6B6056");
	private ImageIcon LOGO = new ImageIcon(getClass().getResource("/img/logo.png"));

	public MainWindowJFrame(Controller controller) {
		setTitle(TITLE);
		setIconImage(LOGO.getImage());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		canvas = new Canvas(controller);
		canvas.addKeyListener(controller);
		add(canvas, BorderLayout.CENTER);
		
		JButton btnStart = new JButton(BTN_START);
		btnStart.setFont(font);
		btnStart.setFocusable(false);
		btnStart.setForeground(FOREGROUND);
		btnStart.setBackground(BACKGROUND);
		btnStart.addActionListener(controller);
		btnStart.setActionCommand(Event.START.toString());
		add(btnStart, BorderLayout.PAGE_END);
		
		setVisible(true);
	}
	
	public int getW() {
		return canvas.getW();
	}
	
	public int getH() {
		return canvas.getH();
	}
	
	public void setPanelFocus() {
		canvas.requestFocus();
	}
	
	public void refreshObjects(Hero student, ArrayList<Hero> enemies) {
		canvas.refreshObjects(student, enemies);
	}
}