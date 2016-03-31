package com.foo.third;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

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
		Container contentPane = frame.getContentPane();
		contentPane.removeAll();
		for (JButton button : buttons) {
			contentPane.add(button);
		}
		contentPane.add(new JLabel(""), null, 4); // empty cell
		contentPane.add(new JLabel(""), null, 7); // empty cell
		SwingUtilities.updateComponentTreeUI(frame);
	}

	public void switchdirection() {
		clockwise = !clockwise;
	}
}
