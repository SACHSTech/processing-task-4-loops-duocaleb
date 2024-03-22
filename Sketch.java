import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  int screenWidth = 800;
  int screenHeight = 800;
  int colour;
  int petals = 8;
  int colourLoops = 0;
  int passes = 0;

  public void settings() {
	// put your size call here
    size(screenWidth, screenHeight);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  
	// sample code, delete this stuff

    //grid y
    stroke(0,0,0);
    for (int x = 0; x < screenWidth/2; x += screenWidth/20){
      line(x,0,x,screenHeight/2);
    }
    //grid x
    for (int y = 0; y < screenHeight/2; y += screenHeight/20){
      line(0,y,screenWidth/2,y);
    }

    //balls
    fill(100,23,90);
    for (int x = screenWidth; x > screenWidth/2; x -= screenWidth/10){
      for (int y = 0; y < screenHeight/2; y += screenHeight/10){
        arc(x - screenWidth/20, y + screenHeight/20, screenWidth/20, screenHeight/20, 0, (int)Math.toRadians(1000));
      }
    }

    //gradient
    for (int x = 0; x < screenWidth/2; x += 1){
      colour = x*255/(screenWidth/2);
      stroke(colour, colour, colour);
      line(x,screenHeight,x,screenHeight/2);
    }

    //Flower

    //Making sure that the petals look normal when there are more of them
    if (petals >= 30){
      strokeWeight(0);
    }
    else{
      strokeWeight(1);
    }

    //Main drawing loop
    for (int x = 0; x < 360; x += 360/petals){
      pushMatrix();

      //making a smooth gradient of colours
      if (x*petals/360 < petals/2){
        fill(0,255-(17/12*x),x*17/12);
      }
      else{
        fill(0 , 255-(17/12*(360-x)) , (360-x)*17/12);
      }

      //Setting the position
      translate(3*screenWidth/4, 3*screenHeight/4);

      //Rotating
      rotate(radians(x+360*colourLoops/petals));

      //Drawing petals
      ellipse(0, screenWidth/80*3, 2*screenWidth/5/petals, screenHeight/10);
      popMatrix();
    }

    //Changing the petal start location for a wheel effect
    passes += 1;
    if (colourLoops < petals && passes%3 == 0){
      colourLoops += 1;
    }
    else if (colourLoops == petals && passes%3 == 0){
      colourLoops = 0;
    }

    //Drawing the center
    stroke(0,0,0);
    fill(0,0,0);
    ellipse(3*screenWidth/4, 3*screenHeight/4, 7*screenWidth/80, 7*screenHeight/80);
    
    
  }
  
  // define other methods down here.
}