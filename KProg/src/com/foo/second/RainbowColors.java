package com.foo.second;

import static java.awt.Color.blue;
import static java.awt.Color.cyan;
import static java.awt.Color.green;
import static java.awt.Color.magenta;
import static java.awt.Color.orange;
import static java.awt.Color.red;
import static java.awt.Color.yellow;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public enum RainbowColors implements Colorable {
	RED(red), ORANGE(orange), YELLOW(yellow), GREEN(green), BLUE(blue), CYAN(cyan), MAGENTA(magenta);

	private final Color color;

	private RainbowColors(Color color) {
		this.color = color;
	}

	Color get() {
		return color;
	}

	public List<Color> getCorrespondingColors() {
		List<Color> colors = new ArrayList<>();
		for (RainbowColors colorEnum : values()) {
			colors.add(colorEnum.get());
		}
		return colors;
	}
}
