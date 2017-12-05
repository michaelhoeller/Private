package gui.einstieg.aufgabe;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Schneemann extends JFrame {

	public Schneemann() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 500);
		setLocationRelativeTo(null);
		setTitle("Schneemann");
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.RED);
		g.drawString("Hallo Welt", 20, 70);

	}

	public static void main(String[] args) {
		new Schneemann();

	}

}
