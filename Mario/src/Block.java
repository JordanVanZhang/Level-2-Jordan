import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block 
extends GameObject{
	boolean right,left;
	int speed = 5;
	private Rectangle cBox = new Rectangle();
	Block(int x, int y, int width, int height){
		super();
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		cBox.setBounds(x, y, width, height);
	}
	void update(){
		cBox.setBounds(x, y, width, height);
		super.update();
		if(right==true){
			x=x-speed;
		}
		if(left==true){
			x=x+speed;
		}
		
		
	}
	
	void draw(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, width, height);
	}
	public Rectangle getCBox() {
		return cBox;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
