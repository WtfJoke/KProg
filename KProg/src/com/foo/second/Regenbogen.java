package com.foo.second;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Regenbogen extends Frame {

	private static final long serialVersionUID = 4860837199461628871L;
	private Button newWindowRainbow = new Button("New Window");

	public Regenbogen() {
		addWindowListener(new WindowQuitter());
		setSize(400, 300);
		setVisible(true);
		setLayout(new FlowLayout());
		add(newWindowRainbow);
		newWindowRainbow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Regenbogen();
			}
		});
		Timer timer = new Timer(750, new SwitchColorActionListener(this, RainbowColors.BLUE));
		timer.start();
	}

	public static void main(String[] args) {
		new Regenbogen();
	}
}
