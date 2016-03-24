package com.foo.second;

import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.Timer;

public class RainbowWindow extends Frame {

	private static final long serialVersionUID = 4584500569164978315L;

	public RainbowWindow() {
		addWindowListener(new WindowQuitter());
		setSize(400, 300);
		setVisible(true);
		setLayout(new FlowLayout());
		Timer timer = new Timer(750, new SwitchColorActionListener(this, ColorPicker.getRainbowColors()));
		timer.start();
	}
}
