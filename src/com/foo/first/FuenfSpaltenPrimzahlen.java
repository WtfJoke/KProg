package com.foo.first;

import java.util.ArrayList;
import java.util.List;

/**
 * Calculates and prints the prime numbers in several columns
 * 
 * @author Phi Long Tran<191624>, Homa Alavi <191720>, Manuel Wessner<191711>
 */
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

	private static void sendAll(List<Primer> primers) {
		for (Primer primer : primers) {
			send(primer);
		}
	}

	private static void stopAll(List<Primer> primers) {
		for (Primer primer : primers) {
			stop(primer);
		}
	}

	private static void send(Primer primer) {
		for (int i = 3; i <= PRIMEMAX; primer.send(i++)) {
		}
	}

	private static void stop(Primer primer) {
		primer.send(0);
	}

}
