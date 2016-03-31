package com.foo.second;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Holds the logic, for unlock a guessed code
 * 
 * @author Manuel Wessner <191711>
 * @author Phi Long Tran <191624>
 * @author Steve Nono <191709>
 */
public class UnlockActionListener implements ActionListener {

	private int currentListPosition;
	private final Frame belongToFrame;
	private final List<Integer> unlockCode;
	private final List<Integer> userCode;

	public UnlockActionListener(Frame belongToFrame, List<Integer> unlockCode) {
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
			belongToFrame.setBackground(Color.green);
			currentListPosition++;
			boolean isUnlocked = userCode.equals(unlockCode);
			if (isUnlocked) {
				System.exit(0);
			}
		} else {
			currentListPosition = 0;
			userCode.clear();
			belongToFrame.setBackground(Color.red);
		}

	}

}
