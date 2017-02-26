int i =0;
int x =400;
int y =400;
Car car1 = new Car(200, 300, 40, -2);
Car car2 = new Car(125, 50, 60, 1);
Car car3 = new Car(375, 175, 20, 5);

void setup(){
  size(400,400);
}
void draw(){
  background(0,0,0);
  ellipse(x,y,20,20);
  boundry();
  car1.display();
  car2.display();
  car3.display();

  car1.carMove();
  car2.carMove();
  car3.carMove();
  
  
  if(car1.intersects(car1)==true){
    x=400;
    y=400;
  }
  if(car2.intersects(car2)==true){
    x=400;
    y=400;
  }
  if(car3.intersects(car3)==true){
    x=400;
    y=400;
  }

  if (y==0){
   text("You Win", 100, 200);
   textSize(50);
  }
}
void keyPressed()
{
  if(key == CODED){
      if(keyCode == UP)
      {
        y=y-10;
      }
      else if(keyCode == DOWN)
      {
        y=y+10;
      }
      else if(keyCode == RIGHT)
      {
       x=x+10;
      }
      else if(keyCode == LEFT)
      {
        x=x-10;
      }
   }
}

void boundry(){
  if(x>400){
    x=400;
  }
  if(x<0){
    x=0;
  }
  if(y>400){
    y=400;
  }
  if(y<0){
    y=0;
  }
}

class Car{
  int xCar;
  int yCar;
  int sizeCar;
  int speedCar;
  
  Car(int xCar, int yCar, int sizeCar, int speedCar){
    this.xCar=xCar;
    this.yCar=yCar;
    this.sizeCar=sizeCar;
    this.speedCar=speedCar;
    
  }
      void display() 
  {
    fill(0,255,0);
    rect(xCar, yCar,  sizeCar, 50);
  }
  void carMove(){

    xCar=xCar+speedCar;
 
  
  
    if (xCar>400&&speedCar>0){
      xCar=0;
    }
    
    if (xCar<0&&speedCar<0){
      xCar=400;
    }
  }
  
  int getX(){
    return xCar;
  }
  
  int getY(){
    return yCar;
  }
  
  int getSize(){
    return sizeCar;
  }
  boolean intersects(Car car) {
if ((y > car.getY() && y < car.getY()+50) && (x > car.getX() && x < car.getX()+car.getSize()))
          return true;
    else 
        return false;
}
}