package com.foo.second;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.List;

public class DutzendFarben extends Frame {
	private static final long serialVersionUID = 6625931553571415973L;

	public DutzendFarben() {
		setLayout(new FlowLayout());
		addButtons(ColorButtons.get());
		addColorButtonActionListeners(ColorButtons.get());
	}

	public static void main(String[] args) {
		DutzendFarben frm = new DutzendFarben();
		frm.addWindowListener(new WindowQuitter());
		frm.setSize(400, 300);
		frm.setVisible(true);
	}

	private void addButtons(List<Button> buttons) {
		for (Button button : buttons) {
			add(button);
		}
	}

	private void addColorButtonActionListeners(List<Button> buttons) {
		ColorButtonActionListener actionListener = new ColorButtonActionListener(this);
		for (Button button : buttons) {
			button.addActionListener(actionListener);
		}
	}
}
