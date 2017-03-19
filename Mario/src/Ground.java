import java.awt.Color;
import java.awt.Graphics;

public class Ground extends GameObject{
	int speed;
	boolean right, left, up, down;

	Ground(int x, int y, int width, int height){
		super();
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	void update(){
		super.update();
		
		
		
	}
	
	void draw(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, width, height);
	}
}
