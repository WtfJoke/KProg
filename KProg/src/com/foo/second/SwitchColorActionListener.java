package com.foo.second;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Action listener, which switches the background-color from a given list
 * 
 * @author manue
 *
 */
public class SwitchColorActionListener implements ActionListener {

	private int currentColorIndex;
	private final List<Color> colorsToSwitch;
	private final Frame correspondingFrame;

	public SwitchColorActionListener(Frame correspondingFrame, List<Color> colorsToSwitch) {
		this.correspondingFrame = correspondingFrame;
		this.colorsToSwitch = colorsToSwitch;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		correspondingFrame.setBackground(colorsToSwitch.get(getIndex()));
	}

	private int getIndex() {
		if (currentColorIndex++ >= colorsToSwitch.size() - 1) {
			currentColorIndex = 0;
		}
		return currentColorIndex;
	}

}
