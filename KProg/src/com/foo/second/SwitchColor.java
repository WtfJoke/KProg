package com.foo.second;

import java.awt.Color;
import java.awt.Frame;
import java.util.List;

public class SwitchColor {

	private final Frame correspondingFrame;
	private final List<Color> correspondingColors;
	private int currentColorIndex;

	public SwitchColor(Frame correspondingFrame) {
		this.correspondingFrame = correspondingFrame;
		this.correspondingColors = Colors.getCorrespondingColors();
	}

	public void switchIt() {
		correspondingFrame.setBackground(correspondingColors.get(getIndex()));
	}

	private int getIndex() {
		if (currentColorIndex++ >= correspondingColors.size()) {
			currentColorIndex = 0;
		}
		return currentColorIndex;
	}
}
