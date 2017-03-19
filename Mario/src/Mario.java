import java.awt.Font;

import javax.swing.JFrame;

public class Mario {
	
	JFrame window;
	final static int windowWidth = 1000;
	final static int windowHeight = 1000;
	GamePanel panel;
	
	
	public static void main(String [] args){
		Mario game = new Mario();
	}
	
	Mario(){
		window = new JFrame();
		panel = new GamePanel();
		window.addKeyListener(panel);
		setup();
	}
	
	void setup(){
		window.add(panel);
		window.setSize(windowWidth, windowHeight);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		panel.startGame();
	}
	
}