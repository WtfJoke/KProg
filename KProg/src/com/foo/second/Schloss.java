package com.foo.second;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

/**
 * Frame, which is used to guess a secret code
 * 
 * @author Manuel Wessner <191711>
 * @author Phi Long Tran <191624>
 * @author Steve Nono <191709>
 *
 */
public class Schloss extends Frame {
	private static final long serialVersionUID = 2624446559320231971L;
	private static final int AMOUNTOFBUTTONS = 10;
	private List<Integer> unlockCode;

	public Schloss() {
		addWindowListener(new WindowQuitter());
		setSize(1000, 400);
		setVisible(true);
		setLayout(new FlowLayout());
		createUnlockCode();
		addButtons();
	}

	private void createUnlockCode() {
		unlockCode = new ArrayList<>();
		unlockCode.add(Integer.valueOf(2));
		unlockCode.add(Integer.valueOf(3));
		unlockCode.add(Integer.valueOf(0));
		unlockCode.add(Integer.valueOf(3));
		unlockCode.add(Integer.valueOf(6));
		unlockCode.add(Integer.valueOf(0));
	}

	public static void main(String[] args) {
		new Schloss();
	}

	private void addButtons() {
		UnlockActionListener unlockActionListener = new UnlockActionListener(this, unlockCode);
		for (int i = 0; i < AMOUNTOFBUTTONS; i++) {
			Button button = new Button(String.valueOf(i));
			add(button);
			button.setActionCommand(button.getLabel());
			button.addActionListener(unlockActionListener);
		}
	}
}
