package com.foo.first;

public class Element extends Thread {

	private int i;
	private Element next;
	private int buffer = -1;

	public Element(int p) {
		this.i = p;
		System.out.println("I've just got born, im element nr " + p);
		this.start();
	}

	@Override
	public void run() {
		System.out.println(i);
		while (true) {
			int n = receive();
			if (n == 0) {
				if (next != null) {
					next.send(n);
				}
				break;
			} else {
				if (next != null) {
					next.send(n);
				} else {
					next = new Element(n);
				}
			}
		}
		System.out.println("Hello im Element " + i + " im dying, please help! :(");
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
}
