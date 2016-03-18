package com.foo.first;

public class FastPipe {

	private static int MAX = 100000;

	public static void main(String[] args) {
		Element element = new Element(1);
		for (int i = 2; i <= MAX; element.send(i++)) {
		}
		element.send(0);
	}

}
