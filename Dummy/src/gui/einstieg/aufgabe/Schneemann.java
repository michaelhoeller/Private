package gui.einstieg.aufgabe;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class Schneemann extends JFrame {
    
    static Color col = new Color(100);
    
    static int   y   = 0;
    
    public Schneemann() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setTitle("Hallo Schneedude");
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(getCol());
        g.fillOval(100, 300 + y, 200, 200);
        g.fillArc(150, 225 + y, 100, 100, 0, 360);
        g.fillArc(175, 175 + y, 50, 50, 0, 360);
        g.setColor(new Color(255, 255, 255));
        g.fillArc(205, 185 + y, 10, 10, 0, 360);
        g.fillArc(185, 185 + y, 10, 10, 0, 360);
        g.fillArc(197, 300 + y, 5, 5, 0, 360);
        g.fillArc(197, 250 + y, 5, 5, 0, 360);
        g.fillArc(197, 275 + y, 5, 5, 0, 360);
        g.fillArc(197, 375 + y, 5, 5, 0, 360);
        g.fillArc(197, 400 + y, 5, 5, 0, 360);
        g.fillArc(197, 425 + y, 5, 5, 0, 360);
        g.setColor(Color.ORANGE);
        g.fillArc(200, 195 + y, 15, 5, 0, 360);
        
    }
    
    public void bounceUp() {
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        Schneemann dude = new Schneemann();
        Random rand = new Random();
        
        int i = 0;
        while (true) {
            dude.repaint();
            
            setCol(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            
            if (i < 100) {
                y--;
                i += 1;
                Thread.sleep(i / 2);
            }
            else if (i >= 100 && i < 200) {
                y++;
                i += 1;
                Thread.sleep(20);
            }
            else if (i >= 200) {
                i = 0;
            }
            Thread.sleep(20);
        }
    }
    
    public static Color getCol() {
        return col;
    }
    
    public static void setCol(Color col) {
        Schneemann.col = col;
    }
    
    @Override
    public int getY() {
        return y;
    }
    
    public static void setY(int y) {
        Schneemann.y = y;
    }
}
