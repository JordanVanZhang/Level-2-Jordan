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
	Character mario = new Character(250,600,50,50);
	Ground ground = new Ground(0,750,2000,300);
	Goomba g1 = new Goomba(500,700,50,50);
	Goomba g2 = new Goomba(700,700,50,50);
	Goomba g3 = new Goomba(1500,700,50,50);
	Goomba g4 = new Goomba(3700,700,50,50);
	Goomba g5 = new Goomba(5500,700,50,50);
	Goomba g6 = new Goomba(2700,700,50,50);
	Pipe pipe = new Pipe(5000,700,50,50);
	Block b = new Block(500,650,50,50);
	Block b1 = new Block(1700,350,550,50);
	Block b2 = new Block(3900,400,550,50);
	Block b3 = new Block(3700,500,200,50);
	Block b4 = new Block(3500,600,200,50);
	Block b5 = new Block(1500,500,550,50);
	Block b6 = new Block(1300,600,550,50);
	Block b7 = new Block(900,350,550,50);
	BulletBill B = new BulletBill(1000,600,100,100);
	BulletBill B1 = new BulletBill(5000,600,100,100);
	BulletBill B2 = new BulletBill(10000,600,100,100);
	
	
	public static BufferedImage marioImg;
	public static BufferedImage goombaImg;
	public static BufferedImage pipeImg;
	public static BufferedImage bulletImg;

	GamePanel(){
		time = new Timer(1000/60,this);
		titleFont = new Font("Arial",Font.PLAIN,48);
		regFont= new Font("Arial",Font.PLAIN, 30);
		try{
			marioImg=ImageIO.read(this.getClass().getResourceAsStream("mario.png"));
			goombaImg=ImageIO.read(this.getClass().getResourceAsStream("goomba.png"));
			pipeImg=ImageIO.read(this.getClass().getResourceAsStream("pipe.png"));
			bulletImg=ImageIO.read(this.getClass().getResourceAsStream("Bullet-Bill-icon.png"));
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
			g2.right=true;
			g3.right=true;
			g4.right=true;
			g5.right=true;
			g6.right=true;
			pipe.right=true;
			b.right=true;
			b1.right=true;	
			b2.right=true;
			b3.right=true;
			b4.right=true;
			b5.right=true;
			b6.right=true;
			b7.right=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			g1.left=true;
			g2.left=true;
			g3.left=true;
			g4.left=true;
			g5.left=true;
			g6.left=true;
			pipe.left=true;
			b.left=true;
			b1.left=true;
			b2.left=true;
			b3.left=true;
			b4.left=true;
			b5.left=true;
			b6.left=true;
			b7.left=true;
		}
		
	}

	public void keyReleased(KeyEvent e) {

		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			g1.right=false;
			g2.right=false;
			g3.right=false;
			g4.right=false;
			g5.right=false;
			g6.right=false;
			pipe.right=false;
			b.right=false;
			b1.right=false;	
			b2.right=false;
			b3.right=false;
			b4.right=false;
			b5.right=false;
			b6.right=false;
			b7.right=false;
			
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			g1.left=false;
			g2.left=false;
			g3.left=false;
			g4.left=false;
			g5.left=false;
			g6.left=false;
			pipe.left=false;
			b.left=false;
			b1.left=false;	
			b2.left=false;
			b3.left=false;
			b4.left=false;
			b5.left=false;
			b6.left=false;
			b7.left=false;
			
		}
		
	}
	
	void updateMenu(){
		
	}
	
	void updateGame(){

		mario.update();
		g1.update();
		g2.update();
		g3.update();
		g4.update();
		g5.update();
		g6.update();
		b.update();
		b1.update();
		b2.update();
		b3.update();
		b4.update();
		b5.update();
		b6.update();
		b7.update();
		B.update();
		B1.update();
		B2.update();
		pipe.update();

		if(Character.isAlive==false){
			currentState=lose;
			mario = new Character(250,600,50,50);
		}
		if(mario.collisionBox.intersects(pipe.getCBox())){
			GamePanel.currentState=3;
		}
		if(mario.collisionBox.intersects(g1.getCBox())){
			GamePanel.currentState=2;
		}
		if(mario.collisionBox.intersects(g2.getCBox())){
			GamePanel.currentState=2;
		}
		if(mario.collisionBox.intersects(g3.getCBox())){
			GamePanel.currentState=2;
		}
		if(mario.collisionBox.intersects(g4.getCBox())){
			GamePanel.currentState=2;
		}
		if(mario.collisionBox.intersects(g5.getCBox())){
			GamePanel.currentState=2;
		}
		if(mario.collisionBox.intersects(g6.getCBox())){
			GamePanel.currentState=2;
		}
		if(mario.collisionBox.intersects(B.getCBox())){
			GamePanel.currentState=2;
		}
		if(mario.collisionBox.intersects(B1.getCBox())){
			GamePanel.currentState=2;
		}
		if(mario.collisionBox.intersects(B2.getCBox())){
			GamePanel.currentState=2;
		}
		if(mario.collisionBox.intersects(b.getCBox())){
			handleCollision(b);
		}
		if(mario.collisionBox.intersects(b1.getCBox())){
			handleCollision(b1);
		}
		if(mario.collisionBox.intersects(b2.getCBox())){
			handleCollision(b2);
		}
		if(mario.collisionBox.intersects(b3.getCBox())){
			handleCollision(b3);
		}
		if(mario.collisionBox.intersects(b4.getCBox())){
			handleCollision(b4);
		}
		if(mario.collisionBox.intersects(b5.getCBox())){
			handleCollision(b5);
		}
		if(mario.collisionBox.intersects(b6.getCBox())){
			handleCollision(b6);
		}
		if(mario.collisionBox.intersects(b7.getCBox())){
			handleCollision(b7);
		}
		if(mario.collisionBox.intersects(ground.getCBox())){
			handleCollision(ground);
			}
		else if(!mario.collisionBox.intersects(b.getCBox())
				&&!mario.collisionBox.intersects(b1.getCBox())
				&&!mario.collisionBox.intersects(b2.getCBox())
				&&!mario.collisionBox.intersects(b3.getCBox())
				&&!mario.collisionBox.intersects(b4.getCBox())
				&&!mario.collisionBox.intersects(b5.getCBox())
				&&!mario.collisionBox.intersects(b6.getCBox())
				&&!mario.collisionBox.intersects(b7.getCBox())	
				){
			mario.setYLimit(700);
		}
		
		
				
	}
	


	void handleCollision(Ground g) {
	if (mario.getYVelocity() >= 0 && mario.getY() + mario.getHeight() < g.getY() + 25) {
		mario.setYLimit(g.getY() - mario.getHeight());
		}
	}
	void handleCollision(Block b) {
		
		System.out.println("block height:"+b.getY());
	if (mario.getYVelocity() >= 0 && mario.getY() + mario.getHeight() < (b.getY()+100)) {
		mario.setYLimit(b.getY() - mario.getHeight());
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
		mario.draw(g);
		g1.draw(g);
		g2.draw(g);
		g3.draw(g);
		g4.draw(g);
		g5.draw(g);
		g6.draw(g);
		ground.draw(g);
		b.draw(g);
		b1.draw(g);
		b2.draw(g);
		b3.draw(g);
		b4.draw(g);
		b5.draw(g);
		b6.draw(g);
		b7.draw(g);
		pipe.draw(g);
		B.draw(g);
		B1.draw(g);
		B2.draw(g);

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
