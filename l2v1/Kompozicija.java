package banditi;

import java.util.LinkedList;

public class Kompozicija {
	private LinkedList<Vagon> vagoni;
	
	public Kompozicija(){
		vagoni = new LinkedList<Vagon>();
	}
	
	public void dodajVagon(Vagon v){
		vagoni.addLast(v);
	}
	
	public Vagon dohvatiVagon(Bandit b) throws GNepostojeciVagon{
		for(Vagon v: vagoni){
			if(v.sadrziBandita(b))return v;
		}
		throw new GNepostojeciVagon("Nepostojeci vagon");
	}
	
	public Vagon dohvatiSusedniVagon(Vagon v, Smer s) throws GNepostojeciVagon{
		
		int ind = vagoni.indexOf(v);
		if(ind == -1)throw new GNepostojeciVagon("Nepostojeci vagon"); //onaj koji zadajemo ne postoji
		
		if(s == Smer.ISPRED)ind--;
		else ind++;
		
		try{
			Vagon tmp = vagoni.get(ind);
			return tmp;
		}catch(IndexOutOfBoundsException e){
			throw new GNepostojeciVagon("Nepostojeci vagon");
		}
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < vagoni.size(); i++){
			sb.append(vagoni.get(i));
			if(i < vagoni.size() - 1)sb.append("_");
		}
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		Vagon v = new Vagon();
		v.dodajBandita(new Bandit(Bandit.Tim.A));
		v.dodajBandita(new Bandit(Bandit.Tim.A));
		
		Vagon v1 = new Vagon();
		Bandit tmp = new Bandit(Bandit.Tim.A);
		tmp.promeniBrojZlatnika(2);
		v1.dodajBandita(new Bandit(Bandit.Tim.B));
		v1.dodajBandita(new Bandit(Bandit.Tim.B));
		v1.dodajBandita(tmp);
		
		Kompozicija k = new Kompozicija();
		k.dodajVagon(v);
		k.dodajVagon(v1);
		try {
			System.out.println(k.dohvatiSusedniVagon(v1, Smer.ISPRED));
		} catch (GNepostojeciVagon e) {
			e.printStackTrace();
		}
		System.out.println(k);
	}

}
