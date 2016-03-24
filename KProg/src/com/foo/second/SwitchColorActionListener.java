package com.foo.second;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SwitchColorActionListener implements ActionListener {

	private int currentColorIndex;
	private final List<Color> correspondingColors;
	private final Frame correspondingFrame;

	public SwitchColorActionListener(Frame correspondingFrame) {
		this.correspondingFrame = correspondingFrame;
		this.correspondingColors = Colors.getCorrespondingColors();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		correspondingFrame.setBackground(correspondingColors.get(getIndex()));
	}

	private int getIndex() {
		if (currentColorIndex++ >= correspondingColors.size()) {
			currentColorIndex = 0;
		}
		return currentColorIndex;
	}

}
