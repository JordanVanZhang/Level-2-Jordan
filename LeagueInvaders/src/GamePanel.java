import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class GamePanel 
extends JPanel 
implements ActionListener, KeyListener{
	
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font titleFont2;
	Timer timer;
	Rocketship rocket = new Rocketship(250,700,50,50);
	ObjectManager manager;
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	
	
	GamePanel(){
		
		timer = new Timer(1000/60,this);
		titleFont = new Font("Arial",Font.PLAIN,48);
		titleFont2 = new Font("Arial",Font.PLAIN,25);
		manager = new ObjectManager();
		manager.addObject(rocket);
		
		try {
			 alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			 rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			 bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
			}
		catch (IOException e) {
			e.printStackTrace();
		}


		
	}
	
	

	public void actionPerformed(ActionEvent e) {
		
		if(currentState == MENU_STATE){
			updateMenuState();
		}else if(currentState == GAME_STATE){
			updateGameState();
		}else if(currentState == END_STATE){
			updateEndState();
		}

		repaint();
		
	}
	
	void startGame(){
			
			timer.start();
			
		}
	
	public void paintComponent(Graphics g){
		
		if(currentState == MENU_STATE){
			drawMenuState(g);
		}else if(currentState == GAME_STATE){
			drawGameState(g);
		}else if(currentState == END_STATE){
			drawEndState(g);
		}


		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("typed");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("pressed");
		if (e.getKeyCode()==KeyEvent.VK_ENTER){
			
			currentState++;
			
		}
		
		if(currentState > END_STATE){
			currentState = MENU_STATE;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			rocket.left=true;
		} 
		if(e.getKeyCode()==KeyEvent.VK_UP){
			rocket.up=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			rocket.down=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			rocket.right=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			manager.addObject(new Projectile(rocket.x,rocket.y,10,10));
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("released");
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			rocket.left=false;
		} 
		if(e.getKeyCode()==KeyEvent.VK_UP){
			rocket.up=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			rocket.down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			rocket.right=false;
		}
		
	}
	
	void updateMenuState(){
		
	}
	
	void updateGameState(){
		
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		
		if(rocket.isAlive==false){
			currentState=END_STATE;
			manager.reset();
			rocket = new Rocketship(250,700,50,50);
			manager.addObject(rocket);
		}
		
	}
	
	void updateEndState(){
		
	}
	
	void drawMenuState(Graphics g){
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 25, 200);
		g.setFont(titleFont2);
		g.drawString("Press ENTER to start", 125, 300);
		g.drawString("Press SPACE for instructions", 85, 400);
		
		
	}
	
	void drawGameState(Graphics g){
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
		manager.draw(g);
		
	}
	
	void drawEndState(Graphics g){
		
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("GAME OVER", 100, 200);
		g.setFont(titleFont2);
		g.drawString("You killed "+manager.getScore()+" aliens", 125, 300);
		g.drawString("Press BACKSPACE to Restart", 85, 400);
		
		
	}

	

}
