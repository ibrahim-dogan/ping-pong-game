import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class Racket {

	int x;
	int y;
	int w = 20;
	int h = 80;
	int player;
	int score=0;
	Random rand = new Random(); 
	public Racket(int player) {
		// TODO Auto-generated constructor stub
		this.player = player;
		if (player == 1) {
			x = 15;
		} else {
			x = 670;
		}
		y = 250;
	}
	
	
	public void paint(Graphics g) {
		g.setColor(Color.pink);
		g.fillRect(x, y, w, h);
		g.setColor(Color.white);
		g.setFont(new Font("default", Font.PLAIN, 20));
		g.drawString(score+"", x+5, y+45);
	}

	public void setAccel(int direction) {
		// TODO Auto-generated method stub
		if (y+(direction*10) > 375) {//limit for down bound
			y=371;
			
		}
		else if (y+(direction*10) < 10) {//limit for up bound
			y=0;
			
		}
		else {
			y+=(direction*10);
		}

	}
	public void cpuMode(Ball b) {
		// TODO Auto-generated method stub
		y=b.getY()-40;
	}
	

}