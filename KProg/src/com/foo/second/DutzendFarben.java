package com.foo.second;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.List;

/**
 * Frame, which has couple of buttons, which changes the background color
 *
 * @author manue
 */
public class DutzendFarben extends Frame {
	private static final long serialVersionUID = 6625931553571415973L;

	public DutzendFarben() {
		setLayout(new FlowLayout());
		addColorButtons();
		addColorButtonActionListeners();
	}

	public static void main(String[] args) {
		DutzendFarben frm = new DutzendFarben();
		frm.addWindowListener(new WindowQuitter());
		frm.setSize(400, 300);
		frm.setVisible(true);
	}

	private void addColorButtons() {
		List<Button> buttons = ColorButtons.get();
		for (Button button : buttons) {
			add(button);
		}
	}

	private void addColorButtonActionListeners() {
		List<Button> buttons = ColorButtons.get();
		ColorButtonActionListener actionListener = new ColorButtonActionListener(this);
		for (Button button : buttons) {
			button.addActionListener(actionListener);
		}
	}
}
