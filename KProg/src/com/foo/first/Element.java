package com.foo.first;

/**
 * Represent a number, which will hold in a own thread.
 * 
 * @author Phi Long Tran<191624>, Homa Alavi <191720>, Manuel Wessner<191711>
 */
public class Element extends Thread {

	private final int number;
	private Element next;
	private int buffer = -1;

	public Element(int number) {
		this.number = number;
		System.out.println("I've just got born, im element nr " + number);
		this.start();
	}

	/**
	 * Creates dynamically new elements from a received number, which was send
	 * by method {@link #send(int)}. Abort in case 0 was received
	 * 
	 */
	@Override
	public void run() {
		System.out.println(number);
		while (true) {
			int receivedNumber = receive();
			if (receivedNumber == 0) {
				if (next != null) {
					next.send(receivedNumber);
				}
				break;
			} else {
				if (next != null) {
					next.send(receivedNumber);
				} else {
					next = new Element(receivedNumber);
				}
			}
		}
		System.out.println("Hello im Element " + number + " im dying, please help! :(");
	}

	private synchronized int receive() {
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
