package skijanje;

abstract public class Deonica {
	protected double duzina, nagib;

	public Deonica(double duzina, double nagib) {
		super();
		this.duzina = duzina;
		this.nagib = nagib;
	}

	public double duzina() {
		return duzina;
	}

	public double nagib() {
		return nagib;
	}
	
	abstract public char oznaka();
	
	abstract public double ubrzanje();
	
	public double brzina(double pocetna){
		return Math.sqrt(2*ubrzanje()*duzina + Math.pow(pocetna, 2));
	}
	
	public double vreme(double pocetna){
		return (brzina(pocetna) - pocetna)/ubrzanje();
	}
	
	@Override
	public String toString() {
		return oznaka() + "(" + duzina + "," + nagib + ")";
		
	}
	
}
