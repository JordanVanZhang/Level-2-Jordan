import java.awt.Color;
import java.awt.Graphics;

public class Character 
extends GameObject{
	
	int gravity;
	int jump;
	boolean right, left, up, down;
	Ground ground = new Ground(0,750,2000,300);
	Block b = new Block(0,600,50,50);
	Character(int x, int y, int width, int height){
		super();
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		gravity = 5;
		jump = 300;
	}
	
	void update(){
		super.update();
		if(up==true&&y==700){
			for(int i=1; i<20;i++){
				y=y-15;
			}
		}
		if (y<ground.y-50||y<b.y-50){
			y=y+gravity;
			System.out.println(y);
		}
		
		
	}
	
	void draw(Graphics g){
		g.drawImage(GamePanel.marioImg,x,y,width,height, null);
	}
}
