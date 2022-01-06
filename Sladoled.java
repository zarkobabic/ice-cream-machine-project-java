package domaci1;

import java.awt.Color;
import java.util.ArrayList;

public class Sladoled {
	
	int max_velicina;
	int tren_velicina;
	public static class Ukuskol{
		private Ukus u;
		private int kolicina;
		
		public Ukuskol(Ukus u, int kol) {
			this.u = u;
			this.kolicina = kol;
		}
	}
	private ArrayList<Ukuskol> ukusi = new ArrayList<>();
	
	
	
	
	
	
	
	public Sladoled(int max_velicina) {
		this.max_velicina = max_velicina;
	}	
	
	
	
	public void dodajUkus(Ukus u, int kol) {
		Ukuskol pom;
		if(tren_velicina + kol > max_velicina) {
			pom = new Ukuskol(u, max_velicina - tren_velicina);
			tren_velicina = max_velicina;
		}
		else {
			pom = new Ukuskol(u, kol);
			tren_velicina += kol;
		}
		
		int dodat = 0;
		for(Ukuskol i:ukusi) {
			if(i.u.equals(pom.u)) {
				i.kolicina += pom.kolicina;
				dodat = 1;
				break;
			}
		}
		if(dodat == 0) {
			ukusi.add(pom);
		}
	}
		
	
		
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int prvi = 0;
		for(Ukuskol i:ukusi) {
			if(prvi == 0) {
				prvi = 1;
				sb.append(i.kolicina + "ml" + i.u);
			}else {
				sb.append(" " + i.kolicina + "ml" + i.u);
			}
		}
		return sb.toString();
	}
}

