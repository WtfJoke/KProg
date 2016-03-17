package com.foo.first;

import java.util.ArrayList;
import java.util.List;

public class FuenfSpaltenPrimzahlen {

	private static final int PRIMEMAX = 5000;

	public static void main(String[] args) {
		List<Primer> primers = new ArrayList<>();
		primers.add(new Primer(2, 0));
		primers.add(new Primer(2, 2));
		primers.add(new Primer(2, 4));
		primers.add(new Primer(2, 6));
		primers.add(new Primer(2, 8));

		sendAll(primers);
		stopAll(primers);
	}

	static void sendAll(List<Primer> primers) {
		for (Primer primer : primers) {
			send(primer);
		}
	}

	static void stopAll(List<Primer> primers) {
		for (Primer primer : primers) {
			stop(primer);
		}
	}

	static void send(Primer primer) {
		for (int i = 3; i <= PRIMEMAX; primer.send(i++)) {
		}
	}

	static void stop(Primer primer) {
		primer.send(0);
	}

}
