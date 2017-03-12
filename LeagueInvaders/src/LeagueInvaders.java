import java.awt.Dimension;

import javax.swing.JFrame;


public class LeagueInvaders {
	
	JFrame frame;
	GamePanel panel;
	static int width = 500;
	static int height = 800;
	
	public static void main(String[] args){
		
		LeagueInvaders league = new LeagueInvaders();
		
	}
	
	LeagueInvaders(){
		
		frame = new JFrame("Game");
		panel = new GamePanel();
		setup();
		
	}
	
	void setup(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setVisible(true);
		panel.startGame();
		
	}

}
