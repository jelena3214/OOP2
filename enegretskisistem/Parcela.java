package enegretskisistem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

abstract public class Parcela extends Label{
	
	protected Color boja;
	
	public Parcela(char oznaka, Color poz){
		setText(Character.toString(oznaka));
		setAlignment(Label.CENTER);
		boja = poz;
		setBackground(boja);
		setFont(new Font("Serif", Font.BOLD, 14));
		setForeground(Color.white);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getParent().dispatchEvent(e);
			}
		});
	}
	
	protected void postaviOznaku(char oz) {setText(Character.toString(oz));}
	
	protected void postaviBojuTeksta(Color c) {setForeground(c);}
	
	public void promeniPozadinu(Color c) {
		boja = c;
	}
}
