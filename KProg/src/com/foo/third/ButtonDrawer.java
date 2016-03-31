package com.foo.third;

import java.awt.ComponentOrientation;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public abstract class ButtonDrawer {

	private static final int CENTER_DOWN_EMPTY_GRID_LOCATION = 7;
	private static final int CENTER_UP_EMPTY_GRID_LOCATION = 4;
	private static JPanel eastButtonPanel;
	private static JPanel westButtonPanel;
	private static JPanel northButtonPanel;
	private static JPanel southButtonPanel;

	static {
		eastButtonPanel = new JPanel();
		eastButtonPanel.setLayout(new BoxLayout(eastButtonPanel, BoxLayout.Y_AXIS));
		westButtonPanel = new JPanel();
		westButtonPanel.setLayout(new BoxLayout(westButtonPanel, BoxLayout.PAGE_AXIS));
		westButtonPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

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
		for (int i = 0; i < buttons.size(); i++) {
			JButton button = buttons.get(i);
			if (i < 3) {
				northButtonPanel.add(button);
				// } else if (i == 8 || i == 9) {
				// westButtonPanel.add(button);
			} else if (i == 3 || i == 4) {
				eastButtonPanel.add(button);
			} else {
				southButtonPanel.add(button);
			}
		}

		westButtonPanel.add(buttons.get(9));
		westButtonPanel.add(buttons.get(8));
		// westButtonPanel.getComponent(9);

		// addEmptyCellsInCenter(buttonPanel);

	}

	// private static void addEmptyCellsInCenter(Container contentPane) {
	// contentPane.add(new JLabel(""), null, CENTER_UP_EMPTY_GRID_LOCATION);
	// contentPane.add(new JLabel(""), null, CENTER_DOWN_EMPTY_GRID_LOCATION);
	// }

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
