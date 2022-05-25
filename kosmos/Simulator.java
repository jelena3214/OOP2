package kosmos;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame {
	
	private Svemir svemir = new Svemir();
	private Generator generator = new Generator(svemir);
	private Panel komande = new Panel();
	
	public Simulator() {
		setBounds(500, 200, 200, 400);
		setResizable(false);
		setTitle("Simulator");
		popuniProzor();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				svemir.zavrsi();
				generator.zavrsi();
				dispose();
			}
		});
		
		setVisible(true);
	}

	private void popuniProzor() {
		add(svemir, BorderLayout.CENTER);
		Button dgm = new Button("Pokreni!");
		dgm.addActionListener((ae)->{
			svemir.pokreni();
			generator.kreni();
			dgm.setEnabled(false);
		});
		komande.add(dgm, "Center");
		add(komande, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		new Simulator();
	}
}
