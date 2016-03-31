package com.foo.third;

import java.awt.Container;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public abstract class ButtonDrawer {

	private static final int CENTER_DOWN_EMPTY_GRID_LOCATION = 7;
	private static final int CENTER_UP_EMPTY_GRID_LOCATION = 4;

	static void redraw(Container contentPane, List<JButton> buttons) {
		contentPane.removeAll();
		draw(contentPane, buttons);
	}

	static void draw(Container contentPane, List<JButton> buttons) {
		for (JButton button : buttons) {
			contentPane.add(button);
		}
		addEmptyCellsInCenter(contentPane);
		SwingUtilities.updateComponentTreeUI(contentPane);
	}

	private static void addEmptyCellsInCenter(Container contentPane) {
		contentPane.add(new JLabel(""), null, CENTER_UP_EMPTY_GRID_LOCATION);
		contentPane.add(new JLabel(""), null, CENTER_DOWN_EMPTY_GRID_LOCATION);
	}
}
