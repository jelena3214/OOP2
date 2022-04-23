package skijanje;

public class Teska extends Deonica {
	
	private static final double g = 9.81;
	
	public Teska(double duzina, double nagib) {
		super(duzina, nagib);
	}

	@Override
	public char oznaka() {
		return 'T';
	}

	@Override
	public double ubrzanje() {
		return g * Math.sin(Math.toRadians(nagib));
	}
	
	public static void main(String[] args) {
		Teska t = new Teska(10, 20);
		System.out.println(t.vreme(0));
	}

}
