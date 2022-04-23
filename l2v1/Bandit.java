package banditi;


public class Bandit {
	
	public enum Tim{
		A, B
	};
	
	private Tim pripada;
	private int zlatnici;
	
	public Bandit(Tim pripada) {
		this.pripada = pripada;
		zlatnici = 50;
	}

	public Tim dohvatiTim() {
		return pripada;
	}

	public int dohvatiBrojZlatnika() {
		return zlatnici;
	}
	
	public void promeniBrojZlatnika(int br){
		zlatnici += br;
	}
	
	@Override
	public String toString() {
		return pripada.name() + zlatnici;
	}
	
	//BEZ OVE METODE BANDIT(A, 50) I NEKI DRUGI BANDIT(A, 50) NISU ISTI JER NIJE ISTA REFERENCA
	/*@Override
	public boolean equals(Object obj) {
		if(obj == this)return true;
		if(!(obj instanceof Bandit))return false;
		Bandit tmp = (Bandit) obj;
		return tmp.pripada == pripada && tmp.zlatnici == zlatnici;
	}*/
	
	public static void main(String[] args) {
		Bandit tmp = new Bandit(Bandit.Tim.A);
		tmp.promeniBrojZlatnika(40);
		System.out.println(tmp);
	}
	
}
