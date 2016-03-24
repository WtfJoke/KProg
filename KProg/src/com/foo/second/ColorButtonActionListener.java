package com.foo.second;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButtonActionListener implements ActionListener {

	private final Frame belongingFrame;

	public ColorButtonActionListener(Frame belongingFrame) {
		this.belongingFrame = belongingFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source instanceof ColorButton) {
			ColorButton colorButton = ColorButton.class.cast(source);
			belongingFrame.setBackground(colorButton.getColor());
		}
	}

}
