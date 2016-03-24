package com.foo.second;

import static java.awt.Color.blue;
import static java.awt.Color.cyan;
import static java.awt.Color.green;
import static java.awt.Color.magenta;
import static java.awt.Color.orange;
import static java.awt.Color.red;
import static java.awt.Color.yellow;

import java.awt.Color;

public enum RainbowColors {
	RED(red), ORANGE(orange), YELLOW(yellow), GREEN(green), BLUE(blue), CYAN(cyan), MAGENTA(magenta);

	private final Color color;

	private RainbowColors(Color color) {
		this.color = color;
	}

	Color get() {
		return color;
	}
}
