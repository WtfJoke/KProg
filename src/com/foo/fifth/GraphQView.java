package com.foo.fifth;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * !Translate: Das ist ein View fuer graphische Darstellung eines Quadratischen
 * Polynoms! Class which ...
 */
class GraphQView extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	// Plotter
	static final int SCALEFACTOR = 200;// Konstante
	int cycles;// # Perioden
	int points;// # zu zeichnender Punkte
	double[] sines;// Funktions-Werte
	int[] pts;

	public GraphQView(Qpolynom p) {
		frame = new JFrame("Graphic");
		frame.setSize(512, 512);
		frame.getContentPane().add(this);
		frame.setVisible(true);
		setCycles(5);
		frame.setLayout(new BorderLayout());
	}

	public void setCycles(int newCycles)// Aendern der Perioden
	{
		cycles = Math.abs(newCycles); // Perioden setzen
		points = SCALEFACTOR * cycles * 2; // # Punkte berechnen
		sines = new double[points]; // Arrays dimensionieren
		pts = new int[points]; // ...
		for (int i = 0; i < points; i++) { // fuer jeden Punkt:
			double radians = (Math.PI / SCALEFACTOR) * i; // berechne Winkel
			sines[i] = Math.sin(radians); // ... und Funktionswert
		}
		repaint();
	}

	// Beobachter
	// Uebungsaufgabe!
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Qpolynom) {
			Qpolynom polynom = (Qpolynom) o;
			// setCycles(((Qpolynom) o)..getValue()); // Wert setzen
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // in Superklasse aufrufen ...
		int maxWidth = getWidth(); // Weite bestimmen
		double hstep = (double) maxWidth / (double) points; // horizontale
															// Schrittweite
		int maxHeight = getHeight(); // Hoehe Bestimmen
		for (int i = 0; i < points; i++) // fuer alle Punkte:
			pts[i] = (int) ((0.5 - sines[i] * 0.48) * maxHeight); // skalieren
		g.setColor(Color.red); // Farbe setzen
		for (int i = 1; i < points; i++) // fuer alle Punkte (bis auf ersten):
		{
			int x1 = (int) ((i - 1) * hstep);// bestimme x,y-Koordinaten
			int x2 = (int) (i * hstep);// des aktuellen Punkts und des
			int y1 = pts[i - 1];// linken Nachbarn
			int y2 = pts[i];//
			g.drawLine(x1, y1, x2, y2);// Zeichne Linie
		}
	} // end paintComponent
}