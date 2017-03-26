
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;
	Character mario = new Character(250,600,50,50);
	Ground ground = new Ground(0,750,2000,300);
	Block b = new Block(0,600,50,50);
	private int score = 0;
	
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	
	public ObjectManager() {
		objects = new ArrayList<GameObject>();
	}

	public void addObject(GameObject o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}
		
		purgeObjects();	
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

//	public void manageEnemies(){
//		if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
//			addObject(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
//			enemyTimer = System.currentTimeMillis();
//		}
//	}
//
	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				
				if(o1.collisionBox.intersects(o2.collisionBox)){
					if((o1 instanceof Character && o2 instanceof Goomba) ||
					   (o2 instanceof Character && o1 instanceof Goomba)){
						o1.isAlive = false;
						o2.isAlive = false;
					}
				if(o1.collisionBox.intersects(o2.collisionBox)){
					if((o1 instanceof Character && o2 instanceof Pipe) ||
						(o2 instanceof Character && o1 instanceof Pipe)){
						GamePanel.currentState=3;
						}
	
				}
				if(mario.getCBox().intersects(b.getCBox())){
					handleCollision(b);
				}
				if(mario.getCBox().intersects(ground.getCBox())){
					handleCollision(ground);
				}

				else
				// Otherwise, use the setYlimit method to choose your players lowest point.
					mario.setYLimit(1000);
				
			}
			
			}
		}
	}
	void handleCollision(Ground g) {
		if (mario.getYVelocity() >= 0 && mario.getY() + mario.getHeight() < g.getY() + 25) {
			mario.setYLimit(g.getY() - mario.getHeight());
		}
	}
	void handleCollision(Block b) {
		if (mario.getYVelocity() >= 0 && mario.getY() + mario.getHeight() < b.getY() + 25) {
			mario.setYLimit(b.getY() - mario.getHeight());
		}
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int s){
		score = s;
	}
	
	public void reset(){
		objects.clear();
	}
}
