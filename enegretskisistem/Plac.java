package enegretskisistem;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Plac extends Panel {
	
	private Parcela izabrana;
	private ArrayList<Proizvodjac> proizvodjaci = new ArrayList<Proizvodjac>();
	private ArrayList<Parcela> parcele = new ArrayList<>();
	private int red, kolona;
	
	public Plac(int r, int k) {
		red = r;
		kolona = k;
		GridLayout gr =  new GridLayout(r, k);
		gr.setHgap(5);
		gr.setVgap(5);
		setLayout(gr);
		
		for(int i = 0; i < r*k; i++) {
			if(Math.random() > 0.7) {
				parcele.add(new TravnataPovrs());
			}else {
				parcele.add(new VodenaPovrs());
			}
			add(parcele.get(i));
		}
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(izabrana == null)izabrana = (Parcela) e.getSource();
				else {
					izabrana.setFont(new Font("Serif", Font.BOLD, 14));
					izabrana = (Parcela) e.getSource();
				}
				
				izabrana.setFont(new Font("Serif", Font.BOLD, 20));
			}
		});
	}
	
	public synchronized void dodajProizvodjaca(Proizvodjac p) throws NijeUspeloDodavanje {
		if(izabrana == null) throw new NijeUspeloDodavanje();
		Parcela stara = izabrana;
		int index = parcele.indexOf(stara);
		add(p, index); // dodajemo labelu Proizvodjaca
		remove(index+1); //uklanjamo staru povrsinu koja je bila tu
		proizvodjaci.add(p);
		parcele.remove(index);
		parcele.add(index, p);
		revalidate(); //mora posle add i remove
		//stara.setFont(new Font("Serif", Font.BOLD, 14)); ne treba jer se stara brise
		if(p instanceof Hidroelektrana) {
			int br = 0;
			if((index+1) % red != 0 && parcele.get(index + 1) instanceof VodenaPovrs)br++;
			if(index % red != 0 && index != 0 && parcele.get(index - 1) instanceof VodenaPovrs)br++;
			if(index > (kolona -1) && parcele.get(index - kolona) instanceof VodenaPovrs)br++;
			if(index < (red*kolona - 1 - kolona) && parcele.get(index + kolona) instanceof VodenaPovrs)br++;
			((Hidroelektrana) p).postaviBrojVodenihPovrsi(br);
			
		}
	}

	
	public void zaustavi() {
		for(Proizvodjac p: proizvodjaci) {
			p.zaustavi();
		}
	}

}
