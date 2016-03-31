package com.foo.third;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwapButtons implements ActionListener {

	private JFrame frame;
	private List<JButton> buttons;
	private boolean clockwise;

	public SwapButtons(JFrame frame, List<JButton> buttons) {
		this.frame = frame;
		this.buttons = buttons;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (clockwise) {
			Collections.rotate(buttons, 1);
		} else {
			Collections.rotate(buttons, -1);
		}
		ButtonDrawer.redraw(frame.getContentPane(), buttons);
	}

	public void switchdirection() {
		clockwise = !clockwise;
	}
}
