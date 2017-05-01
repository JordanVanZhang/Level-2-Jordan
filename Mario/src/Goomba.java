import java.awt.Color;
import java.awt.Graphics;

public class Goomba 
extends GameObject{
	boolean right, left, up, down;
	int speed = 5;
	
	Goomba(int x, int y, int width, int height){
		super();
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	void update(){
		super.update();
		if(right==true){
			x=x-speed;
		}
		if(left==true){
			x=x+speed;
		}
		x=x-1;
	}
	
	void draw(Graphics g){
		g.drawImage(GamePanel.goombaImg,x,y,width,height,null);
	}
}
