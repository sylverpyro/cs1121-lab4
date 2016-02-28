// replace this with your name
// Section 10
// Lab 4

import java.awt.*;

public class lab4 extends Animator {

	private black_dot run = new black_dot();
	private red_dot chase1 = new red_dot(-15,-15,run);
	private red_dot chase2 = new red_dot(575,320,run);

	public void startup() {
	    run.getreddotRef(chase1, chase2);
	}
	
    public void draw(int x, int y, Graphics g) {

	run.draw(x,y,g);
	chase1.draw(g);
	chase2.draw(g);
	
        } // end of draw method

    } // end of lab4 class

class red_dot { 

    private final int diam = 30;
    private int xPos;
    private int yPos;
    private black_dot r1;
    private int rX;
    private int rY;
     
    public red_dot(int xPosition, int yPosition, black_dot run) {
	

	xPos = xPosition;
	yPos = yPosition;
	r1 = run;
	
	} // end constructor

    public void draw(Graphics g) {
	
	rX = r1.getX() - 25 - diam/2;
	rY = r1.getY() - 50 - diam/2;
	
	if (rX > xPos) {
	    xPos ++;
	    }
	if (rY > yPos) {
	    yPos ++;
	    }
	if (rX < xPos) {
	    xPos --;
	    }
	if (rY < yPos) {
	    yPos --;
	    }
	
	g.setColor(Color.red);
	g.fillOval(xPos,yPos,diam,diam);

	} // end draw method

    public int getX() {
	return xPos;
	}
    
    public int getY() {
	return yPos;
	}

}// end red_dot class

class black_dot {

    private int diam = 50;
    private int xPos;
    private int yPos;
    private red_dot c1;
    private red_dot c2;
    private double dist1;
    private double dist2;

    public void getreddotRef( red_dot chase1, red_dot chase2) {
	    c1 = chase1;
	    c2 = chase2;
	}
	
    public void draw(int x, int y,Graphics g) {
	
	int c1X = c1.getX() + 15;
	int c1Y = c1.getY() + 15;
	int c2X = c2.getX() + 15;
	int c2Y = c2.getY() + 15;
	    
	g.setColor(Color.black);
	xPos = x;
	yPos = y;
	g.fillOval(xPos -25 , yPos - 50, diam , diam);

	dist1 = Math.sqrt (Math.pow(xPos-25-c1X,2)+Math.pow(yPos-25-c1Y,2));
	dist2 = Math.sqrt (Math.pow(xPos-25-c2X,2)+Math.pow(yPos-25-c2Y,2));

	if ((dist1 < 100 || dist2 < 100) && diam > 3) {
	    diam--;
	    }

	

    } // end draw method

    public int getX() {
	return xPos;
    }

    public int getY() {
	return yPos;
	}
	

} // end black_dotclass
