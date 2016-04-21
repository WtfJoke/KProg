package com.foo.fifth;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
// fuer Observer und Observable 
import java.util.Observable;
import java.util.Observer;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//  Das ist ein View fuer textuelle Darstellung eines Quadratischen Polynoms
class TextQView extends JPanel implements Observer { // Beobachter
	JTextField a = new JTextField(10), // Textfelder fuer
			b = new JTextField(10), // drei Koeffizienten
			c = new JTextField(10); // ...
	JLabel al = new JLabel("Konstante", JLabel.RIGHT), // Labels ...
			bl = new JLabel("Linearer Koeffizient", JLabel.RIGHT),
			cl = new JLabel("Quadratischer Koeffizient", JLabel.RIGHT);
	Qpolynom myPolynom; // das Modell, ein Polynom

	TextQView(Qpolynom q) { // Konstuktor
		myPolynom = q; // merke Polynom
		setLayout(new GridLayout(3, 2, 5, 5)); // 3x2-Grid, 5-er Abstaende
		add(al);
		add(a); // Labels und Textfelder
		add(bl);
		add(b); // hinzufuegen
		add(cl);
		add(c); // ...
		a.setEditable(false);
		b.setEditable(false); // Editierbarkeit
		c.setEditable(false); // der Textfelder
	} // end Konstuktor
		// ..
		// ..

	public void update(Observable o, Object arg) { // fuer Observer
		if (o == myPolynom)
			repaint(); // neu darstellen
	}

	public void paintComponent(Graphics g) { // Component darstllen
		super.paintComponent(g); // super aufrufen
		a.setText("" + myPolynom.getConstant()); // Textfelder neu schreiben
		b.setText("" + myPolynom.getLinear()); // dabei get... Methoden
		c.setText("" + myPolynom.getQuadratic()); // aus Modell benutzen
	}
} // end TextQView
	// Das ist ein View fuer graphische Darstellung eines Quadratischen Polynoms
	// class GraphQView extends JPanel implements Observer { // Beobachter
	// Uebungsaufgabe ....
	// } // end GraphQView
	// Das ist das Modell

class Qpolynom extends Observable { // Beobachtbares
	private int // interne Daten
	constant, linear, quadratic; // Polynom-Koeffizienten

	public Qpolynom(int a, int b, int c) { // Konstuktor
		constant = a;
		linear = b;
		quadratic = c;
	} // end Konstuktor

	public int getConstant() { // getter Methode
		return constant; // konstanter Koeffizient
	}

	// ...
	// ...
	public int getLinear() { // getter Methode
		return linear; // linearer Koeffizient
	}

	public int getQuadratic() { // getter Methode
		return quadratic; // quadratischer Koeffizient
	}

	public void setConstant(int n) { // setter Methode
		constant = n; // konstanter Koeffizient
		setChanged();
		notifyObservers();
	}

	public void setLinear(int n) { // setter Methode
		linear = n; // linearer Koeffizient
		setChanged();
		notifyObservers();
	}

	public void setQuadratic(int n) { // setter Methode
		quadratic = n; // quadratischer Koeffizient
		setChanged();
		notifyObservers();
	}
} // end Qpolynom

// ..
// ..
public class MVCexample extends JApplet { // Das GUI-Programm
	JSlider sa, sb, sc; // Controller

	public void init() {
		Container cp = getContentPane(); // Fenster-Container
		cp.setLayout(new GridLayout(5, 1, 10, 10)); // 5x1-Grid, 10-er Abstaende

		final Qpolynom p = new Qpolynom(1, 2, 3); // das Modell

		sa = new JSlider(SwingConstants.HORIZONTAL, -10, 10, 1); // Erzeugung
		sb = new JSlider(SwingConstants.HORIZONTAL, -10, 10, 2); // der
																	// Controller
		sc = new JSlider(SwingConstants.HORIZONTAL, -10, 10, 3); //

		sa.setMajorTickSpacing(10); // Parameter
		sa.setMinorTickSpacing(1);
		sa.setSnapToTicks(true);
		sb.setMajorTickSpacing(10);
		sb.setMinorTickSpacing(1);
		sb.setSnapToTicks(true);
		sc.setMajorTickSpacing(10);
		sc.setMinorTickSpacing(1);
		sc.setSnapToTicks(true);
		sa.setPaintTicks(true);
		sb.setPaintTicks(true);
		sc.setPaintTicks(true);

		// ...
		// ...
		sa.setPaintLabels(true); // Parameter
		sb.setPaintLabels(true);
		sc.setPaintLabels(true);

		sa.setPreferredSize(new Dimension(400, 70));
		sb.setPreferredSize(new Dimension(400, 70));
		sc.setPreferredSize(new Dimension(400, 70));

		sa.setBorder(new TitledBorder("Konstante")); // Border fuer
		sb.setBorder(new TitledBorder("Linearer Koeffizient")); // Schiebe-
		sc.setBorder(new TitledBorder("Quadratischer Koeffizient")); // Regler

		sa.addChangeListener(new ChangeListener() { // Listener, i.Kl.
			public void stateChanged(ChangeEvent evt) {
				JSlider source = (JSlider) evt.getSource();
				if (!source.getValueIsAdjusting()) {
					p.setConstant(source.getValue()); // set... benutzen
				}
			}
		});
		// ...
		// ...
		sb.addChangeListener(new ChangeListener() { // Listener, i.Kl.
			public void stateChanged(ChangeEvent evt) {
				JSlider source = (JSlider) evt.getSource();
				if (!source.getValueIsAdjusting()) {
					p.setLinear(source.getValue()); // set... benutzen
				}
			}
		});
		sc.addChangeListener(new ChangeListener() { // Listener, i.Kl.
			public void stateChanged(ChangeEvent evt) {
				JSlider source = (JSlider) evt.getSource();
				if (!source.getValueIsAdjusting()) {
					p.setQuadratic(source.getValue()); // set... benutzen
				}
			}
		});

		TextQView view1 = new TextQView(p); // 1. View
		// GraphQView view2 = new GraphQView (p); // nach Uebung
		TextQView view2 = new TextQView(p); // 2. View

		p.addObserver(view1); // Views als Observer registrieren
		p.addObserver(view2); // ..

		cp.add(view1); // Views zum Fenster hinzufuegen
		cp.add(view2); // ..
		// ...
		// ...
		cp.add(sa); // Controller hinzufuegen
		cp.add(sb); // ...
		cp.add(sc); // ...

	} // end init

	public static void main(String[] args) {
		Konsole.run(new MVCexample(), 400, 500); // Konsolenstart
	}
} // end MVCexample

// ********************************************************************************

class Konsole {
	public static String title(Object o) {
		String t = o.getClass().toString();
		if (t.indexOf("class") != -1)
			t = t.substring(6);
		System.out.println("Konsole: running " + t);
		return t;
	}

	public static void setupClosing(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void run(JFrame frame, int width, int height) {
		setupClosing(frame);
		frame.setSize(width, height);
		frame.setVisible(true);
	}

	public static void run(JApplet applet, int width, int height) {
		JFrame frame = new JFrame(title(applet));
		setupClosing(frame);
		frame.getContentPane().add(applet);
		frame.setSize(width, height);
		applet.init();
		applet.start();
		frame.setVisible(true);
	}

	public static void run(JPanel panel, int width, int height) {
		JFrame frame = new JFrame(title(panel));
		setupClosing(frame);
		frame.getContentPane().add(panel);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
}