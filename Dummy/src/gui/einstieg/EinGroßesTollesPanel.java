package gui.einstieg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EinGroßesTollesPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x = 840;
	int y = 525;
	int x2 = 640;
	int y2 = 525;
	int x3 = 200;
	int y3 = 200;
	int color = 1;

	static int sleep;

	private void moveZeBlob(Random rand, JFrame frame) {
		int temp = rand.nextInt(2);
		int temp2 = rand.nextInt(500);
		if (temp == 1) {
			x += rand.nextInt(5);
			x2 += rand.nextInt(5);
			x3 += rand.nextInt(2);

			y += rand.nextInt(5);
			y2 += rand.nextInt(5);
			y3 += rand.nextInt(2);
			// color += rand.nextInt(10000);
			color += 1;
		} else {
			x -= rand.nextInt(5);
			x2 -= rand.nextInt(5);
			x3 -= rand.nextInt(2);

			y -= rand.nextInt(5);
			y2 -= rand.nextInt(5);
			y3 -= rand.nextInt(2);
			// color -= rand.nextInt(10000);
			color += 1;
		}
		if (temp2 < 20) {
			// frame.setVisible(false);
		} else {
			frame.setVisible(true);
		}
		sleep = rand.nextInt(20);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		// g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		// RenderingHints.VALUE_ANTIALIAS_ON);
		// g2d.fillOval(x, y, 30, 30);
		// g2d.fillOval(x2, y2, 30, 30);
		// g2d.fillOval(x3, y3, 30, 30);

		// for (int i = 0; i < 10; i++) {
		// for (int j = 0; j < 10; j++) {
		// g2d.fill3DRect(x + i * 20, (y + 100) + j * 20, i * 20, j * 20, true);
		// }
		// }
		Color col = new Color(color);
		g2d.setColor(col);
		g2d.fill3DRect(x, y, x3, y3, false);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("TollerName");
		Random rand = new Random();
		EinGroßesTollesPanel derBlub = new EinGroßesTollesPanel();

		frame.setSize(1680, 1050);
		JLabel label = new JLabel("DU STINKST");
		label.setLocation(860, 200);

		frame.add(derBlub);
		derBlub.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		while (true) {
			derBlub.moveZeBlob(rand, frame);
			derBlub.repaint();
			Thread.sleep(sleep);
		}
	}

}
