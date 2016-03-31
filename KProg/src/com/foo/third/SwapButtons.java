package com.foo.third;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;

public class SwapButtons implements ActionListener {

	private List<JButton> buttons;
	private static boolean clockwise;

	public SwapButtons(List<JButton> buttons) {
		this.buttons = buttons;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (clockwise) {
			Collections.rotate(buttons, 1);
		} else {
			Collections.rotate(buttons, -1);
		}
		ButtonDrawer.redraw(buttons);
	}

	public static void switchdirection() {
		clockwise = !clockwise;
	}
}
