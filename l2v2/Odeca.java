package revija;

public class Odeca implements Nosivo {
	
	private String naziv;
	private Velicina velicina;
	
	public Odeca(String naziv, Velicina velicina) {
		super();
		this.naziv = naziv;
		this.velicina = velicina;
	}


	public String dohvNaziv() {
		return naziv;
	}

	public Velicina dohvVelicinu() {
		return velicina;
	}

	@Override
	public boolean odgovara(Model m) {
		return !velicina.manja(m.dohvVelicinu());
	}

	@Override
	public String toString() {
		return "odeća " + naziv + " " + velicina;
	}
	
	public static void main(String[] args) {
		Velicina v = new Velicina(Velicina.Oznaka.L);
		Model m = new Model(v);
		Odeca od = new Odeca("majica", new Velicina(Velicina.Oznaka.M));
		System.out.println(od.odgovara(m));
	}
}
