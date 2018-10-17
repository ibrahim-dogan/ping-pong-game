import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel implements ActionListener, KeyListener {
	Timer timer = new Timer(10, this);
	Ball b;
	Racket r1, r2;
	int counter = 0;
	boolean setCpuMode;

	public Main() {
		// TODO Auto-generated constructor stub
		b = new Ball();
		r1 = new Racket(1);
		r2 = new Racket(2);
		timer.start();
	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		Main game = new Main();
		jf.setSize(720, 550);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.add(game);
		jf.addKeyListener(game);
		jf.setTitle("Ping Pong Game");
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawRect(35, 0, 634, 450);// black table lines
		b.paint(g);
		r1.paint(g);
		r2.paint(g);
		g.setColor(Color.black);
		g.drawString("[Player 1: W/S] [Player 2: Up/Down] [vs CPU Mode: C]", 200, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		b.move();
		isCollided();
		whoWon();
		repaint();
		if (setCpuMode) {
			r1.cpuMode(b);
		}
	}

	private void whoWon() {
		// TODO Auto-generated method stub
		if (b.getX() < 30) {
			b = new Ball();
			r2.score++;
		}
		if (b.getX() > 675) {
			b = new Ball();
			r1.score++;
		}

	}

	private void isCollided() {
		// TODO Auto-generated method stub if ((r1.y > b.getY())&&(r1.y+80 < b.getY()))

		if (b.getX() < 45 && (r1.y < b.getY()) && (r1.y + 80 > b.getY())) {

			b.yVel = b.yVel;
			b.xVel = -b.xVel;
		}
		if (b.getX() > 660) {

			if ((r2.y < b.getY()) && (r2.y + 80 > b.getY())) {
				b.yVel = b.yVel;
				b.xVel = -b.xVel;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_W) {
			r1.setAccel(-1);
		}

		if (e.getKeyCode() == KeyEvent.VK_S) {
			r1.setAccel(1);
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			r2.setAccel(-1);
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			r2.setAccel(1);
		}

		if (e.getKeyCode() == KeyEvent.VK_C) {
			setCpuMode = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}