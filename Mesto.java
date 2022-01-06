package domaci1;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;

public class Mesto extends Canvas implements Runnable{
	private Aparat owner;
	private Sladoled sladoled;
	private Ukus trenutniUkus;
	private Thread tocenje;
	private int flag = 0;
	private boolean pauza = false;
	
	


	
	public Mesto(Aparat a) {
		owner = a;
		setPreferredSize(new Dimension(240,240));
	}

	
	public Sladoled getSladoled() {
		return sladoled;
	}
	
																													//OBOJI METODA
	private synchronized void oboji(Graphics g) {
		flag++;
		g.setColor(trenutniUkus.retBoja());
		g.fillRect(0, this.getHeight()-20*this.getHeight()/(sladoled.max_velicina)*flag, 
				  this.getWidth(), 20*this.getHeight()/(sladoled.max_velicina));
	}
	
																													//RUN METODA
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				
					synchronized (this) {
						while(pauza) wait();
					}
				
				sladoled.dodajUkus(trenutniUkus, 20);
				oboji(this.getGraphics());
				owner.postaviTekstLabeli(sladoled.toString());
				
				if(sladoled.tren_velicina == sladoled.max_velicina) break;
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {}
		
		
		synchronized (owner) {
			owner.omoguciProdaju();
		}
		
		synchronized (this) {
			flag = 0;
			tocenje = null;
			notify();
		}
	}
	
	
																													//AKCIJE SA TOCENJIMA
	public synchronized void pokreniTocenje() {
		revalidate();
		sladoled = new Sladoled(200);
		pauza = false;
		tocenje = new Thread(this);
		tocenje.start();
	}
	
	
	public synchronized void privremenoZaustavi() {
		pauza = true;
	}
	
	
	public synchronized void nastaviTocenje() {
		pauza = false;
		notify();
	}
	
	
	public boolean ispitajTocenje() {
		if(tocenje != null) return true;
		else return false;
	}

	
	public synchronized void zavrsiTocenje() {
		if(tocenje != null) {
			tocenje.interrupt();
		}
		repaint();
		
		while(tocenje != null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
	}
	

	public synchronized void postaviTrenutniUkus(Ukus trenutniUkus) {
		this.trenutniUkus = trenutniUkus;
	}
}
