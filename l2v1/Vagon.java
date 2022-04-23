package banditi;

import java.util.LinkedList;

public class Vagon {
	
	private LinkedList<Bandit> banditi;
	
	public Vagon(){
		banditi = new LinkedList<Bandit>();
	}
	
	public void dodajBandita(Bandit b){
		banditi.add(b);
	}
	
	public boolean sadrziBandita(Bandit b){
		return banditi.contains(b);
	}
	
	public void ukloniBandita(Bandit b){
		if(!sadrziBandita(b))return;
		banditi.remove(b); //uklanja sao prvu pojavu objekta, da li moze da bude vise istih?
	}
	
	public int dohvatiBrojBandita(){
		return banditi.size();
	}
	
	public Bandit dohvatiBandita(int i){
		return banditi.get(i);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		for(int i = 0; i < banditi.size(); i++){
			sb.append(banditi.get(i));
			if(i < banditi.size() - 1)sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Vagon v = new Vagon();
		v.dodajBandita(new Bandit(Bandit.Tim.A));
		v.dodajBandita(new Bandit(Bandit.Tim.B));
		Bandit tmp = new Bandit(Bandit.Tim.A);
		//tmp.promeniBrojZlatnika(30);
		v.dodajBandita(tmp);
		v.ukloniBandita(tmp);
		System.out.println(v);
	}
}
