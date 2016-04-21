package com.foo.second;

import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.Timer;

/**
 * Frame, which the background cycles in rainbow colors in a certain amount of
 * time
 * 
 * @author Manuel Wessner <191711>
 * @author Phi Long Tran <191624>
 * @author Steve Nono <191709>
 */
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
