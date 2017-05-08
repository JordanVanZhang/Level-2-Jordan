import java.awt.Graphics;
import java.awt.Rectangle;


public class GameObject {
	int x;
	public int y;
	int width;
	int height;
	Rectangle collisionBox;
	public static boolean isAlive = true;
	
	GameObject(){
		collisionBox = new Rectangle(x,y,width,height);
	}
	
	void update(){
		collisionBox.setBounds(x,y,width,height);
	}
	
	void draw(Graphics g){
		
	}
	Rectangle getCBox(){

		return collisionBox;
	}
	
}
