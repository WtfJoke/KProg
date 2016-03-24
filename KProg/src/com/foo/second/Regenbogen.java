package com.foo.second;

import java.awt.FlowLayout;
import java.awt.Frame;

public class Regenbogen extends Frame {

	private static final long serialVersionUID = 4860837199461628871L;

	public Regenbogen() {
		addWindowListener(new WindowQuitter());
		setSize(400, 300);
		setVisible(true);
		setLayout(new FlowLayout());
	}

	public static void main(String[] args) {
		new Regenbogen();
	}
}
