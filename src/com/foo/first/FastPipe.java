package com.foo.first;

/**
 * Creates elements from 1 to {@link #MAX}. And prints them in a pipe
 * 
 * @author Phi Long Tran<191624>, Homa Alavi <191720>, Manuel Wessner<191711>
 */
public class FastPipe {

	private static int MAX = 100000;

	public static void main(String[] args) {
		Element element = new Element(1);
		for (int i = 2; i <= MAX; element.send(i++)) {
		}
		element.send(0);
	}

}
