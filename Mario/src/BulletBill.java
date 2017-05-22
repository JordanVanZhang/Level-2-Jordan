import java.awt.Graphics;

public class BulletBill 
extends GameObject{
	boolean right, left, up, down;
	int speed = 5;
	
	BulletBill(int x, int y, int width, int height){
		super();
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	void update(){
		super.update();
		x=x-10;
		if(right==true){
			x=x-speed;
		}
		if(left==true){
			x=x+speed;
		}
	}
	
	void draw(Graphics g){
		g.drawImage(GamePanel.bulletImg,x,y,width,height,null);
	}

}
