package domaci1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Aparat extends Panel{
	private Mesto mesto = new Mesto(this);
	private Panel dostupniUkusi = new Panel(new GridLayout(2,0,0,0));
	private ArrayList<Ukus> dugmici = new ArrayList<>();
	private Button dugmeProdaj = new Button("Prodaj");
	private Label labelaSladoleda = new Label();
	
	
	
	
	
	
	
	
	public Aparat() {
		this.setLayout(new BorderLayout(0,0));
		populatePanel();
	}
	

	
	private void populatePanel() {
		dugmeProdaj.setEnabled(false);
																										//LISTENER ZA PRODAJ DUGME
		
		dugmeProdaj.addActionListener(e->{
			mesto.zavrsiTocenje();
			System.out.println(mesto.getSladoled());
			dugmeProdaj.setEnabled(false);
		});
		
		
		populateDesni();
		populateDostupniUkusi();
		populateSladoledLabela();	
	}
	
	
	
	private void populateDesni() {
		Panel desni = new Panel(new GridLayout(0,1,0,0));
		desni.add(dugmeProdaj);
		desni.add(mesto);
		add(desni, BorderLayout.EAST);
	}
	
	
	
	private void populateDostupniUkusi() {
		dostupniUkusi.setBackground(new Color(224,224,224));
		add(dostupniUkusi, BorderLayout.CENTER);
	}
	
	
	
	private void populateSladoledLabela() {
		Panel sladoledSekcija = new Panel(new FlowLayout(FlowLayout.LEFT, 15, 5));
		sladoledSekcija.setBackground(new Color(199,199,199));
		Label labelaLevo = new Label("Sladoled:");
		labelaLevo.setFont(new Font("Lucida",Font.BOLD, 24));
		sladoledSekcija.add(labelaLevo);
		sladoledSekcija.add(labelaSladoleda);
		add(sladoledSekcija, BorderLayout.SOUTH);
	}
	
	
	
	public void postaviTekstLabeli(String s) {
		labelaSladoleda.setText(s);
		labelaSladoleda.revalidate();
	}

	
	
	public Mesto getMesto() {
		return mesto;
	}

	
	
	
	public void dodajDugmeZaUkus(Ukus ukuss) throws GDugmeZaUkusVecPostoji{
		
		Button b = new Button(ukuss.retNaziv());
		b.setBackground(ukuss.retBoja());
		
		for(Ukus i: dugmici) {
			if(ukuss.equals(i)) throw new GDugmeZaUkusVecPostoji();
		}
		dugmici.add(ukuss);
		switch(dugmici.size()) {
			case 1: dostupniUkusi.setLayout(new GridLayout(1,1,0,0));
			break;
			case 2: dostupniUkusi.setLayout(new GridLayout(2,0,0,0));
			break;
		}
		dostupniUkusi.add(b);
		
		

																										//LISTENER ZA MOUSEPRESSED I MOUSERELEASED
		b.addMouseListener(new MouseAdapter(){		
			
			@Override
			public void mousePressed(MouseEvent e) {
				mesto.postaviTrenutniUkus(ukuss);
					
				if(!mesto.ispitajTocenje()) {
					if(!dugmeProdaj.isEnabled()) {
					//mesto.repaint();
					mesto.pokreniTocenje();
					}
				}
				else {
					mesto.nastaviTocenje();
				}
			}
			
			
				
			@Override
			public void mouseReleased(MouseEvent e) {
				mesto.privremenoZaustavi();
			}
		});
	}
	
	
	
	public void omoguciProdaju() {
		dugmeProdaj.setEnabled(true);
	}
}
