package com.foo.second;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

public class Schloss extends Frame {
	private static final long serialVersionUID = 2624446559320231971L;
	private Button button0 = new Button("0");
	private Button button1 = new Button("1");
	private Button button2 = new Button("2");
	private Button button3 = new Button("3");
	private Button button4 = new Button("4");
	private Button button5 = new Button("5");
	private Button button6 = new Button("6");
	private Button button7 = new Button("7");
	private Button button8 = new Button("8");
	private Button button9 = new Button("9");
	private List<Integer> unlockCode;

	public Schloss() {
		addWindowListener(new WindowQuitter());
		setSize(1000, 400);
		setVisible(true);
		setLayout(new FlowLayout());
		createUnlockCode();
		addButtons(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9);
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

	private void addButtons(Button... buttons) {
		UnlockActionListener unlockActionListener = new UnlockActionListener(this, unlockCode);
		for (Button button : buttons) {
			add(button);
			button.setActionCommand(button.getLabel());
			button.addActionListener(unlockActionListener);
		}
	}
}
