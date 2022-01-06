package domaci1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Sladoleddzinica extends Frame{
	private Aparat aparat = new Aparat();
	
	
	
	
	
	
	
	public Sladoleddzinica() {
		setTitle("Sladoleddzinica");
		setBounds(400, 800, 600, 500);
		setVisible(true);
		setResizable(true);	
		populateWindow();
		pack();
	}
	
	
	
	private void populateWindow() {
		
		add(aparat);
		populatePanelZaDodavanjeUkusa();
		
		
		addWindowListener(new WindowAdapter(){
																											//LISTENER ZA WINDOW CLOSING
			@Override
			public void windowClosing(WindowEvent e) {
				if(aparat.getMesto().ispitajTocenje()) {
					aparat.getMesto().zavrsiTocenje();
				}
				dispose();
			}
		});
	}
	
	
	
	private void populatePanelZaDodavanjeUkusa() {
		Panel panelZaUkuse = new Panel(new FlowLayout(FlowLayout.LEFT, 15, 0));
		Label sladnaz = new Label("Naziv:");
		sladnaz.setFont(new Font("Lucida",Font.BOLD, 24));
		TextField unesenNaziv = new TextField(20);
		Label sladboja = new Label("Boja:");
		sladboja.setFont(new Font("Lucida",Font.BOLD, 24));
		TextField unesenaboja = new TextField(15);
		Button unesenukus = new Button("Dodaj ukus");
		
																											//LISTENER ZA DUGME ZA UNOS UKUSA
		unesenukus.addActionListener(e->{
			Ukus novi = new Ukus(unesenNaziv.getText(), Color.decode("0x" + unesenaboja.getText()));
			
			try {
				aparat.dodajDugmeZaUkus(novi);
			} catch (GDugmeZaUkusVecPostoji e1) {/*radi se nesto sa izuzetkom*/}
			
			revalidate();
		});
		
		
		panelZaUkuse.add(sladnaz);
		panelZaUkuse.add(unesenNaziv);
		panelZaUkuse.add(sladboja);
		panelZaUkuse.add(unesenaboja);
		panelZaUkuse.add(unesenukus);
		panelZaUkuse.setBackground(new Color(0,240,255));
		add(panelZaUkuse, BorderLayout.SOUTH);
	}
	
	
	
	public static void main(String[] args) {
		new Sladoleddzinica();
	}
}
