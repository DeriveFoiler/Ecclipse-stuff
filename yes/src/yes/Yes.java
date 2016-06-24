package yes;

import processing.core.PApplet;


public class Yes extends PApplet {
	PApplet p;
	meh thing;
	public void setup() { 
		thing = new meh(this);
	}
	public void settings() {
		
	}
	public static void main(String _args[]){
		PApplet.main(new String[] { yes.Yes.class.getName() });
	}
	public void draw() {
		println(thing.run());
	}
}
