package com.foo.second;

import java.awt.Button;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public final class ColorButtons {

	private static List<Button> colorButtons;

	private static void initializeButtons() {
		colorButtons = new ArrayList<>();
		colorButtons.add(new ColorButton(Color.black, "Black"));
		colorButtons.add(new ColorButton(Color.blue, "Blue"));
		colorButtons.add(new ColorButton(Color.cyan, "Cyan"));
		colorButtons.add(new ColorButton(Color.gray, "Gray"));
		colorButtons.add(new ColorButton(Color.green, "Green"));
		colorButtons.add(new ColorButton(Color.lightGray, "Light Gray"));
		colorButtons.add(new ColorButton(Color.magenta, "Magenta"));
		colorButtons.add(new ColorButton(Color.orange, "Orange"));
		colorButtons.add(new ColorButton(Color.pink, "Pink"));
		colorButtons.add(new ColorButton(Color.red, "Red"));
		colorButtons.add(new ColorButton(Color.white, "White"));
		colorButtons.add(new ColorButton(Color.yellow, "Yellow"));
	}

	public static List<Button> get() {
		if (colorButtons == null) {
			initializeButtons();
		}
		return colorButtons;
	}
}
