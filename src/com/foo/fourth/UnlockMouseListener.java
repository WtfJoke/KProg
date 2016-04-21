package com.foo.fourth;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

/**
 * Holds the logic, for unlock a guessed code
 * 
 * @author Manuel Wessner <191711>
 * @author Phi Long Tran <191624>
 * @author Steve Nono <191709>
 */
public class UnlockMouseListener extends MouseMotionAdapter {

	private int currentListPosition;
	private final List<Integer> unlockCode;
	private final List<Integer> userCode;
	private final List<JButton> buttons;
	private boolean isProcessing;

	public UnlockMouseListener(List<Integer> unlockCode, List<JButton> buttons) {
		this.unlockCode = unlockCode;
		this.buttons = buttons;
		this.userCode = new ArrayList<>();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (isProcessing) {
			return;
		} else {
			isProcessing = true;
			Object source = e.getSource();
			if (source instanceof JButton) {
				JButton button = JButton.class.cast(source);
				String actionCommand = button.getText();
				Integer userInput = Integer.valueOf(actionCommand);
				if (userInput.equals(unlockCode.get(currentListPosition))) {
					userCode.add(userInput);
					setBackground(Color.green);
					currentListPosition++;
					boolean isUnlocked = userCode.equals(unlockCode);
					if (isUnlocked) {
						System.exit(0);
					}
				} else {
					currentListPosition = 0;
					userCode.clear();
					setBackground(Color.red);
					RotateButtons.switchdirection();
					Schloss.createFasterSchloss();
				}
			}
			isProcessing = false;
		}
	}

	private void setBackground(Color color) {
		for (JButton button : buttons) {
			button.setBackground(color);
		}
	}

}
