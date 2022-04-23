package revija;

public class Model {
	
	private static int i = 0;
	private int id = i++;
	private Velicina velicina;
	
	public Model(Velicina vel){
		velicina = vel;
	}
	
	public int dohvId(){
		return id;
	}
	
	public Velicina dohvVelicinu(){
		return velicina;
	}
	
	@Override
	public String toString() {
		return "Model " + id  +" (" + velicina + ")";
	}
	
	public static void main(String[] args) {
		Velicina v = new Velicina(Velicina.Oznaka.S);
		Model m = new Model(v);
		System.out.println(m.dohvId());
	}
}
