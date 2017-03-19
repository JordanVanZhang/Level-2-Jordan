import java.awt.Graphics;

public class Pipe 
extends GameObject{
	boolean right, left, up, down;
	int speed = 5;
	Pipe(int x, int y, int width, int height){
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
	}
	
	void draw(Graphics g){
		g.drawImage(GamePanel.pipeImg,x,y,width,height, null);
	}
}
