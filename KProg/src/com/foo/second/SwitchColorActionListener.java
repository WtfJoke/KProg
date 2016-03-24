package com.foo.second;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchColorActionListener implements ActionListener {

	private SwitchColor switchColor;

	public SwitchColorActionListener(Frame correspondingFrame) {
		switchColor = new SwitchColor(correspondingFrame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switchColor.switchIt();
	}
}
