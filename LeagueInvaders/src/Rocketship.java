import java.awt.Color;
import java.awt.Graphics;

public class Rocketship 
extends GameObject{
	
	int speed;
	boolean right, left, up, down;
	

	Rocketship(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 5;
	}
	
	void update(){
		
		if(right==true){
			x=x+speed;
		}
		
		if(left==true){
			x=x-speed;
		}
		if(up==true){
			y=y-speed;
		}
		if(down==true){
			y=y+speed;
		}
		
		
		
	}
	
	void draw(Graphics g){
		
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		
	}

}
