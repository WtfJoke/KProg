package com.foo.third;

import java.awt.ComponentOrientation;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public abstract class ButtonDrawer {

	private static JPanel eastButtonPanel;
	private static JPanel westButtonPanel;
	private static JPanel northButtonPanel;
	private static JPanel southButtonPanel;

	static {
		eastButtonPanel = new JPanel();
		eastButtonPanel.setLayout(new BoxLayout(eastButtonPanel, BoxLayout.Y_AXIS));
		westButtonPanel = new JPanel();
		westButtonPanel.setLayout(new BoxLayout(westButtonPanel, BoxLayout.Y_AXIS));

		northButtonPanel = new JPanel();
		northButtonPanel.setLayout(new BoxLayout(northButtonPanel, BoxLayout.X_AXIS));

		southButtonPanel = new JPanel();
		southButtonPanel.setLayout(new BoxLayout(southButtonPanel, BoxLayout.LINE_AXIS));
		southButtonPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

	}

	static void redraw(List<JButton> buttons) {
		eastButtonPanel.removeAll();
		draw(buttons);
		SwingUtilities.updateComponentTreeUI(eastButtonPanel);
	}

	static void draw(List<JButton> buttons) {
		JButton postponedWestButton = null;
		for (int i = 0; i < buttons.size(); i++) {
			JButton button = buttons.get(i);
			if (i < 3) {
				northButtonPanel.add(button);
			} else if (i == 3 || i == 4) {
				eastButtonPanel.add(button);
			} else if (i == 8) {
				postponedWestButton = button;
			} else if (i == 9) {
				westButtonPanel.add(button);
			} else {
				southButtonPanel.add(button);
			}
		}

		if (postponedWestButton != null) {
			westButtonPanel.add(postponedWestButton);
		}

	}

	static JPanel getEastButtonPanel() {
		return eastButtonPanel;
	}

	public static JPanel getNorthButtonPanel() {
		return northButtonPanel;
	}

	public static JPanel getWestButtonPanel() {
		return westButtonPanel;
	}

	public static JPanel getSouthButtonPanel() {
		return southButtonPanel;
	}

}
