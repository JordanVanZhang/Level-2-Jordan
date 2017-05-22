import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Character 
extends GameObject{
	
	int gravity = 1;
	int jump;
	boolean right, left, up, down;
	//private Rectangle cBox = new Rectangle();
	boolean canJump = false;
	boolean fire = false;
	boolean giant = false;
	private int yVelocity = 0;
	private int jumpPower = 20;
	private int yLimit = 700;

	Rectangle feetBox;
	Rectangle fireBox;
	Character(int x, int y, int width, int height){
		super();
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		feetBox = new Rectangle(x, y+50, width, 1);
		fireBox = new Rectangle(x+50, y, width, height);
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
		
		if(giant==true){
			width = width+50;
			height = height+50;
			y=y-50;
			feetBox.setBounds(x, y+50, width+50, 1);
		}
		else{
			feetBox.setBounds(x, y+50, width, 1);	
		}
		
		if(fire==true){
			if(right==true){
				fireBox.setBounds(x+50, y, width, height);
			}
			if(left==true){
				fireBox.setBounds(x-50, y, width, height);
				}
		}
	}
	
	void draw(Graphics g){
		if (giant==false){
			g.drawImage(GamePanel.marioImg,x,y,width,height, null);
		}
		if (giant==true){
			g.drawImage(GamePanel.marioImg, x, y-50, width+50, height+50, null);
		}
		if(fire==true){
			if(right==true){
				g.drawImage(GamePanel.fireImg,x+50,y,width,height, null);
			}
			if(left==true){
				g.drawImage(GamePanel.fireImg,x-50,y,width,height, null);
			}
		}
	}


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

