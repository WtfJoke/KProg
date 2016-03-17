package com.foo.first;

public class Primer extends Thread {
	private int p; // die Primzahl dieses Primers
	private Primer next; // der nächste Primer in der "Pipe"
	private int buffer = -1;

	Primer(int prime) { // Konstuktor
		super("Primer-" + prime); // Name eintragen
		p = prime; // Primzahl eintragen
		this.start(); // Thread sofort starten
	}

	// ... weitere Variablen und Methoden ...
	public static void main(String args[]) {
		Primer first = new Primer(2); // ersten Primer : 2
		for (int i = 3; i <= 10000; first.send(i++))
			; // weitere
		first.send(0); // Abbruchmitteilung
		System.out.println(currentThread() + " main beendet");
	}
	
	@Override
	public void run() {
		System.out.println(currentThread() + " Primzahl: " + p);
		while(true){
			int n = receive();
			if (n == 0){
				if (next != null){
					next.send(n);
				}
				break;
			}else if (n % p != 0){
				if (next != null){
					next.send(n);
				}else{
					next = new Primer(n);
				}
					
			}
		}
	}
	
	synchronized void send(int i){
		try{
			while(buffer >=0){
				wait();
			}
			buffer = i;
			notify();
		}catch (InterruptedException e){}
	}
	
	synchronized int receive(){
		int result = 0;
		try{
			while((result=buffer)<0){
				wait();
			}
			buffer = -1;
			notify();
		}catch (InterruptedException e){}
		return result;
	}
	
}
