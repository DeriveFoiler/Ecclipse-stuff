package wheeeee;

import processing.core.PApplet;


public class Wheeeee extends PApplet {
	
	//Define my array and initial speed
	float[] stuffy;
	float speed = 200;
	//State slider x and y
	float rectx;
	float recty = 25*3/4 -2;
	public void settings() {
		size(800,400);
	}
	public void setup() {
		smooth();
		//create some filler for the array
		stuffy = new float [width/20];
		for (int i = 0; i<width/20; i++){
			stuffy[i] = height/2;
		}
		//Call rectx after width is defined
		rectx = (430+width-30)/2;
	}
	//Acceleration for wave element
	float a;
	public void draw () {
		background(0);
		//The white circle
		strokeWeight(5);
		stroke(255);
		ellipse(width/2, height/2, 200,200);
		//The line
		strokeWeight(2);
		stroke(255, 0, 0);
		line(0, height/2+100*sin(millis()/speed), width,height/2+ 100*sin(millis()/speed) );
		//The point
		strokeWeight(15);
		point( width/2+100*cos(millis()/speed), height/2+100*sin(millis()/speed) );
		//THE WAVE
		noStroke();
		//Assign the first element
		stuffy[0] =height/2+ 100*sin(millis() / speed);
		//Draw in the wave
		for (int i = 0; i<width/20; i++){
			if (i==0){
				fill(255, 0, 0);
			} else {
				fill(0, 255-255*20*i/width, 255-255*20*i/width);
			}
			ellipse(20*i + 10, stuffy[i], 20,20);
		}
		//Move everything over on the array
		for (int i = stuffy.length-1;i>0; i--){
			//Remember to dampen with a!
			a = (stuffy[i-1] - stuffy[i])/5;
			stuffy[i] += a;
		}
		//Text at top left
		textSize(25);
		fill(255);
		text("SPEED: ~" + (1.0/(2*PI*speed/1000)) + " waves/second", 3, 24); 
		//The line for the slider
		strokeWeight(3);
		stroke(255);
		line(450, 25*3/4 - 2, width-30, 25*3/4 - 2); 
		//The slider
		noStroke();
		fill(255, 0, 0);
		rectMode(CENTER);
		rect(rectx, recty, 20, 20);
		//Test if within range
		if (mousePressed && mouseX>rectx-20 && mouseX<rectx+20 && mouseY>recty-20 && mouseY<recty+20 && mouseX>450 && mouseX<width-30){
			rectx = mouseX;
			//Map from distance the slider moved to speed
			speed = 200 + 200*((420+width)/2 - rectx)/(width - 30 - (420+width)/2);
		}
		noFill();
	}
}
