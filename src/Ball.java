import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	int xVel, yVel; // velocities
	int x, y;

	public Ball() {

		// x = 350, y=250 to start at the center
		x = 350;
		y = 250;
		// starting velocities
		xVel = -3;
		yVel = 3;

	}


	public void paint(Graphics g) {
		g.setColor(Color.black);
		// the reason by subtracting 10 is because when it draws a circle it draws it from the top left corner
		g.fillOval(x - 10, y - 10, 20, 20);

	}

	public void move() {
		x += xVel;
		y += yVel;
		
		if (y < 10)
			yVel = -yVel;
		else if (y > 440)
			yVel = -yVel;
		
	}

	public int getX() {
		return (int) x;
	}

	public int getY() {
		return (int) y;
	}

}