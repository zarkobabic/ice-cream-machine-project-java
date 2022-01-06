package domaci1;

import java.awt.Color;

public class Ukus {
	private String naziv;
	private Color boja;
	
	
	
	
	
	
	
	public Ukus(String naziv, Color boja) {
		this.naziv = naziv;
		this.boja = boja;
	}

	
	public String retNaziv() {
		return naziv;
	}

	
	public Color retBoja() {
		return boja;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ukus other = (Ukus) obj;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "[" + naziv + "]";
	}
}
