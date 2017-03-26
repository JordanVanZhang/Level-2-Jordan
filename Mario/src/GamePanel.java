import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel
extends JPanel
implements ActionListener, KeyListener{
	Timer time;
	final int menu = 0;
	final int game = 1;
	final int lose = 2;
	final int win = 3;
	static int currentState = 0;
	Font titleFont;
	Font regFont;
	ObjectManager manager;
	Character mario = new Character(250,600,50,50);
	Ground ground = new Ground(0,750,2000,300);
	Goomba g1 = new Goomba(300,700,50,50);
	Pipe pipe = new Pipe(1000,700,50,50);
	Block b = new Block(0,600,50,50);
	public static BufferedImage marioImg;
	public static BufferedImage goombaImg;
	public static BufferedImage pipeImg;

	GamePanel(){
		time = new Timer(1000/60,this);
		manager = new ObjectManager();
		manager.addObject(mario);
		manager.addObject(ground);
		manager.addObject(g1);
		manager.addObject(pipe);
		manager.addObject(b);
		titleFont = new Font("Arial",Font.PLAIN,48);
		regFont= new Font("Arial",Font.PLAIN, 30);
		try{
			marioImg=ImageIO.read(this.getClass().getResourceAsStream("mario.png"));
			goombaImg=ImageIO.read(this.getClass().getResourceAsStream("goomba.png"));
			pipeImg=ImageIO.read(this.getClass().getResourceAsStream("pipe.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(currentState==menu){
			updateMenu();
		}
		else if(currentState==game){
			updateGame();
		}
		else if(currentState==lose){
			updateLose();
		}
		else if(currentState==win){
			updateWin();
		}
		repaint();
	}
	
	void startGame(){
		time.start();
		
	}
	
	public void paintComponent(Graphics g){
		if(currentState==menu){
			drawMenu(g);
		}
		else if(currentState==game){
			drawGame(g);
		}
		else if(currentState==lose){
			drawLose(g);
		}
		else if(currentState==win){
			drawWin(g);
		}
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER){
			currentState++;
		}
		if(currentState>win){
			currentState=menu;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			mario.jump();
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			g1.right=true;
			pipe.right=true;
			b.right=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			g1.left=true;
			pipe.left=true;
			b.left=true;
		}
		
	}

	public void keyReleased(KeyEvent e) {

		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			g1.right=false;
			pipe.right=false;
			b.right=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			g1.left=false;
			pipe.left=false;
			b.left=false;
		}
		
	}
	
	void updateMenu(){
		
	}
	
	void updateGame(){
		manager.update();
		manager.checkCollision();
		if(Character.isAlive==false){
			currentState=lose;
			manager.reset();
			mario = new Character(250,600,50,50);
		}
	}
	
	void updateLose(){
		
	}
	
	void updateWin(){
		
	}
	
	void drawMenu(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Mario.windowWidth, Mario.windowHeight);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("WELCOME TO MARIO",250,250);
		g.setFont(regFont);
		g.drawString("Press ENTER to begin", 350, 500);

	}
	
	void drawGame(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, Mario.windowWidth, Mario.windowHeight);
		manager.draw(g);
	}
	
	void drawLose(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(0, 0, Mario.windowWidth, Mario.windowHeight);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("You Lost!",400,250);
	}
	
	void drawWin(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, Mario.windowWidth, Mario.windowHeight);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("You Won!",400,250);
		
	}
}
