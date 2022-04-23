package revija;

public class Velicina {
	
	private Oznaka oznaka;
	
	public enum Oznaka{
		S(0), M(1), L(2);
		private int vred;
		private Oznaka(int vr){
			vred = vr;
		}
		public int vrednost(){
			return vred;
		}
	}
	
	public Velicina(Oznaka oz){
		oznaka = oz;
	}

	public Oznaka dohvOznaku() {
		return oznaka;
	}
	
	public boolean manja(Velicina v){
		return oznaka.vrednost() < v.oznaka.vrednost();
	}
	
	@Override
	public String toString() {
		return oznaka.name();
	}
	
	public static void main(String[] args) {
		Velicina v = new Velicina(Velicina.Oznaka.S);
		Velicina v1 = new Velicina(Velicina.Oznaka.M);
		System.out.println(v1);
	}
}
