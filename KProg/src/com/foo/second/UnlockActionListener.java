package com.foo.second;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
		Integer actionAsInt = Integer.valueOf(actionCommand);
		if (actionAsInt == unlockCode.get(currentListPosition)) {
			userCode.add(Integer.valueOf(actionAsInt));
			belongToFrame.setBackground(Color.green);
			currentListPosition++;
			if (userCode.equals(unlockCode)) {
				System.exit(0);
			}
		} else {
			currentListPosition = 0;
			userCode.clear();
			belongToFrame.setBackground(Color.red);
		}

	}

}
