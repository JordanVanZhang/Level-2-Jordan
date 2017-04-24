import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Character 
extends GameObject{
	
	int gravity = 1;
	int jump;
	boolean right, left, up, down;
	//private Rectangle cBox = new Rectangle();
	boolean canJump = false;
	private int yVelocity = 0;
	private int jumpPower = 20;
	private int yLimit = 700;
	Ground ground = new Ground(0,750,2000,300);
	Block b = new Block(0,600,50,50);
	Character(int x, int y, int width, int height){
		super();
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		//gravity = 5;
		//jump = 300;
		//cBox.setBounds(x,y,width,height);
	}
	
	public void jump(){
		if (canJump){
			yVelocity -=jumpPower;
			canJump = false;
		}
	}
	void update(){
		super.update();
		yVelocity += gravity;
		y += yVelocity;

		if (y >= yLimit + 1) {
			y = yLimit + 1;
			yVelocity = 0;
			canJump = true;
		}
		
		
		
	}
	
	void draw(Graphics g){
		g.drawImage(GamePanel.marioImg,x,y,width,height, null);
	}
//	public Rectangle getCBox() {
//		return cBox;
//	}

	public void setYLimit(int l) {
		yLimit = l;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getYVelocity() {
		return yVelocity;
	}
	public int getYLimit(){
		return yLimit;
	}
}

