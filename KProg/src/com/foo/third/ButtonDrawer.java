package com.foo.third;

import java.awt.ComponentOrientation;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Responsible for fill buttons in correct panels
 * 
 * @author manue
 *
 */
public abstract class ButtonDrawer {

	private static JPanel eastButtonPanel;
	private static JPanel westButtonPanel;
	private static JPanel northButtonPanel;
	private static JPanel southButtonPanel;

	static {
		// create panels with boxlayouts
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

	/**
	 * Fill panels and redraw afterwards to update the frame
	 */
	static void refillPanels(List<JButton> buttons) {
		fillPanels(buttons);
		redraw();
	}

	/**
	 * After redraw
	 */
	static void redraw() {
		SwingUtilities.updateComponentTreeUI(northButtonPanel);
		SwingUtilities.updateComponentTreeUI(southButtonPanel);
		SwingUtilities.updateComponentTreeUI(westButtonPanel);
		SwingUtilities.updateComponentTreeUI(eastButtonPanel);
	}

	/**
	 * Fill left, right, top and bottom panels
	 */
	static void fillPanels(List<JButton> buttons) {
		JButton postponedWestButton = null;
		for (int i = 0; i < buttons.size(); i++) {
			JButton button = buttons.get(i);
			if (i < 3) {
				northButtonPanel.add(button);
			} else if (i == 3 || i == 4) {
				eastButtonPanel.add(button);
			} else if (i == 8) {
				// temporary remember button from this position
				postponedWestButton = button;
			} else if (i == 9) {
				westButtonPanel.add(button);
			} else {
				southButtonPanel.add(button);
			}
		}

		if (postponedWestButton != null) {
			// add temporary button at the end
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
