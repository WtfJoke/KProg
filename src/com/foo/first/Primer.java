package com.foo.first;

/**
 * Calculates the next prime numbers from a given number
 */
public class Primer extends Thread {
	private int p; // die Primzahl dieses Primers
	private Primer next; // der nächste Primer in der "Pipe"
	private int buffer = -1;
	private String indent;
	private int pipe;

	Primer(int prime, int pipe) { // Konstuktor
		super("Primer-" + prime); // Name eintragen
		p = prime; // Primzahl eintragen
		indent = getIndent(pipe);
		this.pipe = pipe;
		this.start(); // Thread sofort starten
	}

	// ... weitere Variablen und Methoden ...
	public static void main(String args[]) {
		Primer first = new Primer(2, 0); // ersten Primer : 2
		for (int i = 3; i <= 10000; first.send(i++))
			; // weitere
		first.send(0); // Abbruchmitteilung
		System.out.println(currentThread() + " main beendet");
	}

	@Override
	public void run() {
		System.out.println(indent + p);
		while (true) {
			int n = receive();
			if (n == 0) {
				if (next != null) {
					next.send(n);
				}
				break;
			} else if (n % p != 0) {
				if (next != null) {
					next.send(n);
				} else {
					next = new Primer(n, pipe);
				}

			}
		}
	}

	synchronized void send(int i) {
		try {
			while (buffer >= 0) {
				wait();
			}
			buffer = i;
			notify();
		} catch (InterruptedException e) {
		}
	}

	synchronized int receive() {
		int result = 0;
		try {
			while ((result = buffer) < 0) {
				wait();
			}
			buffer = -1;
			notify();
		} catch (InterruptedException e) {
		}
		return result;
	}

	private String getIndent(int pipe) {
		String indents = "";
		for (int i = 0; i < pipe; i++) {
			indents += "\t";
		}
		return indents;
	}

}
