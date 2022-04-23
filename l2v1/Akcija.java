package banditi;

public abstract class Akcija {

	protected Kompozicija komp;
	
	public Akcija(Kompozicija k){
		komp = k;
	}
	
	abstract public void izvrsi(Bandit b);
	
}
