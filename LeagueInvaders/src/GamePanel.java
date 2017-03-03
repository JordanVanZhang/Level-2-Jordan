import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


public class GamePanel extends JPanel implements ActionListener{
	

	Timer timer;
	
	GamePanel(){
		
		timer = new Timer(1000/60,this);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		repaint();
		
		
	}
	
	void startGame(){
			
			timer.start();
			
		}
	
	public void paintCompenent(Graphics g){
		
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawRect(10, 10, 100, 100);
		g.fillRect(10, 10, 100, 100);
		
		
	}

	

}
