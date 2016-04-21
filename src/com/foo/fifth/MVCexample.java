package com.foo.fifth;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
// for Observer and Observable 
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

/**
 * !Translate: Das ist ein View fuer textuelle Darstellung eines Quadratischen
 * Polynoms! Class which
 * 
 *
 */
class TextQView extends JPanel implements Observer // Spectator
{
	private static final long serialVersionUID = 1L;
	private JTextField a = new JTextField(10), // Textfields for
			b = new JTextField(10), // three coefficients
			c = new JTextField(10); // ...
	private JLabel constantLabel = new JLabel("Konstante", JLabel.RIGHT),
			linearCoefficientLabel = new JLabel("Linearer Koeffizient", JLabel.RIGHT),
			squareCoefficientLabel = new JLabel("Quadratischer Koeffizient", JLabel.RIGHT);
	private Qpolynom myPolynom; // das Modell, ein Polynom

	TextQView(Qpolynom q) {
		myPolynom = q; // merke Polynom
		setLayout(new GridLayout(3, 2, 5, 5)); // 3x2-Grid, 5-er Abstaende
		add(constantLabel);
		add(a); // Labels und Textfelder
		add(linearCoefficientLabel);
		add(b); // hinzufuegen
		add(squareCoefficientLabel);
		add(c); // ...
		a.setEditable(false);
		b.setEditable(false); // Editierbarkeit
		c.setEditable(false); // der Textfelder
	} // end constructor
		// ..
		// ..

	public void update(Observable o, Object arg) {
		if (o == myPolynom) {
			repaint(); // neu darstellen
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // super aufrufen
		a.setText("" + myPolynom.getConstant()); // Textfelder neu schreiben
		b.setText("" + myPolynom.getLinear()); // dabei get... Methoden
		c.setText("" + myPolynom.getQuadratic()); // aus Modell benutzen
	}
} // end TextQView

/**
 * Class which ...
 */
class Qpolynom extends Observable // Beobachtbares
{
	private int // interne Daten
	constant, linear, quadratic; // Polynom-Koeffizienten

	public Qpolynom(int a, int b, int c) // Konstuktor
	{
		constant = a;
		linear = b;
		quadratic = c;
	} // end Konstuktor

	/**
	 * Method which returns ...
	 * 
	 * @return constant
	 */
	public int getConstant() {
		return constant; // konstanter Koeffizient
	}

	/**
	 * Method which returns ...
	 * 
	 * @return linear
	 */
	public int getLinear() {
		return linear; // linearer Koeffizient
	}

	/**
	 * Method which returns ...
	 * 
	 * @return quadratic
	 */
	public int getQuadratic() {
		return quadratic; // quadratischer Koeffizient
	}

	/**
	 * Method which set
	 * 
	 * @param n
	 */
	public void setConstant(int n) {
		constant = n; // konstanter Koeffizient
		setChanged();
		notifyObservers();
	}

	/**
	 * Method which set
	 * 
	 * @param n
	 */
	public void setLinear(int n) {
		linear = n; // linearer Koeffizient
		setChanged();
		notifyObservers();
	}

	/**
	 * Method which set
	 * 
	 * @param n
	 */
	public void setQuadratic(int n) {
		quadratic = n; // quadratischer Koeffizient
		setChanged();
		notifyObservers();
	}
} // end Qpolynom

/**
 * Class which ...
 * 
 *
 */
public class MVCexample extends JApplet // Das GUI-Programm
{
	private static final long serialVersionUID = 1L;
	JSlider sa, sb, sc; // Controller

	/**
	 * Method which initialize ...
	 * 
	 */
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

		sa.addChangeListener(new ChangeListener() // Listener, i.Kl.
		{
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

		// changed
		TextQView textView1 = new TextQView(p); // 1. View
		GraphQView graphView = new GraphQView(p); // nach Uebung
		TextQView textView2 = new TextQView(p); // 2. View

		p.addObserver(textView1); // Views als Observer registrieren
		p.addObserver(textView2); // ..

		cp.add(textView1); // Views zum Fenster hinzufuegen
		cp.add(textView2); // ..
		// ...
		// ...
		cp.add(sa); // Controller hinzufuegen
		cp.add(sb); // ...
		cp.add(sc); // ...

	} // end init

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Konsole.run(new MVCexample(), 400, 500); // Konsolenstart
	}
} // end MVCexample

/**
 * Class Console ...
 *
 */
class Konsole {
	/**
	 * Method which returns ...
	 * 
	 * @param o
	 * @return t
	 */
	public static String title(Object o) {
		String t = o.getClass().toString();
		if (t.indexOf("class") != -1)
			t = t.substring(6);
		System.out.println("Konsole: running " + t);
		return t;
	}

	/**
	 * Method which ...
	 * 
	 * @param frame
	 */
	public static void setupClosing(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Method which ...
	 * 
	 * @param frame
	 * @param width
	 * @param height
	 */
	public static void run(JFrame frame, int width, int height) {
		setupClosing(frame);
		frame.setSize(width, height);
		frame.setVisible(true);
	}

	/**
	 * Method which ...
	 * 
	 * @param applet
	 * @param width
	 * @param height
	 */
	public static void run(JApplet applet, int width, int height) {
		JFrame frame = new JFrame(title(applet));
		setupClosing(frame);
		frame.getContentPane().add(applet);
		frame.setSize(width, height);
		applet.init();
		applet.start();
		frame.setVisible(true);
	}

	/**
	 * Method which ...
	 * 
	 * @param panel
	 * @param width
	 * @param height
	 */
	public static void run(JPanel panel, int width, int height) {
		JFrame frame = new JFrame(title(panel));
		setupClosing(frame);
		frame.getContentPane().add(panel);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
}