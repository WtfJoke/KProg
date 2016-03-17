package com.foo.first;

public class FastPipe {

	private static int MAX = 10000;

	public static void main(String[] args) {
		Element element = new Element(1);
		for (int i = 1; i <= MAX; element.send(i++)) {
		}
		element.send(0);
	}

}
