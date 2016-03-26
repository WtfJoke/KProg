package com.foo.second;

import static java.awt.Color.black;
import static java.awt.Color.blue;
import static java.awt.Color.cyan;
import static java.awt.Color.gray;
import static java.awt.Color.green;
import static java.awt.Color.lightGray;
import static java.awt.Color.magenta;
import static java.awt.Color.orange;
import static java.awt.Color.pink;
import static java.awt.Color.red;
import static java.awt.Color.white;
import static java.awt.Color.yellow;

import java.awt.Color;

/**
 * Enum definition of couple of colors
 *
 * @author Manuel Wessner <191711>
 * @author Phi Long Tran <191624>
 * @author Steve Nono <191709>
 * 
 */
public enum Colors {

	BLACK(black), BLUE(blue), CYAN(cyan), GRAY(gray), GREEN(green), LIGHTGRAY(lightGray), MAGENTA(magenta), ORANGE(
			orange), PINK(pink), RED(red), WHITE(white), YELLOW(yellow);

	private final Color color;

	private Colors(Color color) {
		this.color = color;
	}

	Color get() {
		return color;
	}
}
