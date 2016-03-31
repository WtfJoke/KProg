package com.foo.third;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

/**
 * Holds the logic, for unlock a guessed code
 * 
 * @author Manuel Wessner <191711>
 * @author Phi Long Tran <191624>
 * @author Steve Nono <191709>
 */
public class UnlockActionListener implements ActionListener {

	private int currentListPosition;
	private final JFrame belongToFrame;
	private final List<Integer> unlockCode;
	private final List<Integer> userCode;

	public UnlockActionListener(JFrame belongToFrame, List<Integer> unlockCode) {
		this.belongToFrame = belongToFrame;
		this.unlockCode = unlockCode;
		this.userCode = new ArrayList<>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
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
		}
	}

	private void setBackground(Color color) {
		Component[] components = belongToFrame.getContentPane().getComponents();
		for (int i = 0; i < components.length; i++) {
			Component component = components[i];
			component.setBackground(color);
		}
	}

}
