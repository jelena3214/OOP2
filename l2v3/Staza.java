package skijanje;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Staza {
	private ArrayList<Deonica> deonice;
	private String naziv;
	
	public Staza(String naziv) {
		deonice = new ArrayList<Deonica>();
		this.naziv = naziv;
	}
	
	public void dodaj(Deonica d){
		deonice.add(d);
	}
	
	public int broj(){
		return deonice.size();
	}
	
	public double duzina(){
		double sum = 0;
		for(Deonica d : deonice){
			sum += d.duzina();
		}
		return sum;
	}
	
	public double nagib(){
		if(deonice.size() == 0)return 0; //nema deonica
		double max = Double.MIN_VALUE;
		for(Deonica d: deonice){
			if(d.nagib() > max) max = d.nagib();
		}
		return max;
	}
	
	public char oznaka() throws GOznaka{
		if(deonice.size() == 0) throw new GOznaka("Nema oznaka");
		LinkedHashMap<Character, Integer> brojacOznaka = new LinkedHashMap<Character, Integer>();
		
		for(Deonica d: deonice){
			char tmp = d.oznaka();
			if(brojacOznaka.containsKey(tmp)){
				brojacOznaka.put(tmp, brojacOznaka.get(tmp) + 1);
			}else{
				brojacOznaka.put(tmp, 1);
			}
		}
		
		int max = Integer.MIN_VALUE;
		char rez = '\0';
		
		for(Map.Entry<Character, Integer> entry: brojacOznaka.entrySet()){
			if(entry.getValue() > max) {
				max = entry.getValue();
				rez = entry.getKey();
			}
		}

		return rez;
	}
	
	public double brzina(double pocetna){
		double vp = pocetna;
		double vk = deonice.get(0).brzina(vp);
		for(int i = 1; i < deonice.size(); i++){
			vp = vk;
			vk = deonice.get(i).brzina(vp);
		}
		return vk;
	}
	
	public double vreme(double pocetna){
		
		double vp = pocetna;
		double vk = deonice.get(0).brzina(vp);
		double sum = deonice.get(0).vreme(vp);
		
		for(int i = 1; i < deonice.size(); i++){
			vp = vk;
			vk = deonice.get(i).brzina(vp);
			sum += deonice.get(i).vreme(vp);
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv).append("|").append(broj()).append("|").append(duzina()).append("|").append(nagib());
		
		sb.append("\n").append("[");
		
		for(int i = 0; i < deonice.size(); i++){
			sb.append(deonice.get(i));
			if(i < deonice.size() - 1)sb.append(",");
		}
		
		sb.append("]");
		return sb.toString();
	}
}
