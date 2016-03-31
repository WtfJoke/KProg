package com.foo.third;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;

/**
 * Rotates the buttons on the frame
 * 
 * @author Manuel Wessner <191711>
 * @author Phi Long Tran <191624>
 * @author Steve Nono <191709>
 */
public class RotateButtons implements ActionListener {

	private List<JButton> buttons;
	private static boolean clockwise;

	public RotateButtons(List<JButton> buttons) {
		this.buttons = buttons;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (clockwise) {
			Collections.rotate(buttons, 1); // rotates clockwise
		} else {
			Collections.rotate(buttons, -1); // rotates counterclockwise
		}
		ButtonDrawer.refillPanels(buttons); // redraw
	}

	/**
	 * Switch rotation
	 */
	public static void switchdirection() {
		clockwise = !clockwise;
	}
}
