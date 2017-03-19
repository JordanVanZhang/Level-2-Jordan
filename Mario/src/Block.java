import java.awt.Color;
import java.awt.Graphics;

public class Block 
extends GameObject{
	boolean right,left;
	int speed = 5;
	Block(int x, int y, int width, int height){
		super();
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
	}
	void update(){
		super.update();
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

}
