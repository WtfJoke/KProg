package com.foo.second;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Is responsible for providing a set of colors
 * 
 * @author manue
 *
 */
public class ColorPicker {

	static List<Color> getRainbowColors() {
		List<Color> colors = new ArrayList<>();
		for (RainbowColors colorEnum : RainbowColors.values()) {
			colors.add(colorEnum.get());
		}
		return colors;
	}

	static List<Color> getColors() {
		List<Color> colors = new ArrayList<>();
		for (Colors colorEnum : Colors.values()) {
			colors.add(colorEnum.get());
		}
		return colors;
	}
}
