package enegretskisistem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EnergetskiSistem extends Frame {
	
	private Baterija baterija;
	private Plac plac;
	
	
	public EnergetskiSistem(int r, int k, int bk) {
		setBounds(500, 200, 500, 500);
		setTitle("Energetski sistem");
		baterija = new Baterija(bk);
		plac = new Plac(r, k);
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				plac.zaustavi();
				dispose();
			}
		});
		
		Panel p = new Panel();
		Button dgm = new Button("Dodaj proizvodjaca");
		dgm.addActionListener((ae)->{
			Hidroelektrana  novi = null;
			try {
				novi = new Hidroelektrana(baterija);
				plac.dodajProizvodjaca(novi);
			} catch (NijeUspeloDodavanje e) {
				System.out.println("Greska proizvodjac");
				novi.zaustavi();
			}
		});
		p.add(dgm);
		add(p, BorderLayout.NORTH);
		add(plac, BorderLayout.CENTER);
		
		setVisible(true);
		
	}

	
	public static void main(String[] args) {
		new EnergetskiSistem(5, 5, 10);
	}

}
