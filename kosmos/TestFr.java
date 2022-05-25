package kosmos;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;

public class TestFr extends Frame {
	public TestFr() {
		setVisible(true);
		setBounds(500,200,200,400);
		setBackground(Color.GREEN);
	}
	
	@Override
	public void paint(Graphics g) {
		Kometa k = new Kometa(50, 50, Color.BLACK, 50);
		//
		k.crtaj(g);
	}
	
	public static void main(String[] args) {
		new TestFr();
	}
}
